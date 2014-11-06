package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class SearchRecord implements com.sforce.ws.bind.XMLizable , ISearchRecord{

    /**
     * Constructor
     */
    public SearchRecord() {}

    /**
     * element : record of type {urn:sobject.partner.soap.sforce.com}sObject
     * java type: com.sforce.soap.partner.sobject.SObject
     */
    private static final com.sforce.ws.bind.TypeInfo record__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","record","urn:sobject.partner.soap.sforce.com","sObject",1,1,true);

    private boolean record__is_set = false;

    private com.sforce.soap.partner.sobject.SObject record;

    @Override
    public com.sforce.soap.partner.sobject.SObject getRecord() {
      return record;
    }

    @Override
    public void setRecord(com.sforce.soap.partner.sobject.ISObject record) {
      this.record = (com.sforce.soap.partner.sobject.SObject)record;
      record__is_set = true;
    }

    /**
     * element : snippet of type {urn:partner.soap.sforce.com}SearchSnippet
     * java type: com.sforce.soap.partner.SearchSnippet
     */
    private static final com.sforce.ws.bind.TypeInfo snippet__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","snippet","urn:partner.soap.sforce.com","SearchSnippet",0,1,true);

    private boolean snippet__is_set = false;

    private com.sforce.soap.partner.SearchSnippet snippet;

    @Override
    public com.sforce.soap.partner.SearchSnippet getSnippet() {
      return snippet;
    }

    @Override
    public void setSnippet(com.sforce.soap.partner.ISearchSnippet snippet) {
      this.snippet = (com.sforce.soap.partner.SearchSnippet)snippet;
      snippet__is_set = true;
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
       __typeMapper.writeObject(__out, record__typeInfo, record, record__is_set);
       __typeMapper.writeObject(__out, snippet__typeInfo, snippet, snippet__is_set);
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
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, record__typeInfo)) {
            setRecord((com.sforce.soap.partner.sobject.SObject)__typeMapper.readObject(__in, record__typeInfo, com.sforce.soap.partner.sobject.SObject.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, snippet__typeInfo)) {
            setSnippet((com.sforce.soap.partner.SearchSnippet)__typeMapper.readObject(__in, snippet__typeInfo, com.sforce.soap.partner.SearchSnippet.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[SearchRecord ");
      sb.append(" record='").append(com.sforce.ws.util.Verbose.toString(record)).append("'\n");
      sb.append(" snippet='").append(com.sforce.ws.util.Verbose.toString(snippet)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
