package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class LocaleOptions_element extends com.sforce.ws.bind.SoapHeaderObject implements com.sforce.ws.bind.XMLizable , ILocaleOptions_element{

    /**
     * Constructor
     */
    public LocaleOptions_element() {}

    /**
     * element : language of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo language__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","language","http://www.w3.org/2001/XMLSchema","string",0,1,true);

    private boolean language__is_set = false;

    private java.lang.String language;

    @Override
    public java.lang.String getLanguage() {
      return language;
    }

    @Override
    public void setLanguage(java.lang.String language) {
      this.language = language;
      language__is_set = true;
    }

    /**
     * element : localizeErrors of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo localizeErrors__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","localizeErrors","http://www.w3.org/2001/XMLSchema","boolean",0,1,true);

    private boolean localizeErrors__is_set = false;

    private boolean localizeErrors;

    @Override
    public boolean getLocalizeErrors() {
      return localizeErrors;
    }

    @Override
    public boolean isLocalizeErrors() {
      return localizeErrors;
    }

    @Override
    public void setLocalizeErrors(boolean localizeErrors) {
      this.localizeErrors = localizeErrors;
      localizeErrors__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeString(__out, language__typeInfo, language, language__is_set);
       __typeMapper.writeBoolean(__out, localizeErrors__typeInfo, localizeErrors, localizeErrors__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        super.loadFields(__in, __typeMapper);
        __in.peekTag();
        if (__typeMapper.isElement(__in, language__typeInfo)) {
            setLanguage(__typeMapper.readString(__in, language__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, localizeErrors__typeInfo)) {
            setLocalizeErrors(__typeMapper.readBoolean(__in, localizeErrors__typeInfo, boolean.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[LocaleOptions_element ");
      sb.append(super.toString());sb.append(" language='").append(com.sforce.ws.util.Verbose.toString(language)).append("'\n");
      sb.append(" localizeErrors='").append(com.sforce.ws.util.Verbose.toString(localizeErrors)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
