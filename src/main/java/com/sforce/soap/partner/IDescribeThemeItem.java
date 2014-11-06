package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public interface IDescribeThemeItem {

      /**
       * element : colors of type {urn:partner.soap.sforce.com}DescribeColor
       * java type: com.sforce.soap.partner.DescribeColor[]
       */

      public com.sforce.soap.partner.IDescribeColor[] getColors();

      public void setColors(com.sforce.soap.partner.IDescribeColor[] colors);

      /**
       * element : icons of type {urn:partner.soap.sforce.com}DescribeIcon
       * java type: com.sforce.soap.partner.DescribeIcon[]
       */

      public com.sforce.soap.partner.IDescribeIcon[] getIcons();

      public void setIcons(com.sforce.soap.partner.IDescribeIcon[] icons);

      /**
       * element : name of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getName();

      public void setName(java.lang.String name);


}
