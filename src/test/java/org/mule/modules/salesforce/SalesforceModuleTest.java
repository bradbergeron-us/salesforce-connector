package org.mule.modules.salesforce;

import com.sforce.soap.partner.*;
import com.sforce.soap.partner.sobject.SObject;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.*;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SalesforceModuleTest {

    public static final String MOCKED_ID = "001";
    public static final String MOCK_OBJET_TYPE = "Account";
    public static final String MOCK_QUERY = "SELECT Id FROM Account";

    @Test
    public void testCreate() throws Exception {
        SalesforceModule module = new SalesforceModule();
        SaveResult saveResult = Mockito.mock(SaveResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        when(partnerConnection.create(Mockito.argThat(new SObjectArrayMatcher()))).thenReturn(new SaveResult[]{saveResult});
        module.setConnection(partnerConnection);

        Map<String, Object> sObject = new HashMap<String, Object>();
        sObject.put("FirstName", "John");
        sObject.put("LastName", "Doe");
        List<Map<String, Object>> sObjectList = new ArrayList<Map<String, Object>>();
        sObjectList.add(sObject);

        List<SaveResult> saveResults = module.create(MOCK_OBJET_TYPE, sObjectList);

        assertEquals(saveResults.get(0), saveResult);
    }

    @Test
    public void testIsNotConnectedWhenConnectionIsNull() throws Exception {
        SalesforceModule module = new SalesforceModule();

        assertFalse(module.isConnected());
    }

    @Test
    public void testIsNotConnectedWhenLoginResultIsNull() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);

        assertFalse(module.isConnected());
    }

    @Test
    public void testIsConnected() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        LoginResult loginResult = Mockito.mock(LoginResult.class);
        module.setConnection(partnerConnection);
        module.setLoginResult(loginResult);
        when(loginResult.getSessionId()).thenReturn(MOCKED_ID);

        assertTrue(module.isConnected());
    }

    @Test
    public void testGetSessionId() throws Exception {
        SalesforceModule module = new SalesforceModule();
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        LoginResult loginResult = Mockito.mock(LoginResult.class);
        module.setConnection(partnerConnection);
        module.setLoginResult(loginResult);
        when(loginResult.getSessionId()).thenReturn(MOCKED_ID);

        assertEquals(module.getSessionId(), MOCKED_ID);
    }

    @Test
    public void testDestroySession() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {
        SalesforceModule module = new SalesforceModule();
        SaveResult saveResult = Mockito.mock(SaveResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        when(partnerConnection.update(Mockito.argThat(new SObjectArrayMatcher()))).thenReturn(new SaveResult[]{saveResult});
        module.setConnection(partnerConnection);

        Map<String, Object> sObject = new HashMap<String, Object>();
        sObject.put("FirstName", "John");
        sObject.put("LastName", "Doe");
        List<Map<String, Object>> sObjectList = new ArrayList<Map<String, Object>>();
        sObjectList.add(sObject);

        List<SaveResult> saveResults = module.update(MOCK_OBJET_TYPE, sObjectList);

        assertEquals(saveResults.get(0), saveResult);
    }

    @Test
    public void testDescribeGlobal() throws Exception {
        SalesforceModule module = new SalesforceModule();
        DescribeGlobalResult describeGlobalResult = Mockito.mock(DescribeGlobalResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        
        when(partnerConnection.describeGlobal()).thenReturn(describeGlobalResult);
        
        module.describeGlobal();

        verify(partnerConnection).describeGlobal();
    }

    @Test
    public void testQuery() throws Exception {
        SalesforceModule module = new SalesforceModule();
        QueryResult queryResult = Mockito.mock(QueryResult.class);
        when(queryResult.getRecords()).thenReturn(new SObject[] { });
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);
        
        when(partnerConnection.query(eq(MOCK_QUERY))).thenReturn(queryResult);
        
        module.query(MOCK_QUERY);
    }

    @Test
    public void testQuerySingle() throws Exception {
        SalesforceModule module = new SalesforceModule();
        QueryResult queryResult = Mockito.mock(QueryResult.class);
        when(queryResult.getRecords()).thenReturn(new SObject[] { });
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);

        when(partnerConnection.query(eq(MOCK_QUERY))).thenReturn(queryResult);

        module.querySingle(MOCK_QUERY);
    }

    @Test
    public void testConvertLead() throws Exception {

    }

    @Test
    public void testEmptyRecycleBin() throws Exception {
        SalesforceModule module = new SalesforceModule();
        EmptyRecycleBinResult emptyRecycleBinResult = Mockito.mock(EmptyRecycleBinResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);

        when(partnerConnection.emptyRecycleBin(argThat(new StringArrayMatcher()))).thenReturn(new EmptyRecycleBinResult[]{emptyRecycleBinResult});

        List<String> ids = new ArrayList<String>();
        ids.add(MOCKED_ID);
        
        module.emptyRecycleBin(ids);
    }

    @Test
    public void testDelete() throws Exception {
        SalesforceModule module = new SalesforceModule();
        DeleteResult deleteResult = Mockito.mock(DeleteResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);

        when(partnerConnection.delete(argThat(new StringArrayMatcher()))).thenReturn(new DeleteResult[]{deleteResult});

        List<String> ids = new ArrayList<String>();
        ids.add(MOCKED_ID);

        module.delete(ids);
    }

    @Test
    public void testDescribeSObject() throws Exception {
        SalesforceModule module = new SalesforceModule();
        DescribeSObjectResult describeSObjectResult = Mockito.mock(DescribeSObjectResult.class);
        PartnerConnection partnerConnection = Mockito.mock(PartnerConnection.class);
        module.setConnection(partnerConnection);

        when(partnerConnection.describeSObject(eq(MOCK_OBJET_TYPE))).thenReturn(describeSObjectResult);

        module.describeSObject(MOCK_OBJET_TYPE);
    }
}
