package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public interface IDescribeComponentInstance {

      /**
       * element : properties of type {urn:partner.soap.sforce.com}DescribeComponentInstanceProperty
       * java type: com.sforce.soap.partner.DescribeComponentInstanceProperty[]
       */

      public com.sforce.soap.partner.IDescribeComponentInstanceProperty[] getProperties();

      public void setProperties(com.sforce.soap.partner.IDescribeComponentInstanceProperty[] properties);

      /**
       * element : typeName of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getTypeName();

      public void setTypeName(java.lang.String typeName);

      /**
       * element : typeNamespace of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getTypeNamespace();

      public void setTypeNamespace(java.lang.String typeNamespace);


}
