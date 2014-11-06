package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public interface IEmail {

      /**
       * element : bccSender of type {http://www.w3.org/2001/XMLSchema}boolean
       * java type: java.lang.Boolean
       */

      public java.lang.Boolean getBccSender();

      public void setBccSender(java.lang.Boolean bccSender);

      /**
       * element : emailPriority of type {urn:partner.soap.sforce.com}EmailPriority
       * java type: com.sforce.soap.partner.EmailPriority
       */

      public com.sforce.soap.partner.EmailPriority getEmailPriority();

      public void setEmailPriority(com.sforce.soap.partner.EmailPriority emailPriority);

      /**
       * element : replyTo of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getReplyTo();

      public void setReplyTo(java.lang.String replyTo);

      /**
       * element : saveAsActivity of type {http://www.w3.org/2001/XMLSchema}boolean
       * java type: java.lang.Boolean
       */

      public java.lang.Boolean getSaveAsActivity();

      public void setSaveAsActivity(java.lang.Boolean saveAsActivity);

      /**
       * element : senderDisplayName of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getSenderDisplayName();

      public void setSenderDisplayName(java.lang.String senderDisplayName);

      /**
       * element : subject of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getSubject();

      public void setSubject(java.lang.String subject);

      /**
       * element : useSignature of type {http://www.w3.org/2001/XMLSchema}boolean
       * java type: java.lang.Boolean
       */

      public java.lang.Boolean getUseSignature();

      public void setUseSignature(java.lang.Boolean useSignature);


}
