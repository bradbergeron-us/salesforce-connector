package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public interface IDescribeSearchLayoutResult {

      /**
       * element : errorMsg of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getErrorMsg();

      public void setErrorMsg(java.lang.String errorMsg);

      /**
       * element : label of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getLabel();

      public void setLabel(java.lang.String label);

      /**
       * element : limitRows of type {http://www.w3.org/2001/XMLSchema}int
       * java type: java.lang.Integer
       */

      public java.lang.Integer getLimitRows();

      public void setLimitRows(java.lang.Integer limitRows);

      /**
       * element : objectType of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getObjectType();

      public void setObjectType(java.lang.String objectType);

      /**
       * element : searchColumns of type {urn:partner.soap.sforce.com}DescribeColumn
       * java type: com.sforce.soap.partner.DescribeColumn[]
       */

      public com.sforce.soap.partner.IDescribeColumn[] getSearchColumns();

      public void setSearchColumns(com.sforce.soap.partner.IDescribeColumn[] searchColumns);


}
