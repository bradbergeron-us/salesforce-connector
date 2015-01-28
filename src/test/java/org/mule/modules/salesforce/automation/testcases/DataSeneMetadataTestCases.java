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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.modules.salesforce.automation.RegressionTests;
import org.mule.modules.salesforce.automation.SalesforceTestParent;
import org.mule.modules.tests.ConnectorTestUtils;

public class DataSeneMetadataTestCases extends SalesforceTestParent {
	
	private ConnectorMetaDataEnabled connector;
	
    private MetaDataKey accountKey;
    private MetaDataKey contactKey;
    private MetaDataKey customObjectKey;
    private MetaDataKey customFieldKey;
    private MetaDataKey externalDataSourceKey;
	
	@Before
	public void setUp() throws Exception {

		connector = muleContext.getRegistry().lookupObject("Salesforce");
	}
	
    @Category({RegressionTests.class})
	@Test
	public void testGetMetaDataKeys() {

		try {
			
			Result<List<MetaDataKey>> metaDataKeysResult = connector.getMetaDataKeys();
	        assertTrue(Result.Status.SUCCESS.equals(metaDataKeysResult.getStatus()));
	        List<MetaDataKey> metaDataKeys = metaDataKeysResult.get();
	        
	        for (MetaDataKey key : metaDataKeys) {
	        	if (accountKey == null && key.getId().equals("Account")) {
	        		accountKey = key;
	        	}
	        	if (contactKey == null && key.getId().equals("Contact")) {
	        		contactKey = key;
	        	}
	        	if (customObjectKey == null && key.getId().equals("CustomObject")) {
	        		customObjectKey = key;
	        	}
	        	if (customFieldKey == null && key.getId().equals("CustomField")) {
	        		customFieldKey = key;
	        	}
	        	if (externalDataSourceKey == null && key.getId().equals("ExternalDataSource")) {
	        		externalDataSourceKey = key;
	        	}
	        }
	        
	        assertNotNull(accountKey);
	        assertNotNull(contactKey);
	        assertNotNull(customObjectKey);
	        assertNotNull(customFieldKey);
	        assertNotNull(externalDataSourceKey);
	        
	        Result<MetaData> accountKeyResult = connector.getMetaData(accountKey);
			assertTrue(Result.Status.SUCCESS.equals(accountKeyResult.getStatus()));
			
			Result<MetaData> contactKeyResult = connector.getMetaData(contactKey);
			assertTrue(Result.Status.SUCCESS.equals(contactKeyResult.getStatus()));
			
			Result<MetaData> customObjectKeyResult = connector.getMetaData(customObjectKey);
			assertTrue(Result.Status.SUCCESS.equals(customObjectKeyResult.getStatus()));
			
			Result<MetaData> customFieldKeyResult = connector.getMetaData(customFieldKey);
			assertTrue(Result.Status.SUCCESS.equals(customFieldKeyResult.getStatus()));
			
			Result<MetaData> externalDataSourceKeyResult = connector.getMetaData(externalDataSourceKey);
			assertTrue(Result.Status.SUCCESS.equals(externalDataSourceKeyResult.getStatus()));
	        
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}
}