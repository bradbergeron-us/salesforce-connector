/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce;

import org.apache.log4j.Logger;
import org.cometd.bayeux.Channel;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.client.ClientSessionChannel;
import org.cometd.client.BayeuxClient;
import org.cometd.client.transport.ClientTransport;
import org.mule.modules.salesforce.connection.strategy.SalesforceBasicAuthStrategy;
import org.mule.modules.salesforce.connection.strategy.SalesforceStrategy;

import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>{@link SalesforceBayeuxClient} is an extension of a {@link BayeuxClient} that can deal with Salesforce session
 * management.
 */
public class SalesforceBayeuxClient extends BayeuxClient {
    protected static final int HANDSHAKE_TIMEOUT = 30 * 1000;
    protected static final int LONG_POLLING_TIMEOUT = 120000;
    protected static final Map<String, Object> LONG_POLLING_OPTIONS = createLongPollingOptions();
    private static final Logger logger = Logger.getLogger(SalesforceBayeuxClient.class);
    protected static final String LOGIN_COOKIE = "login";
    protected static final String LOCALEINFO_COOKIE = "com.salesforce.LocaleInfo";
    protected static final String SESSIONID_COOKIE = "sid";
    protected static final String LANGUAGE_COOKIE = "language";
    protected Map<String, org.cometd.bayeux.client.ClientSessionChannel.MessageListener> subscriptions;
    protected Map<String, org.cometd.bayeux.client.ClientSessionChannel.MessageListener> currentSubscriptions;
    protected SalesforceStrategy salesforceStrategy;
    private boolean needToResubscribe = false;

    private static Map<String, Object> createLongPollingOptions() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ClientTransport.TIMEOUT_OPTION, LONG_POLLING_TIMEOUT);
        return Collections.unmodifiableMap(result);
    }

    /**
     * Create a new instance of this Bayeux client.
     *
     * @param salesforceStrategy Salesforce connection
     */
    public SalesforceBayeuxClient(SalesforceStrategy salesforceStrategy) throws MalformedURLException {
        super("https://" + (new URL(salesforceStrategy.getCustomPartnerConnection().getConfig().getServiceEndpoint())).getHost() + "/cometd/32.0",
                SalesforceLongPollingTransport.create(salesforceStrategy, LONG_POLLING_OPTIONS));

        this.salesforceStrategy = salesforceStrategy;
        this.subscriptions = Collections.synchronizedMap(new HashMap<String, ClientSessionChannel.MessageListener>());
        this.currentSubscriptions = Collections.synchronizedMap(new HashMap<String, ClientSessionChannel.MessageListener>());
        setCookies();

        getChannel(Channel.META_CONNECT).addListener(new ClientSessionChannel.MessageListener() {
            public void onMessage(ClientSessionChannel channel, Message message) {
                //adding extra logging
                logger.debug("### new message:: " + message.getId());
                logger.debug("isSuccessful: " + message.isSuccessful());
                logger.debug("state: " + getState());
                logger.debug("isConnected: " + isConnected());
                logger.debug("needToResubscribe: " + needToResubscribe);

                if (message.isSuccessful() && !subscriptions.isEmpty()) {
                    for (String subscriptionChannel : subscriptions.keySet()) {
                        logger.info("subscribing " + subscriptionChannel + " for the first time");
                        getChannel(subscriptionChannel).subscribe(subscriptions.get(subscriptionChannel));
                    }
                    // Removing the subscriptions already made so it doesn't re-subscribe on reconnect
                    subscriptions.clear();

                } else if (!message.isSuccessful() && getState() == State.REHANDSHAKING) {
                    needToResubscribe = true;
                } else if (needToResubscribe && isConnected()) {
                    resubscribe();
                    needToResubscribe = false;
                }
            }
        });
    }

    private void resubscribe() {
        for (String subscriptionChannel : currentSubscriptions.keySet()) {
            logger.info("Re-Subscribing to channel: " + subscriptionChannel);
            getChannel(subscriptionChannel).subscribe(currentSubscriptions.get(subscriptionChannel));
        }
    }

    private void setCookies() {
        setCookie(LOCALEINFO_COOKIE, "us");
        setCookie(LOGIN_COOKIE, salesforceStrategy.getCustomPartnerConnection().getConfig().getUsername());
        setCookie(SESSIONID_COOKIE, salesforceStrategy.getSessionId());
        setCookie(LANGUAGE_COOKIE, "en_US");
    }

    /**
     * <p>Callback method invoked when the given messages have failed to be sent.</p>
     * <p>The default implementation logs the failure at INFO level.</p>
     *
     * @param x        the exception that caused the failure
     * @param messages the messages being sent
     */
    @Override
    public void onFailure(Throwable x, Message[] messages) {
        if (x instanceof ProtocolException) {
            try {
                // EL: not sure this is the best way of doing this.
                // Ideally it should be the same for OAuth and non-OAuth
                // ways of reconnecting.
                if (salesforceStrategy instanceof SalesforceBasicAuthStrategy) {
                    ((SalesforceBasicAuthStrategy) salesforceStrategy).reconnect();
                }
                setCookies();
                handshake();
            } catch (org.mule.api.ConnectionException e) {
                logger.error(e);
            }
        } else {
            logger.error(x.getMessage());
        }
    }

    @Override
    public void handshake() {
        super.handshake(HANDSHAKE_TIMEOUT);
    }

    public void unsubscribe(String channel) {
        getChannel(channel).unsubscribe();

        this.subscriptions.remove(channel);
        this.currentSubscriptions.remove(channel);
    }

    public void subscribe(String channel, ClientSessionChannel.MessageListener messageListener) {
        if (isConnected()) {
            logger.info("Subscribing to channel: " + channel);
            getChannel(channel).subscribe(messageListener);
        } else {
            this.subscriptions.put(channel, messageListener);
            this.currentSubscriptions.put(channel, messageListener);
        }
    }
}
