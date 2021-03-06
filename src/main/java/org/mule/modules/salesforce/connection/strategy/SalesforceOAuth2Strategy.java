/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce.connection.strategy;

/**
 * The Salesforce Connector will allow to connect to the Salesforce application using OAuth as the authentication
 * mechanism. Almost every operation that can be done via the Salesforce's API can be done thru this connector.
 * This connector will also work if your Salesforce objects are customized with additional fields or even you are
 * working with custom objects.
 * <p/>
 * Integrating with Salesforce consists of web service calls utilizing XML request/response setup
 * over an HTTPS connection. The technical details of this connection such as request headers,
 * error handling, HTTPS connection, etc. are all abstracted from the user to make implementation
 * quick and easy.
 * <p/>
 * This version of the connector allows you to use OAuth for authentication instead of the
 * username/password/securityToken combination.
 * <p/>
 * {@sample.config ../../../doc/mule-module-sfdc.xml.sample sfdc:config-with-oauth}
 *
 * @author MuleSoft, Inc.
 */

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.RedirectListener;
import org.eclipse.jetty.http.HttpMethods;
import org.eclipse.jetty.http.HttpStatus;
import org.mule.RequestContext;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.oauth.OAuth2;
import org.mule.api.annotations.oauth.OAuthAccessToken;
import org.mule.api.annotations.oauth.OAuthAuthorizationParameter;
import org.mule.api.annotations.oauth.OAuthCallbackParameter;
import org.mule.api.annotations.oauth.OAuthConsumerKey;
import org.mule.api.annotations.oauth.OAuthConsumerSecret;
import org.mule.api.annotations.oauth.OAuthPostAuthorization;
import org.mule.api.annotations.param.Default;
import org.mule.modules.salesforce.SalesforceOAuthDisplay;
import org.mule.modules.salesforce.SalesforceOAuthImmediate;
import org.mule.modules.salesforce.SalesforceOAuthPrompt;
import org.mule.modules.salesforce.connection.CustomMetadataConnection;
import org.mule.modules.salesforce.connection.CustomPartnerConnection;

import com.google.common.base.Charsets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sforce.async.AsyncApiException;
import com.sforce.async.BulkConnection;
import com.sforce.soap.metadata.MetadataConnection;
import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sforce.ws.MessageHandler;


@OAuth2(configElementName = "config-with-oauth",
        friendlyName = "OAuth v2.0",
        authorizationUrl = "https://login.salesforce.com/services/oauth2/authorize",
        accessTokenUrl = "https://login.salesforce.com/services/oauth2/token",
        authorizationParameters = {
                @OAuthAuthorizationParameter(name = "display", type = SalesforceOAuthDisplay.class,
                        description = "Tailors the login page to the user's device type."),
                @OAuthAuthorizationParameter(name = "immediate", type = SalesforceOAuthImmediate.class,
                        optional = true, defaultValue = "FALSE", description = "Avoid interacting with the user."),
                @OAuthAuthorizationParameter(name = "prompt", type = SalesforceOAuthPrompt.class,
                        optional = true, description = "Specifies how the authorization server prompts the user for reauthentication and reapproval.")
        })
public class SalesforceOAuth2Strategy extends SalesforceStrategy {

    private static final Logger logger = Logger.getLogger(SalesforceOAuth2Strategy.class);

    /**
     * Connection to the SOAP API
     */
    private CustomPartnerConnection partnerConnection;

    /**
     * REST connection to the bulk API
     */
    private BulkConnection bulkConnection;

    /**
     * Connection to the Metadata API
     */
    private CustomMetadataConnection metadataConnection;

    /**
     * Your application's client identifier (consumer key in Remote Access Detail).
     */
    @Configurable
    @OAuthConsumerKey
    private String consumerKey;

    /**
     * Your application's client secret (consumer secret in Remote Access Detail).
     */
    @Configurable
    @OAuthConsumerSecret
    private String consumerSecret;

    @OAuthAccessToken
    private String accessToken;

    @OAuthCallbackParameter(expression = "#[json:instance_url]")
    private String instanceId;

    //REMOVE THIS: this hack needs to be removed once the connector returns the remote user id
    // by itself in a right way after authorize
    @OAuthCallbackParameter(expression = "#[json:id]")
    private String userId;

    /**
     * Salesforce read timeout
     */
    @Configurable
    @Default("0")
    private Integer readTimeout;

    /**
     * Salesforce connection timeout
     */
    @Configurable
    @Default("0")
    private Integer connectionTimeout;

    @Override
    public boolean isReadyToSubscribe() {
        return this.accessToken != null;
    }

    @OAuthPostAuthorization
    public void postAuthorize() throws ConnectionException, MalformedURLException, AsyncApiException, Exception {
        ConnectorConfig config = new ConnectorConfig();
        if (logger.isDebugEnabled()) {
            config.addMessageHandler(new MessageHandler() {
                @Override
                public void handleRequest(URL endpoint, byte[] request) {
                    logger.debug("Sending request to " + endpoint.toString());
                    logger.debug(new String(request, Charsets.UTF_8));
                }

                @Override
                public void handleResponse(URL endpoint, byte[] response) {
                    logger.debug("Receiving response from " + endpoint.toString());
                    logger.debug(new String(response, Charsets.UTF_8));
                }
            });
        }
        config.setSessionId(accessToken);
        config.setManualLogin(true);

        config.setReadTimeout(readTimeout);
        config.setConnectionTimeout(connectionTimeout);

        config.setCompression(false);

        String serviceEndpoint = "https://" + (new URL(instanceId)).getHost() + "/services/Soap/u/" + getApiVersion();
        config.setServiceEndpoint(serviceEndpoint);

        PartnerConnection _connection = Connector.newConnection(config);
        this.partnerConnection = new CustomPartnerConnection();
        this.partnerConnection.setConnection(_connection);
        setConnectionOptions(this.partnerConnection);

        String restEndpoint = "https://" + (new URL(instanceId)).getHost() + "/services/async/" + getApiVersion();
        config.setRestEndpoint(restEndpoint);

        this.bulkConnection = new BulkConnection(config);

        String metadataendpoint = getMetadataServiceEndpoint();
        ConnectorConfig metadataConfig = new ConnectorConfig();
        metadataConfig.setServiceEndpoint(metadataendpoint);
        metadataConfig.setManualLogin(true);
        metadataConfig.setCompression(false);
        metadataConfig.setSessionId(accessToken);
        MetadataConnection _metadataConnection = new MetadataConnection(metadataConfig);
        this.metadataConnection = new CustomMetadataConnection();
        this.metadataConnection.setConnection(_metadataConnection);

        this.processSubscriptions();

        RequestContext.getEvent().setFlowVariable("remoteUserId", userId);
    }

    private String getMetadataServiceEndpoint() throws Exception {
        HttpClient client = new HttpClient();
        client.setIdleTimeout(5000);
        client.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
        client.registerListener(RedirectListener.class.getName());
        client.start();
        ContentExchange exchange = new ContentExchange();
        exchange.addRequestHeader("Authorization", "Bearer " + accessToken);
        exchange.addRequestHeader("Accept", "application/json");
        exchange.setMethod(HttpMethods.POST);
        exchange.setURL(userId + "?version=" + getApiVersion());
        client.send(exchange);
        exchange.waitForDone();
        int status = exchange.getResponseStatus();
        if (status == HttpStatus.OK_200) {
            String result = exchange.getResponseContent();
            client.stop();

            JsonElement jElement = new JsonParser().parse(result);
            JsonObject jObject = jElement.getAsJsonObject();
            JsonObject urls = jObject.getAsJsonObject("urls");
            String metadataEndpoint = urls.getAsJsonPrimitive("metadata")
                    .getAsString();

            return metadataEndpoint;
        }
        return "";
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public CustomPartnerConnection getCustomPartnerConnection() {
        return this.partnerConnection;
    }

    @Override
    public BulkConnection getBulkConnection() {
        return this.bulkConnection;
    }

    @Override
    public CustomMetadataConnection getCustomMetadataConnection() {
        return this.metadataConnection;
    }

    @Override
    public String getSessionId() {
        return this.accessToken;
    }

    public String getInstanceId() {
        return instanceId;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the readTimeout
     */
    public Integer getReadTimeout() {
        return readTimeout;
    }

    /**
     * @param readTimeout the readTimeout to set
     */
    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    /**
     * @return the connectionTimeout
     */
    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    /**
     * @param connectionTimeout the connectionTimeout to set
     */
    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }
}
