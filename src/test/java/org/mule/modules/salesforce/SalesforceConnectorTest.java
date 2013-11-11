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

import com.sforce.soap.partner.sobject.SObject;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class SalesforceConnectorTest {

    SalesforceConnector connector;

    @Before
    public void createConnector() {
        connector = new SalesforceConnector();
    }

    @Test
    public void shouldRecursivelyConvertMapsToSObjects() {
        Map<String, Object> account = new HashMap<String, Object>();
        account.put("ExternalId__c", 138);
        Map<String, Object> contact = new HashMap<String, Object>();
        contact.put("ExternalId__c", "bmurray");
        contact.put("FirstName", "Bill");
        contact.put("LastName", "Murray");
        contact.put("Account", account);


        SObject record = SalesforceUtils.toSObject("Contact", contact);
        assertEquals("Contact", record.getType());
        assertEquals("Bill", record.getField("FirstName"));
        assertEquals("Murray", record.getField("LastName"));
        assertEquals("bmurray", record.getField("ExternalId__c"));

        SObject parentRecord = (SObject) record.getField("Account");
        assertEquals("Account", parentRecord.getType());
        assertEquals(138, parentRecord.getField("ExternalId__c"));
    }

    @Test
    public void shouldConvertAllMapKeysToStringsWhenConvertingToSObjectMap() throws MalformedURLException {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put(123, "number key");
        map.put("abc", "string key");
        map.put(new URL("http://localhost"), "url key");
        Map<String, Object> sObjectMap = SalesforceUtils.toSObjectMap(map);
        assertEquals("number key", sObjectMap.get("123"));
        assertEquals("string key", sObjectMap.get("abc"));
        assertEquals("url key", sObjectMap.get("http://localhost"));
    }

    @Test
    public void shouldUseTypeAttributeInsteadOfFieldNameToDetermineSObjectType() {
        Map<String, Object> owner = new HashMap<String, Object>();
        owner.put("ExternalId__c", 101);
        owner.put("Custom1__c", "test");
        owner.put("Custom2__c", "test");
        owner.put("Custom3__c", "test");
        owner.put("Custom4__c", "test");
        owner.put("Custom5__c", "test");
        owner.put("Custom6__c", "test");
        owner.put("Custom7__c", "test");
        owner.put("Custom8__c", "test");
        owner.put("Custom9__c", "test");
        owner.put("CustomA__c", "test");
        owner.put("type", "User");

        Map<String, Object> opportunity = new HashMap<String, Object>();
        opportunity.put("Name", "Example Opportunity");
        opportunity.put("Owner", owner);

        SObject record = SalesforceUtils.toSObject("Opportunity", opportunity);
        SObject convertedOwnerObject = (SObject) record.getField("Owner");
        assertEquals("User", convertedOwnerObject.getType());
    }

    @Test
    public void shouldRecursivelyConvertMapsToAsyncSObjects() {
        Map<String, Object> account = new HashMap<String, Object>();
        account.put("ExternalId__c", "138");
        Map<String, Object> contact = new HashMap<String, Object>();
        contact.put("ExternalId__c", "bmurray");
        contact.put("FirstName", "Bill");
        contact.put("LastName", "Murray");
        contact.put("Account", account);


        com.sforce.async.SObject record = SalesforceUtils.toAsyncSObject(contact, 0);
        assertEquals("Bill", record.getField("FirstName"));
        assertEquals("Murray", record.getField("LastName"));
        assertEquals("bmurray", record.getField("ExternalId__c"));

        com.sforce.async.SObject parentRecord = record.getFkRef("Account");
        assertEquals("138", parentRecord.getField("ExternalId__c"));
    }
}
