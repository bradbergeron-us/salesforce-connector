package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeFlexiPages_element implements com.sforce.ws.bind.XMLizable , IDescribeFlexiPages_element{

    /**
     * Constructor
     */
    public DescribeFlexiPages_element() {}

    /**
     * element : flexiPages of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String[]
     */
    private static final com.sforce.ws.bind.TypeInfo flexiPages__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","flexiPages","http://www.w3.org/2001/XMLSchema","string",0,-1,true);

    private boolean flexiPages__is_set = false;

    private java.lang.String[] flexiPages = new java.lang.String[0];

    @Override
    public java.lang.String[] getFlexiPages() {
      return flexiPages;
    }

    @Override
    public void setFlexiPages(java.lang.String[] flexiPages) {
      this.flexiPages = flexiPages;
      flexiPages__is_set = true;
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
       __typeMapper.writeObject(__out, flexiPages__typeInfo, flexiPages, flexiPages__is_set);
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
        if (__typeMapper.isElement(__in, flexiPages__typeInfo)) {
            setFlexiPages((java.lang.String[])__typeMapper.readObject(__in, flexiPages__typeInfo, java.lang.String[].class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeFlexiPages_element ");
      sb.append(" flexiPages='").append(com.sforce.ws.util.Verbose.toString(flexiPages)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
