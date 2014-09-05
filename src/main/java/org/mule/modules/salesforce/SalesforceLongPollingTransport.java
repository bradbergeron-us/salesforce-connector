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

import org.cometd.client.transport.LongPollingTransport;
import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;

import java.util.Map;

public class SalesforceLongPollingTransport extends LongPollingTransport {
    private BaseSalesforceConnector salesforceConnector;

    public static SalesforceLongPollingTransport create(BaseSalesforceConnector salesforceConnector, Map<String, Object> options) {
        HttpClient httpClient = new HttpClient();
        httpClient.setIdleTimeout(5000);
        httpClient.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
        httpClient.setMaxConnectionsPerAddress(32768);
        return create(salesforceConnector, options, httpClient);
    }

    public static SalesforceLongPollingTransport create(BaseSalesforceConnector salesforceConnector, Map<String, Object> options, HttpClient httpClient) {
        SalesforceLongPollingTransport transport = new SalesforceLongPollingTransport(salesforceConnector, options, httpClient);
        if (!httpClient.isStarted()) {
            try {
                httpClient.start();
            } catch (Exception x) {
                throw new RuntimeException(x);
            }
        }
        return transport;
    }

    public SalesforceLongPollingTransport(BaseSalesforceConnector salesforceConnector, Map<String, Object> options, HttpClient httpClient) {
        super(options, httpClient);

        this.salesforceConnector = salesforceConnector;
    }

    @Override
    protected void customize(ContentExchange exchange) {
        super.customize(exchange);

        exchange.getRequestFields().add("Authorization", "OAuth " + salesforceConnector.getSessionId());
    }
}
