package org.mule.modules.salesforce.automation.testcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mule.modules.salesforce.automation.RegressionTests;
import org.mule.modules.salesforce.automation.SalesforceTestParent;
import org.mule.modules.tests.ConnectorTestUtils;

public class DeployRetrieveMetadataTestCases extends SalesforceTestParent {
	private static final String MANIFEST_FILE_NAME = "package.xml";
	private static final String PACKAGE_NAME = "unitTestPackage";
	
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
	
	@Test
	@Category({ RegressionTests.class })
	public void testRetrieveDeployMetadataWithPackage() {
		List<String> packageNames = new ArrayList<String>();
		packageNames.add(PACKAGE_NAME);
		upsertOnTestRunMessage("packageNames", packageNames);
		try {
			InputStream is = runFlowAndGetPayload("retrieve-metadata");
			
			upsertOnTestRunMessage("streamRef", is);
			
			String s = runFlowAndGetPayload("deploy-metadata");
			assertTrue(s.equalsIgnoreCase("The files were successfully deployed"));
		} catch (Exception e) {
			fail(ConnectorTestUtils.getStackTrace(e));
		}
	}

	
}
