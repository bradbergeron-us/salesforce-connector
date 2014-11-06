package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class SoqlSubQueryCondition extends com.sforce.soap.partner.SoqlWhereCondition implements ISoqlSubQueryCondition{

    /**
     * Constructor
     */
    public SoqlSubQueryCondition() {}

    /**
     * element : field of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo field__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","field","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean field__is_set = false;

    private java.lang.String field;

    @Override
    public java.lang.String getField() {
      return field;
    }

    @Override
    public void setField(java.lang.String field) {
      this.field = field;
      field__is_set = true;
    }

    /**
     * element : operator of type {urn:partner.soap.sforce.com}soqlOperator
     * java type: com.sforce.soap.partner.SoqlOperator
     */
    private static final com.sforce.ws.bind.TypeInfo operator__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","operator","urn:partner.soap.sforce.com","soqlOperator",1,1,true);

    private boolean operator__is_set = false;

    private com.sforce.soap.partner.SoqlOperator operator;

    @Override
    public com.sforce.soap.partner.SoqlOperator getOperator() {
      return operator;
    }

    @Override
    public void setOperator(com.sforce.soap.partner.SoqlOperator operator) {
      this.operator = operator;
      operator__is_set = true;
    }

    /**
     * element : subQuery of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo subQuery__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","subQuery","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean subQuery__is_set = false;

    private java.lang.String subQuery;

    @Override
    public java.lang.String getSubQuery() {
      return subQuery;
    }

    @Override
    public void setSubQuery(java.lang.String subQuery) {
      this.subQuery = subQuery;
      subQuery__is_set = true;
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "urn:partner.soap.sforce.com", "SoqlSubQueryCondition");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeString(__out, field__typeInfo, field, field__is_set);
       __typeMapper.writeObject(__out, operator__typeInfo, operator, operator__is_set);
       __typeMapper.writeString(__out, subQuery__typeInfo, subQuery, subQuery__is_set);
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
        if (__typeMapper.verifyElement(__in, field__typeInfo)) {
            setField(__typeMapper.readString(__in, field__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, operator__typeInfo)) {
            setOperator((com.sforce.soap.partner.SoqlOperator)__typeMapper.readObject(__in, operator__typeInfo, com.sforce.soap.partner.SoqlOperator.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, subQuery__typeInfo)) {
            setSubQuery(__typeMapper.readString(__in, subQuery__typeInfo, java.lang.String.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[SoqlSubQueryCondition ");
      sb.append(super.toString());sb.append(" field='").append(com.sforce.ws.util.Verbose.toString(field)).append("'\n");
      sb.append(" operator='").append(com.sforce.ws.util.Verbose.toString(operator)).append("'\n");
      sb.append(" subQuery='").append(com.sforce.ws.util.Verbose.toString(subQuery)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
