package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeFlexiPageRegion implements com.sforce.ws.bind.XMLizable , IDescribeFlexiPageRegion{

    /**
     * Constructor
     */
    public DescribeFlexiPageRegion() {}

    /**
     * element : components of type {urn:partner.soap.sforce.com}DescribeComponentInstance
     * java type: com.sforce.soap.partner.DescribeComponentInstance[]
     */
    private static final com.sforce.ws.bind.TypeInfo components__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","components","urn:partner.soap.sforce.com","DescribeComponentInstance",0,-1,true);

    private boolean components__is_set = false;

    private com.sforce.soap.partner.DescribeComponentInstance[] components = new com.sforce.soap.partner.DescribeComponentInstance[0];

    @Override
    public com.sforce.soap.partner.DescribeComponentInstance[] getComponents() {
      return components;
    }

    @Override
    public void setComponents(com.sforce.soap.partner.IDescribeComponentInstance[] components) {
      this.components = (com.sforce.soap.partner.DescribeComponentInstance[])components;
      components__is_set = true;
    }

    /**
     * element : name of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo name__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","name","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean name__is_set = false;

    private java.lang.String name;

    @Override
    public java.lang.String getName() {
      return name;
    }

    @Override
    public void setName(java.lang.String name) {
      this.name = name;
      name__is_set = true;
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
       __typeMapper.writeObject(__out, components__typeInfo, components, components__is_set);
       __typeMapper.writeString(__out, name__typeInfo, name, name__is_set);
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
        if (__typeMapper.isElement(__in, components__typeInfo)) {
            setComponents((com.sforce.soap.partner.DescribeComponentInstance[])__typeMapper.readObject(__in, components__typeInfo, com.sforce.soap.partner.DescribeComponentInstance[].class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, name__typeInfo)) {
            setName(__typeMapper.readString(__in, name__typeInfo, java.lang.String.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeFlexiPageRegion ");
      sb.append(" components='").append(com.sforce.ws.util.Verbose.toString(components)).append("'\n");
      sb.append(" name='").append(com.sforce.ws.util.Verbose.toString(name)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
