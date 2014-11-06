package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DeleteResponse_element implements com.sforce.ws.bind.XMLizable , IDeleteResponse_element{

    /**
     * Constructor
     */
    public DeleteResponse_element() {}

    /**
     * element : result of type {urn:partner.soap.sforce.com}DeleteResult
     * java type: com.sforce.soap.partner.DeleteResult[]
     */
    private static final com.sforce.ws.bind.TypeInfo result__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","result","urn:partner.soap.sforce.com","DeleteResult",0,-1,true);

    private boolean result__is_set = false;

    private com.sforce.soap.partner.DeleteResult[] result = new com.sforce.soap.partner.DeleteResult[0];

    @Override
    public com.sforce.soap.partner.DeleteResult[] getResult() {
      return result;
    }

    @Override
    public void setResult(com.sforce.soap.partner.IDeleteResult[] result) {
      this.result = (com.sforce.soap.partner.DeleteResult[])result;
      result__is_set = true;
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
       __typeMapper.writeObject(__out, result__typeInfo, result, result__is_set);
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
        if (__typeMapper.isElement(__in, result__typeInfo)) {
            setResult((com.sforce.soap.partner.DeleteResult[])__typeMapper.readObject(__in, result__typeInfo, com.sforce.soap.partner.DeleteResult[].class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DeleteResponse_element ");
      sb.append(" result='").append(com.sforce.ws.util.Verbose.toString(result)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
