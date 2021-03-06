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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.salesforce.automation.RegressionTests;
import org.mule.modules.salesforce.automation.SalesforceTestParent;
import org.mule.modules.tests.ConnectorTestUtils;

import com.sforce.soap.partner.SaveResult;



public class UpdateTestCases extends SalesforceTestParent {

	@Before
	public void setUp() throws Exception {
    	
    	List<String> sObjectsIds = new ArrayList<String>();
   
		initializeTestRunMessage("updateCreateRecord");
        
        List<SaveResult> saveResultsList =  runFlowAndGetPayload("create-from-message");
        Iterator<SaveResult> saveResultsIter = saveResultsList.iterator();  

        List<Map<String,Object>> sObjects = getTestRunMessageValue("salesforceSObjectsListFromMessage");
		Iterator<Map<String,Object>> sObjectsIterator = sObjects.iterator();
        
		while (saveResultsIter.hasNext()) {
			
			SaveResult saveResult = saveResultsIter.next();
			Map<String,Object> sObject = (Map<String, Object>) sObjectsIterator.next();
			sObjectsIds.add(saveResult.getId());
	        sObject.put("Id", saveResult.getId());
			
		}

		upsertOnTestRunMessage("idsToDeleteFromMessage", sObjectsIds);

		}
	
	@After
	public void tearDown() throws Exception {
    	runFlowAndGetPayload("delete-from-message");
	}
	
	@Category({RegressionTests.class})
	@Test
	public void testUpdateChildElementsFromMessage() {
		try {
			List<SaveResult> saveResults = runFlowAndGetPayload("update-from-message");
	        Iterator<SaveResult> iter = saveResults.iterator();  
			while (iter.hasNext()) {
				SaveResult saveResult = iter.next();
				assertTrue(saveResult.getSuccess());				
			}
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}	
	}

	@Category({RegressionTests.class})
	@Test
	public void testUpdatePassingFieldsToNull() {	
		String query = "";
		List<String> updatedFields = new ArrayList();
		String anUpdatedField = "";
		String anUpdatedFieldValue = "";
		String aFieldToNull = "";
		String aSObjectId = "";
		Map<String,Object> aSObject;
		Random random = new Random();
		
		String sObjectType = getTestRunMessageValue("type");
		
		List<Map<String,Object>> sObjectsUpdates = getTestRunMessageValue("salesforceSObjectsListFromMessage");		
		aSObject = sObjectsUpdates.get(random.nextInt(sObjectsUpdates.size()));
		
		aSObjectId = aSObject.get("Id").toString();
		for (String key:aSObject.keySet()) {
			if (!key.equals("Id")) {
				updatedFields.add(key);
			}
		}
		anUpdatedField = updatedFields.get(random.nextInt(updatedFields.size())).toString();
		anUpdatedFieldValue = aSObject.get(anUpdatedField).toString();
		
		List<String> fieldsToNullList = getBeanFromContext("updateFieldsToNull");
		String[] fieldsToNullArray = fieldsToNullList.toArray(new String[fieldsToNullList.size()]);
		aFieldToNull = fieldsToNullArray[random.nextInt(fieldsToNullList.size())];
		
		aSObject.put("fieldsToNull", fieldsToNullArray);
		
		query = String.format("SELECT Id,%s,%s FROM %s WHERE Id='%s'", anUpdatedField, aFieldToNull, sObjectType, aSObjectId);
		
		try {
			List<SaveResult> saveResults = runFlowAndGetPayload("update-from-message");
	        Iterator<SaveResult> iter = saveResults.iterator();  
			while (iter.hasNext()) {	
				SaveResult saveResult = iter.next();
				assertTrue(saveResult.getSuccess());
		}	
			
		upsertOnTestRunMessage("query", query);
		Map<String, Object> record =  runFlowAndGetPayload("query-single");
		
		assertEquals(record.get("Id"),aSObjectId);
		assertEquals(record.get(anUpdatedField),anUpdatedFieldValue);
		assertEquals(record.get(aFieldToNull),null);
		
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
		
		
	}
	
}