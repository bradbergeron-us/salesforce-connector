/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce.automation.testrunners;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import org.mule.modules.salesforce.automation.RegressionTests;
import org.mule.modules.salesforce.automation.testcases.*;

@RunWith(Categories.class)
@IncludeCategory(RegressionTests.class)

@SuiteClasses({

	AbortJobTestCases.class,
	CreateTestCases.class,
	GetUpdatedTestCases.class,
	RetrieveTestCases.class,
	DeleteTestCases.class,
	GetUserInfoTestCases.class,
	CloseJobTestCases.class,
	DescribeGlobalTestCases.class,
	HardDeleteBulkTestCases.class,
	SearchTestCases.class,
	ConvertLeadTestCases.class,
	ConvertLeadOpportunityTestCases.class,
	DescribeSObjectTestCases.class,
	EmptyRecycleBinTestCases.class,
	QueryAllTestCases.class,
	UpdateBulkTestCases.class,
	CreateBatchTestCases.class,
	GetDeletedRangeTestCases.class,
	GetDeletedRangeNullEndTimeTestCases.class,
	QueryResultStreamTestCases.class,
	UpdateSingleTestCases.class,
	CreateBulkTestCases.class,
	GetDeletedTestCases.class,
	QuerySingleTestCases.class,
	QuerySingleEmptyTestCases.class,
	UpdateTestCases.class,
	CreateJobTestCases.class,
	GetUpdatedObjectsTestCases.class,
	QueryTestCases.class,
	UpsertBulkTestCases.class,
	CreateSingleTestCases.class,
	CreateEmptyTestCases.class,
	GetUpdatedRangeTestCases.class,
	UpsertTestCases.class,
	PublishTopicTestCases.class,
	DescribeSObjectTestCases.class,
	GetServerTimestampTestCases.class,
	NonPaginatedQueryTestCases.class,
	CreateBatchStreamTestCases.class,
	CreateBatchZipTestCases.class,
	JobInfoTestCases.class,
	CreateBatchForQueryTestCases.class,
    CreateMetadataTestCases.class,
    DeleteMetadataTestCases.class,
    ListMetadataTestCases.class,
    DescribeMetadataTestCases.class,
    RenameMetadataTestCases.class,
    UpdateMetadataTestCases.class,
    UpsertMetadataTestCases.class,
    ReadMetadataTestCases.class,
    DeployRetrieveMetadataTestCases.class,
    DeployRetrieveMetadataApexClassTestCases.class,
    DataSeneMetadataTestCases.class
})

public class RegressionTestSuite {
	
	
	
}