package org.mule.modules.salesforce.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.salesforce.automation.RegressionTests;
import org.mule.modules.salesforce.automation.SalesforceTestParent;
import org.mule.modules.tests.ConnectorTestUtils;

public class DeployRetrieveMetadataApexClassTestCases extends SalesforceTestParent {
	private static final String MANIFEST_FILE_NAME = "package_apex.xml";
	private static final String ZIP_FILE_PATH = "src/test/resources/apex_class.zip";
	
    @Before
    public void setUp() throws Exception {
    	deployApexClass();
    }
	
	@Test
	@Category({ RegressionTests.class })
	public void testRetrieveDeployMetadata() {
		upsertOnTestRunMessage("unpackagedRef", Thread.currentThread().getContextClassLoader().getResourceAsStream(MANIFEST_FILE_NAME));
		try {
			InputStream is = runFlowAndGetPayload("retrieve-metadata"); 
			
			upsertOnTestRunMessage("streamRef", is);
			
			String s = runFlowAndGetPayload("deploy-metadata");
			assertTrue(s.equalsIgnoreCase("The files were successfully deployed"));
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}
	
	private void deployApexClass() {
		try {
			InputStream is = new FileInputStream(new File(ZIP_FILE_PATH));  
			
			upsertOnTestRunMessage("streamRef", is);
			
			String s = runFlowAndGetPayload("deploy-metadata");
			assertTrue(s.equalsIgnoreCase("The files were successfully deployed"));
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}
	
}
