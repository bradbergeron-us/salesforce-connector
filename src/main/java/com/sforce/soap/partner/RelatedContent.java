package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class RelatedContent implements com.sforce.ws.bind.XMLizable , IRelatedContent{

    /**
     * Constructor
     */
    public RelatedContent() {}

    /**
     * element : relatedContentItems of type {urn:partner.soap.sforce.com}DescribeRelatedContentItem
     * java type: com.sforce.soap.partner.DescribeRelatedContentItem[]
     */
    private static final com.sforce.ws.bind.TypeInfo relatedContentItems__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","relatedContentItems","urn:partner.soap.sforce.com","DescribeRelatedContentItem",1,-1,true);

    private boolean relatedContentItems__is_set = false;

    private com.sforce.soap.partner.DescribeRelatedContentItem[] relatedContentItems = new com.sforce.soap.partner.DescribeRelatedContentItem[0];

    @Override
    public com.sforce.soap.partner.DescribeRelatedContentItem[] getRelatedContentItems() {
      return relatedContentItems;
    }

    @Override
    public void setRelatedContentItems(com.sforce.soap.partner.IDescribeRelatedContentItem[] relatedContentItems) {
      this.relatedContentItems = (com.sforce.soap.partner.DescribeRelatedContentItem[])relatedContentItems;
      relatedContentItems__is_set = true;
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
       __typeMapper.writeObject(__out, relatedContentItems__typeInfo, relatedContentItems, relatedContentItems__is_set);
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
        if (__typeMapper.verifyElement(__in, relatedContentItems__typeInfo)) {
            setRelatedContentItems((com.sforce.soap.partner.DescribeRelatedContentItem[])__typeMapper.readObject(__in, relatedContentItems__typeInfo, com.sforce.soap.partner.DescribeRelatedContentItem[].class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[RelatedContent ");
      sb.append(" relatedContentItems='").append(com.sforce.ws.util.Verbose.toString(relatedContentItems)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
