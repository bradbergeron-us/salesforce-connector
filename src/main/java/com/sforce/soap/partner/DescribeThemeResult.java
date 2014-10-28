package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeThemeResult implements com.sforce.ws.bind.XMLizable {

    /**
     * Constructor
     */
    public DescribeThemeResult() {}

    /**
     * element : themeItems of type {urn:partner.soap.sforce.com}DescribeThemeItem
     * java type: com.sforce.soap.partner.DescribeThemeItem[]
     */
    private static final com.sforce.ws.bind.TypeInfo themeItems__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","themeItems","urn:partner.soap.sforce.com","DescribeThemeItem",0,-1,true);

    private boolean themeItems__is_set = false;

    private com.sforce.soap.partner.DescribeThemeItem[] themeItems = new com.sforce.soap.partner.DescribeThemeItem[0];

    public com.sforce.soap.partner.DescribeThemeItem[] getThemeItems() {
      return themeItems;
    }

    public void setThemeItems(com.sforce.soap.partner.DescribeThemeItem[] themeItems) {
      this.themeItems = themeItems;
      themeItems__is_set = true;
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
       __typeMapper.writeObject(__out, themeItems__typeInfo, themeItems, themeItems__is_set);
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
        if (__typeMapper.isElement(__in, themeItems__typeInfo)) {
            setThemeItems((com.sforce.soap.partner.DescribeThemeItem[])__typeMapper.readObject(__in, themeItems__typeInfo, com.sforce.soap.partner.DescribeThemeItem[].class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeThemeResult ");
      sb.append(" themeItems='").append(com.sforce.ws.util.Verbose.toString(themeItems)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}