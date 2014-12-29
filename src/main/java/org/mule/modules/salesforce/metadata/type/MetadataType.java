/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce.metadata.type;



/**
 * @author Mulesoft, Inc
 */
public enum MetadataType {
	ExternalDataSource("com.sforce.soap.metadata", com.sforce.soap.metadata.ExternalDataSource.class, "ExternalDataSource"),
	RemoteSiteSetting("com.sforce.soap.metadata", com.sforce.soap.metadata.RemoteSiteSetting.class,"RemoteSiteSetting"),
    CustomObject("com.sforce.soap.metadata", com.sforce.soap.metadata.CustomObject.class, "CustomObject"),
    BusinessProcess("com.sforce.soap.metadata", com.sforce.soap.metadata.BusinessProcess.class, "BusinessProcess"),
    PicklistValue("com.sforce.soap.metadata", com.sforce.soap.metadata.PicklistValue.class, "PicklistValue"),
    CompactLayout("com.sforce.soap.metadata", com.sforce.soap.metadata.CompactLayout.class, "CompactLayout"),
    CustomField("com.sforce.soap.metadata", com.sforce.soap.metadata.CustomField.class, "CustomField"),
    FieldSet("com.sforce.soap.metadata", com.sforce.soap.metadata.FieldSet.class, "FieldSet"),
    ListView("com.sforce.soap.metadata", com.sforce.soap.metadata.ListView.class, "ListView"),
    RecordType("com.sforce.soap.metadata", com.sforce.soap.metadata.RecordType.class, "RecordType"),
    SharingReason("com.sforce.soap.metadata", com.sforce.soap.metadata.SharingReason.class, "SharingReason"),
    ValidationRule("com.sforce.soap.metadata", com.sforce.soap.metadata.ValidationRule.class, "ValidationRule"),
    WebLink("com.sforce.soap.metadata", com.sforce.soap.metadata.WebLink.class, "WebLink"),
	ActionOverride("com.sforce.soap.metadata", com.sforce.soap.metadata.ActionOverride.class, "ActionOverride"),
	HistoryRetentionPolicy("com.sforce.soap.metadata", com.sforce.soap.metadata.HistoryRetentionPolicy.class, "HistoryRetentionPolicy"),
	PermissionSet("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSet.class, "PermissionSet"),
	PermissionSetApplicationVisibility("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSetApplicationVisibility.class, "PermissionSetApplicationVisibility"),
	PermissionSetApexClassAccess("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSetApexClassAccess.class, "PermissionSetApexClassAccess"),
	PermissionSetCustomPermissions("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSetCustomPermissions.class, "PermissionSetCustomPermissions"),
	PermissionSetExternalDataSourceAccess("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSetExternalDataSourceAccess.class, "PermissionSetExternalDataSourceAccess"),
	PermissionSetFieldPermissions("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSetFieldPermissions.class, "PermissionSetFieldPermissions"),
	PermissionSetObjectPermissions("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSetObjectPermissions.class, "PermissionSetObjectPermissions"),
	PermissionSetApexPageAccess("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSetApexPageAccess.class, "PermissionSetApexPageAccess"),
	PermissionSetRecordTypeVisibility("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSetRecordTypeVisibility.class, "PermissionSetRecordTypeVisibility"),
	PermissionSetTabSetting("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSetTabSetting.class, "PermissionSetTabSetting"),
	PermissionSetUserPermission("com.sforce.soap.metadata", com.sforce.soap.metadata.PermissionSetUserPermission.class, "PermissionSetUserPermission"),
	Profile("com.sforce.soap.metadata", com.sforce.soap.metadata.Profile.class, "Profile"),
	ProfileApplicationVisibility("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileApplicationVisibility.class, "ProfileApplicationVisibility"),
	ProfileApexClassAccess("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileApexClassAccess.class, "ProfileApexClassAccess"),
	ProfileCustomPermissions("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileCustomPermissions.class, "ProfileCustomPermissions"),
	ProfileExternalDataSourceAccess("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileExternalDataSourceAccess.class, "ProfileExternalDataSourceAccess"),
	ProfileFieldLevelSecurity("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileFieldLevelSecurity.class, "ProfileFieldLevelSecurity"),
	ProfileLayoutAssignment("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileLayoutAssignment.class, "ProfileLayoutAssignment"),
	ProfileLoginHours("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileLoginHours.class, "ProfileLoginHours"),
	ProfileLoginIpRange("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileLoginIpRange.class, "ProfileLoginIpRange"),
	ProfileObjectPermissions("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileObjectPermissions.class, "ProfileObjectPermissions"),
	ProfileApexPageAccess("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileApexPageAccess.class, "ProfileApexPageAccess"),
	ProfileRecordTypeVisibility("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileRecordTypeVisibility.class, "ProfileRecordTypeVisibility"),
	ProfileTabVisibility("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileTabVisibility.class, "ProfileTabVisibility"),
	ProfileUserPermission("com.sforce.soap.metadata", com.sforce.soap.metadata.ProfileUserPermission.class, "ProfileUserPermission");
	
	

    String entityPackage;
    Class<?> metadataEntityClass;
    String displayName;

    MetadataType(String entityPackage, Class<?> metadataEntityClass, String displayName) {
        this.entityPackage = entityPackage;
        this.metadataEntityClass = metadataEntityClass;
        this.displayName = displayName;

    }

    public String getEntityPackage() {
        return this.entityPackage;
    }

    public Class<?> getMetadataEntityClass() {
        return this.metadataEntityClass;
    }

    public String getDisplayName() {
        return  displayName;
    }
    
    public Object getMetadataObject() throws InstantiationException, IllegalAccessException {
    	return this.metadataEntityClass.newInstance();
    }
    
    public static MetadataType getByClass(Class<?> clazz){
    	for (MetadataType type : MetadataType.values()) {
    	    if (type.metadataEntityClass.equals(clazz)) {
    	      return type;
    	    }
    	  }
    	return null;
    }
    
    public static MetadataType getByName(String name){
    	for (MetadataType type : MetadataType.values()) {
    	    if (type.displayName.equalsIgnoreCase(name)) {
    	      return type;
    	    }
    	  }
    	return null;
    }
}
