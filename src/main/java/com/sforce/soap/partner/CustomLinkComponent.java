package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class CustomLinkComponent extends com.sforce.soap.partner.DescribeLayoutComponent {

    /**
     * Constructor
     */
    public CustomLinkComponent() {}

    /**
     * element : customLink of type {urn:partner.soap.sforce.com}DescribeLayoutButton
     * java type: com.sforce.soap.partner.DescribeLayoutButton
     */
    private static final com.sforce.ws.bind.TypeInfo customLink__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","customLink","urn:partner.soap.sforce.com","DescribeLayoutButton",1,1,true);

    private boolean customLink__is_set = false;

    private com.sforce.soap.partner.DescribeLayoutButton customLink;

    public com.sforce.soap.partner.DescribeLayoutButton getCustomLink() {
      return customLink;
    }

    public void setCustomLink(com.sforce.soap.partner.DescribeLayoutButton customLink) {
      this.customLink = customLink;
      customLink__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "urn:partner.soap.sforce.com", "CustomLinkComponent");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeObject(__out, customLink__typeInfo, customLink, customLink__is_set);
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
        if (__typeMapper.verifyElement(__in, customLink__typeInfo)) {
            setCustomLink((com.sforce.soap.partner.DescribeLayoutButton)__typeMapper.readObject(__in, customLink__typeInfo, com.sforce.soap.partner.DescribeLayoutButton.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[CustomLinkComponent ");
      sb.append(super.toString());sb.append(" customLink='").append(com.sforce.ws.util.Verbose.toString(customLink)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
