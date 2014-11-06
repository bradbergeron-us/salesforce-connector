package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeTab implements com.sforce.ws.bind.XMLizable , IDescribeTab{

    /**
     * Constructor
     */
    public DescribeTab() {}

    /**
     * element : colors of type {urn:partner.soap.sforce.com}DescribeColor
     * java type: com.sforce.soap.partner.DescribeColor[]
     */
    private static final com.sforce.ws.bind.TypeInfo colors__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","colors","urn:partner.soap.sforce.com","DescribeColor",0,-1,true);

    private boolean colors__is_set = false;

    private com.sforce.soap.partner.DescribeColor[] colors = new com.sforce.soap.partner.DescribeColor[0];

    @Override
    public com.sforce.soap.partner.DescribeColor[] getColors() {
      return colors;
    }

    @Override
    public void setColors(com.sforce.soap.partner.IDescribeColor[] colors) {
      this.colors = (com.sforce.soap.partner.DescribeColor[])colors;
      colors__is_set = true;
    }

    /**
     * element : custom of type {http://www.w3.org/2001/XMLSchema}boolean
     * java type: boolean
     */
    private static final com.sforce.ws.bind.TypeInfo custom__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","custom","http://www.w3.org/2001/XMLSchema","boolean",1,1,true);

    private boolean custom__is_set = false;

    private boolean custom;

    @Override
    public boolean getCustom() {
      return custom;
    }

    @Override
    public boolean isCustom() {
      return custom;
    }

    @Override
    public void setCustom(boolean custom) {
      this.custom = custom;
      custom__is_set = true;
    }

    /**
     * element : iconUrl of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo iconUrl__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","iconUrl","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean iconUrl__is_set = false;

    private java.lang.String iconUrl;

    @Override
    public java.lang.String getIconUrl() {
      return iconUrl;
    }

    @Override
    public void setIconUrl(java.lang.String iconUrl) {
      this.iconUrl = iconUrl;
      iconUrl__is_set = true;
    }

    /**
     * element : icons of type {urn:partner.soap.sforce.com}DescribeIcon
     * java type: com.sforce.soap.partner.DescribeIcon[]
     */
    private static final com.sforce.ws.bind.TypeInfo icons__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","icons","urn:partner.soap.sforce.com","DescribeIcon",0,-1,true);

    private boolean icons__is_set = false;

    private com.sforce.soap.partner.DescribeIcon[] icons = new com.sforce.soap.partner.DescribeIcon[0];

    @Override
    public com.sforce.soap.partner.DescribeIcon[] getIcons() {
      return icons;
    }

    @Override
    public void setIcons(com.sforce.soap.partner.IDescribeIcon[] icons) {
      this.icons = (com.sforce.soap.partner.DescribeIcon[])icons;
      icons__is_set = true;
    }

    /**
     * element : label of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo label__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","label","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean label__is_set = false;

    private java.lang.String label;

    @Override
    public java.lang.String getLabel() {
      return label;
    }

    @Override
    public void setLabel(java.lang.String label) {
      this.label = label;
      label__is_set = true;
    }

    /**
     * element : miniIconUrl of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo miniIconUrl__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","miniIconUrl","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean miniIconUrl__is_set = false;

    private java.lang.String miniIconUrl;

    @Override
    public java.lang.String getMiniIconUrl() {
      return miniIconUrl;
    }

    @Override
    public void setMiniIconUrl(java.lang.String miniIconUrl) {
      this.miniIconUrl = miniIconUrl;
      miniIconUrl__is_set = true;
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
     * element : sobjectName of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo sobjectName__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","sobjectName","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean sobjectName__is_set = false;

    private java.lang.String sobjectName;

    @Override
    public java.lang.String getSobjectName() {
      return sobjectName;
    }

    @Override
    public void setSobjectName(java.lang.String sobjectName) {
      this.sobjectName = sobjectName;
      sobjectName__is_set = true;
    }

    /**
     * element : url of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo url__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","url","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean url__is_set = false;

    private java.lang.String url;

    @Override
    public java.lang.String getUrl() {
      return url;
    }

    @Override
    public void setUrl(java.lang.String url) {
      this.url = url;
      url__is_set = true;
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
       __typeMapper.writeObject(__out, colors__typeInfo, colors, colors__is_set);
       __typeMapper.writeBoolean(__out, custom__typeInfo, custom, custom__is_set);
       __typeMapper.writeString(__out, iconUrl__typeInfo, iconUrl, iconUrl__is_set);
       __typeMapper.writeObject(__out, icons__typeInfo, icons, icons__is_set);
       __typeMapper.writeString(__out, label__typeInfo, label, label__is_set);
       __typeMapper.writeString(__out, miniIconUrl__typeInfo, miniIconUrl, miniIconUrl__is_set);
       __typeMapper.writeString(__out, name__typeInfo, name, name__is_set);
       __typeMapper.writeString(__out, sobjectName__typeInfo, sobjectName, sobjectName__is_set);
       __typeMapper.writeString(__out, url__typeInfo, url, url__is_set);
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
        if (__typeMapper.isElement(__in, colors__typeInfo)) {
            setColors((com.sforce.soap.partner.DescribeColor[])__typeMapper.readObject(__in, colors__typeInfo, com.sforce.soap.partner.DescribeColor[].class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, custom__typeInfo)) {
            setCustom(__typeMapper.readBoolean(__in, custom__typeInfo, boolean.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, iconUrl__typeInfo)) {
            setIconUrl(__typeMapper.readString(__in, iconUrl__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.isElement(__in, icons__typeInfo)) {
            setIcons((com.sforce.soap.partner.DescribeIcon[])__typeMapper.readObject(__in, icons__typeInfo, com.sforce.soap.partner.DescribeIcon[].class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, label__typeInfo)) {
            setLabel(__typeMapper.readString(__in, label__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, miniIconUrl__typeInfo)) {
            setMiniIconUrl(__typeMapper.readString(__in, miniIconUrl__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, name__typeInfo)) {
            setName(__typeMapper.readString(__in, name__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, sobjectName__typeInfo)) {
            setSobjectName(__typeMapper.readString(__in, sobjectName__typeInfo, java.lang.String.class));
        }
        __in.peekTag();
        if (__typeMapper.verifyElement(__in, url__typeInfo)) {
            setUrl(__typeMapper.readString(__in, url__typeInfo, java.lang.String.class));
        }
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeTab ");
      sb.append(" colors='").append(com.sforce.ws.util.Verbose.toString(colors)).append("'\n");
      sb.append(" custom='").append(com.sforce.ws.util.Verbose.toString(custom)).append("'\n");
      sb.append(" iconUrl='").append(com.sforce.ws.util.Verbose.toString(iconUrl)).append("'\n");
      sb.append(" icons='").append(com.sforce.ws.util.Verbose.toString(icons)).append("'\n");
      sb.append(" label='").append(com.sforce.ws.util.Verbose.toString(label)).append("'\n");
      sb.append(" miniIconUrl='").append(com.sforce.ws.util.Verbose.toString(miniIconUrl)).append("'\n");
      sb.append(" name='").append(com.sforce.ws.util.Verbose.toString(name)).append("'\n");
      sb.append(" sobjectName='").append(com.sforce.ws.util.Verbose.toString(sobjectName)).append("'\n");
      sb.append(" url='").append(com.sforce.ws.util.Verbose.toString(url)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }
}
