
package org.mule.modules.salesforce.processors;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.RegistrationException;
import org.mule.common.DefaultResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultListMetaDataModel;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.common.metadata.key.property.TypeDescribingProperty;
import org.mule.modules.salesforce.BaseSalesforceConnector;
import org.mule.modules.salesforce.SalesforceOAuthConnector;
import org.mule.modules.salesforce.exception.SalesforceSessionExpiredException;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * RetrieveMessageProcessor invokes the {@link org.mule.modules.salesforce.BaseSalesforceConnector#retrieve(java.lang.String, java.util.List, java.util.List)} method in {@link BaseSalesforceConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-16T09:56:28-05:00", comments = "Build master.1915.dd1962d")
public class RetrieveMessageProcessor
    extends AbstractConnectedProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object type;
    protected String _typeType;
    protected Object ids;
    protected List<String> _idsType;
    protected Object fields;
    protected List<String> _fieldsType;

    public RetrieveMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets ids
     * 
     * @param value Value to set
     */
    public void setIds(Object value) {
        this.ids = value;
    }

    /**
     * Sets type
     * 
     * @param value Value to set
     */
    public void setType(Object value) {
        this.type = value;
    }

    /**
     * Sets fields
     * 
     * @param value Value to set
     */
    public void setFields(Object value) {
        this.fields = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(ProcessAdapter.class, false, event);
            final String _transformedType = ((String) evaluateAndTransform(getMuleContext(), event, RetrieveMessageProcessor.class.getDeclaredField("_typeType").getGenericType(), null, type));
            final List<String> _transformedIds = ((List<String> ) evaluateAndTransform(getMuleContext(), event, RetrieveMessageProcessor.class.getDeclaredField("_idsType").getGenericType(), null, ids));
            final List<String> _transformedFields = ((List<String> ) evaluateAndTransform(getMuleContext(), event, RetrieveMessageProcessor.class.getDeclaredField("_fieldsType").getGenericType(), null, fields));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return Arrays.asList(((Class<? extends Exception> []) new Class[] {SalesforceSessionExpiredException.class, SalesforceSessionExpiredException.class }));
                }

                public boolean isProtected() {
                    return true;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((BaseSalesforceConnector) object).retrieve(_transformedType, _transformedIds, _transformedFields);
                }

            }
            , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(null, (Result.Status.SUCCESS));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        if (((type) == null)||((type).toString() == null)) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error retrieving metadata from parameter: type at processor retrieve at module SalesforceOAuthConnector");
        }
        DefaultMetaDataKey metaDataKey = new DefaultMetaDataKey((type).toString(), null);
        metaDataKey.addProperty(new TypeDescribingProperty(TypeDescribingProperty.TypeScope.OUTPUT, "retrieve"));
        Result<MetaData> genericMetaData = getGenericMetaData(metaDataKey);
        if ((Result.Status.FAILURE).equals(genericMetaData.getStatus())) {
            return genericMetaData;
        }
        return new DefaultResult<MetaData>(new DefaultMetaData(new DefaultListMetaDataModel(genericMetaData.get().getPayload())));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

    public Result<MetaData> getGenericMetaData(MetaDataKey metaDataKey) {
        ConnectorMetaDataEnabled connector;
        try {
            connector = ((ConnectorMetaDataEnabled) findOrCreate(SalesforceOAuthConnector.class, true, null));
            try {
                Result<MetaData> metadata = connector.getMetaData(metaDataKey);
                if ((Result.Status.FAILURE).equals(metadata.getStatus())) {
                    return metadata;
                }
                if (metadata.get() == null) {
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at SalesforceOAuthConnector at retrieve retrieving was successful but result is null");
                }
                return metadata;
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
            }
        } catch (ClassCastException cast) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error getting metadata, there was no connection manager available. Maybe you're trying to use metadata from an Oauth connector");
        } catch (ConfigurationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (RegistrationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (IllegalAccessException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (InstantiationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        }
    }

}