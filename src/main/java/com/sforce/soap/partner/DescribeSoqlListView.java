package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeSoqlListView implements com.sforce.ws.bind.XMLizable , IDescribeSoqlListView{

    /**
     * Constructor
     */
    public DescribeSoqlListView() {}

    /**
     * element : columns of type {urn:partner.soap.sforce.com}ListViewColumn
     * java type: com.sforce.soap.partner.ListViewColumn[]
     */
    private static final com.sforce.ws.bind.TypeInfo columns__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","columns","urn:partner.soap.sforce.com","ListViewColumn",1,-1,true);

    private boolean columns__is_set = false;

    private com.sforce.soap.partner.ListViewColumn[] columns = new com.sforce.soap.partner.ListViewColumn[0];

    @Override
    public com.sforce.soap.partner.ListViewColumn[] getColumns() {
      return columns;
    }

    @Override
    public void setColumns(com.sforce.soap.partner.IListViewColumn[] columns) {
      this.columns = (com.sforce.soap.partner.ListViewColumn[])columns;
      columns__is_set = true;
    }

    /**
     * element : id of type {urn:partner.soap.sforce.com}ID
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo id__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","id","urn:partner.soap.sforce.com","ID",1,1,true);

    private boolean id__is_set = false;

    private java.lang.String id;

    @Override
    public java.lang.String getId() {
      return id;
    }

    @Override
    public void setId(java.lang.String id) {
      this.id = id;
      id__is_set = true;
    }

    /**
     * element : orderBy of type {urn:partner.soap.sforce.com}ListViewOrderBy
     * java type: com.sforce.soap.partner.ListViewOrderBy[]
     */
    private static final com.sforce.ws.bind.TypeInfo orderBy__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","orderBy","urn:partner.soap.sforce.com","ListViewOrderBy",1,-1,true);

    private boolean orderBy__is_set = false;

    private com.sforce.soap.partner.ListViewOrderBy[] orderBy = new com.sforce.soap.partner.ListViewOrderBy[0];

    @Override
    public com.sforce.soap.partner.ListViewOrderBy[] getOrderBy() {
      return orderBy;
    }

    @Override
    public void setOrderBy(com.sforce.soap.partner.IListViewOrderBy[] orderBy) {
      this.orderBy = (com.sforce.soap.partner.ListViewOrderBy[])orderBy;
      orderBy__is_set = true;
    }

    /**
     * element : query of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo query__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","query","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean query__is_set = false;

    private java.lang.String query;

    @Override
    public java.lang.String getQuery() {
      return query;
    }

    @Override
    public void setQuery(java.lang.String query) {
      this.query = query;
      query__is_set = true;
    }

    /**
     * element : scope of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo scope__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","scope","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean scope__is_set = false;

    private java.lang.String scope;

    @Override
    public java.lang.String getScope() {
      return scope;
    }

    @Override
    public void setScope(java.lang.String scope) {
      this.scope = scope;
      scope__is_set = true;
    }

    /**
     * element : sobjectType of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo sobjectType__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","sobjectType","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean sobjectType__is_set = false;

    private java.lang.String sobjectType;

    @Override
    public java.lang.String getSobjectType() {
      return sobjectType;
    }

    @Override
    public void setSobjectType(java.lang.String sobjectType) {
      this.sobjectType = sobjectType;
      sobjectType__is_set = true;
    }

    /**
     * element : whereCondition of type {urn:partner.soap.sforce.com}SoqlWhereCondition
     * java type: com.sforce.soap.partner.SoqlWhereCondition
     */
    private static final com.sforce.ws.bind.TypeInfo whereCondition__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","whereCondition","urn:partner.soap.sforce.com","SoqlWhereCondition",0,1,true);

    private boolean whereCondition__is_set = false;

    private com.sforce.soap.partner.SoqlWhereCondition whereCondition;

    @Override
    public com.sforce.soap.partner.SoqlWhereCondition getWhereCondition() {
      return whereCondition;
    }

    @Override
    public void setWhereCondition(com.sforce.soap.partner.ISoqlWhereCondition whereCondition) {
      this.whereCondition = (com.sforce.soap.partner.SoqlWhereCondition)whereCondition;
      whereCondition__is_set = true;
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
       __typeMapper.writeObject(__out, columns__typeInfo, columns, columns__is_set);
       __typeMapper.writeString(__out, id__typeInfo, id, id__is_set);
       __typeMapper.writeObject(__out, orderBy__typeInfo, orderBy, orderBy__is_set);
       __typeMapper.writeString(__out, query__typeInfo, query, query__is_set);
       __typeMapper.writeString(__out, scope__typeInfo, scope, scope__is_set);
       __typeMapper.writeString(__out, sobjectType__typeInfo, sobjectType, sobjectType__is_set);
       __typeMapper.writeObject(__out, whereCondition__typeInfo, whereCondition, whereCondition__is_set);
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
        if (__typeMapper.verifyElement(__in, columns__typeInfo)) {
            setColumns((com.sforce.soap.partner.ListViewColumn[])__typeMapper.readObject(__in, columns__typeInfo, com.sforce.soap.partner.ListViewColumn[].class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, id__typeInfo)) {
            setId(__typeMapper.readString(__in, id__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, orderBy__typeInfo)) {
            setOrderBy((com.sforce.soap.partner.ListViewOrderBy[])__typeMapper.readObject(__in, orderBy__typeInfo, com.sforce.soap.partner.ListViewOrderBy[].class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, query__typeInfo)) {
            setQuery(__typeMapper.readString(__in, query__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, scope__typeInfo)) {
            setScope(__typeMapper.readString(__in, scope__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, sobjectType__typeInfo)) {
            setSobjectType(__typeMapper.readString(__in, sobjectType__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, whereCondition__typeInfo)) {
            setWhereCondition((com.sforce.soap.partner.SoqlWhereCondition)__typeMapper.readObject(__in, whereCondition__typeInfo, com.sforce.soap.partner.SoqlWhereCondition.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeSoqlListView ");
      sb.append(" columns='").append(com.sforce.ws.util.Verbose.toString(columns)).append("'\n");
      sb.append(" id='").append(com.sforce.ws.util.Verbose.toString(id)).append("'\n");
      sb.append(" orderBy='").append(com.sforce.ws.util.Verbose.toString(orderBy)).append("'\n");
      sb.append(" query='").append(com.sforce.ws.util.Verbose.toString(query)).append("'\n");
      sb.append(" scope='").append(com.sforce.ws.util.Verbose.toString(scope)).append("'\n");
      sb.append(" sobjectType='").append(com.sforce.ws.util.Verbose.toString(sobjectType)).append("'\n");
      sb.append(" whereCondition='").append(com.sforce.ws.util.Verbose.toString(whereCondition)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
