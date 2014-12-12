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

import org.junit.Test;
import org.mockito.Mockito;
import org.mule.modules.salesforce.connection.strategy.SalesforceBasicAuthStrategy;

import java.util.Map;

public class SalesforceLongPollingTransportTest {
    @Test
    public void testCreate() throws Exception {
        SalesforceBasicAuthStrategy strategy = new SalesforceBasicAuthStrategy();
        Map options = Mockito.mock(Map.class);

        SalesforceLongPollingTransport transport = SalesforceLongPollingTransport.create(strategy, options);
    }
    
    
}
