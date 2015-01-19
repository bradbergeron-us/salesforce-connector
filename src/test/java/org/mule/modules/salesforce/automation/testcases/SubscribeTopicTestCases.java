/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce.automation.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.salesforce.automation.RegressionTests;
import org.mule.modules.salesforce.automation.SalesforceTestParent;
import org.mule.modules.salesforce.automation.SmokeTests;
import org.mule.modules.tests.ConnectorTestUtils;



public class SubscribeTopicTestCases extends SalesforceTestParent {
	
	@Before
    public void setUp() throws Exception {
        initializeTestRunMessage("subscribeTopicTestData");
    }

    @Category({ SmokeTests.class, RegressionTests.class })
    @Test
    public void testSubscribeTopic() {
        try {
            Map<String,Object> result = runFlowAndGetPayload("subscribe-topic");
            assertNotNull(result);
            Assert.assertEquals(result.get("topic"), "TestTopic"); 
        }
        catch (Exception e) {
            fail(ConnectorTestUtils.getStackTrace(e));
        }
    }
    
}