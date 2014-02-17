
package org.mule.modules.salesforce.connectivity;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.mule.api.ConnectionException;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.MetadataAware;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.config.MuleProperties;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.context.MuleContextAware;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.capability.Capabilities;
import org.mule.api.devkit.capability.ModuleCapability;
import org.mule.api.lifecycle.Disposable;
import org.mule.api.lifecycle.Initialisable;
import org.mule.api.retry.RetryPolicyTemplate;
import org.mule.api.store.ObjectStore;
import org.mule.common.DefaultResult;
import org.mule.common.DefaultTestResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.TestResult;
import org.mule.common.Testable;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataFailureType;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.NativeQueryMetadataTranslator;
import org.mule.common.query.DsqlQuery;
import org.mule.config.PoolingProfile;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.salesforce.SalesforceConnector;
import org.mule.modules.salesforce.adapters.SalesforceConnectorConnectionIdentifierAdapter;
import org.mule.modules.salesforce.connection.ConnectionManager;
import org.mule.modules.salesforce.connection.UnableToAcquireConnectionException;
import org.mule.modules.salesforce.processors.AbstractConnectedProcessor;


/**
 * A {@code SalesforceConnectorConnectionManager} is a wrapper around {@link SalesforceConnector } that adds connection management capabilities to the pojo.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-02-17T10:24:09-06:00", comments = "Build UNKNOWN_BUILDNUMBER")
public class SalesforceConnectorConnectionManager
    extends ExpressionEvaluatorSupport
    implements MetadataAware, MuleContextAware, ProcessAdapter<SalesforceConnectorConnectionIdentifierAdapter> , Capabilities, Disposable, Initialisable, Testable, ConnectorMetaDataEnabled, NativeQueryMetadataTranslator, ConnectionManager<SalesforceConnectorConnectionKey, SalesforceConnectorConnectionIdentifierAdapter>
{

    /**
     * 
     */
    private String username;
    /**
     * 
     */
    private String password;
    /**
     * 
     */
    private String securityToken;
    /**
     * 
     */
    private String url;
    /**
     * 
     */
    private String proxyHost;
    /**
     * 
     */
    private int proxyPort;
    /**
     * 
     */
    private String proxyUsername;
    /**
     * 
     */
    private String proxyPassword;
    /**
     * 
     */
    private String sessionId;
    /**
     * 
     */
    private String serviceEndpoint;
    private ObjectStore<? extends Serializable> timeObjectStore;
    private String clientId;
    private String assignmentRuleId;
    private Boolean useDefaultRule;
    private Integer batchSobjectMaxDepth;
    private Boolean allowFieldTruncationSupport;
    /**
     * Mule Context
     * 
     */
    protected MuleContext muleContext;
    /**
     * Flow Construct
     * 
     */
    protected FlowConstruct flowConstruct;
    /**
     * Connector Pool
     * 
     */
    private GenericKeyedObjectPool connectionPool;
    protected PoolingProfile connectionPoolingProfile;
    protected RetryPolicyTemplate retryPolicyTemplate;
    private final static String MODULE_NAME = "Salesforce";
    private final static String MODULE_VERSION = "5.4.5-SNAPSHOT";
    private final static String DEVKIT_VERSION = "3.5.0-SNAPSHOT";
    private final static String DEVKIT_BUILD = "UNKNOWN_BUILDNUMBER";
    private final static String MIN_MULE_VERSION = "3.5";

    /**
     * Sets timeObjectStore
     * 
     * @param value Value to set
     */
    public void setTimeObjectStore(ObjectStore<? extends Serializable> value) {
        this.timeObjectStore = value;
    }

    /**
     * Retrieves timeObjectStore
     * 
     */
    public ObjectStore<? extends Serializable> getTimeObjectStore() {
        return this.timeObjectStore;
    }

    /**
     * Sets clientId
     * 
     * @param value Value to set
     */
    public void setClientId(String value) {
        this.clientId = value;
    }

    /**
     * Retrieves clientId
     * 
     */
    public String getClientId() {
        return this.clientId;
    }

    /**
     * Sets assignmentRuleId
     * 
     * @param value Value to set
     */
    public void setAssignmentRuleId(String value) {
        this.assignmentRuleId = value;
    }

    /**
     * Retrieves assignmentRuleId
     * 
     */
    public String getAssignmentRuleId() {
        return this.assignmentRuleId;
    }

    /**
     * Sets useDefaultRule
     * 
     * @param value Value to set
     */
    public void setUseDefaultRule(Boolean value) {
        this.useDefaultRule = value;
    }

    /**
     * Retrieves useDefaultRule
     * 
     */
    public Boolean getUseDefaultRule() {
        return this.useDefaultRule;
    }

    /**
     * Sets batchSobjectMaxDepth
     * 
     * @param value Value to set
     */
    public void setBatchSobjectMaxDepth(Integer value) {
        this.batchSobjectMaxDepth = value;
    }

    /**
     * Retrieves batchSobjectMaxDepth
     * 
     */
    public Integer getBatchSobjectMaxDepth() {
        return this.batchSobjectMaxDepth;
    }

    /**
     * Sets allowFieldTruncationSupport
     * 
     * @param value Value to set
     */
    public void setAllowFieldTruncationSupport(Boolean value) {
        this.allowFieldTruncationSupport = value;
    }

    /**
     * Retrieves allowFieldTruncationSupport
     * 
     */
    public Boolean getAllowFieldTruncationSupport() {
        return this.allowFieldTruncationSupport;
    }

    /**
     * Sets muleContext
     * 
     * @param value Value to set
     */
    public void setMuleContext(MuleContext value) {
        this.muleContext = value;
    }

    /**
     * Retrieves muleContext
     * 
     */
    public MuleContext getMuleContext() {
        return this.muleContext;
    }

    /**
     * Sets flowConstruct
     * 
     * @param value Value to set
     */
    public void setFlowConstruct(FlowConstruct value) {
        this.flowConstruct = value;
    }

    /**
     * Retrieves flowConstruct
     * 
     */
    public FlowConstruct getFlowConstruct() {
        return this.flowConstruct;
    }

    /**
     * Sets connectionPoolingProfile
     * 
     * @param value Value to set
     */
    public void setConnectionPoolingProfile(PoolingProfile value) {
        this.connectionPoolingProfile = value;
    }

    /**
     * Retrieves connectionPoolingProfile
     * 
     */
    public PoolingProfile getConnectionPoolingProfile() {
        return this.connectionPoolingProfile;
    }

    /**
     * Sets retryPolicyTemplate
     * 
     * @param value Value to set
     */
    public void setRetryPolicyTemplate(RetryPolicyTemplate value) {
        this.retryPolicyTemplate = value;
    }

    /**
     * Retrieves retryPolicyTemplate
     * 
     */
    public RetryPolicyTemplate getRetryPolicyTemplate() {
        return this.retryPolicyTemplate;
    }

    /**
     * Sets proxyUsername
     * 
     * @param value Value to set
     */
    public void setProxyUsername(String value) {
        this.proxyUsername = value;
    }

    /**
     * Retrieves proxyUsername
     * 
     */
    public String getProxyUsername() {
        return this.proxyUsername;
    }

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Retrieves username
     * 
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets sessionId
     * 
     * @param value Value to set
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Retrieves sessionId
     * 
     */
    public String getSessionId() {
        return this.sessionId;
    }

    /**
     * Sets proxyHost
     * 
     * @param value Value to set
     */
    public void setProxyHost(String value) {
        this.proxyHost = value;
    }

    /**
     * Retrieves proxyHost
     * 
     */
    public String getProxyHost() {
        return this.proxyHost;
    }

    /**
     * Sets securityToken
     * 
     * @param value Value to set
     */
    public void setSecurityToken(String value) {
        this.securityToken = value;
    }

    /**
     * Retrieves securityToken
     * 
     */
    public String getSecurityToken() {
        return this.securityToken;
    }

    /**
     * Sets serviceEndpoint
     * 
     * @param value Value to set
     */
    public void setServiceEndpoint(String value) {
        this.serviceEndpoint = value;
    }

    /**
     * Retrieves serviceEndpoint
     * 
     */
    public String getServiceEndpoint() {
        return this.serviceEndpoint;
    }

    /**
     * Sets proxyPort
     * 
     * @param value Value to set
     */
    public void setProxyPort(int value) {
        this.proxyPort = value;
    }

    /**
     * Retrieves proxyPort
     * 
     */
    public int getProxyPort() {
        return this.proxyPort;
    }

    /**
     * Sets password
     * 
     * @param value Value to set
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Retrieves password
     * 
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets proxyPassword
     * 
     * @param value Value to set
     */
    public void setProxyPassword(String value) {
        this.proxyPassword = value;
    }

    /**
     * Retrieves proxyPassword
     * 
     */
    public String getProxyPassword() {
        return this.proxyPassword;
    }

    /**
     * Sets url
     * 
     * @param value Value to set
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Retrieves url
     * 
     */
    public String getUrl() {
        return this.url;
    }

    public void initialise() {
        GenericKeyedObjectPool.Config config = new GenericKeyedObjectPool.Config();
        if (connectionPoolingProfile!= null) {
            config.maxIdle = connectionPoolingProfile.getMaxIdle();
            config.maxActive = connectionPoolingProfile.getMaxActive();
            config.maxWait = connectionPoolingProfile.getMaxWait();
            config.whenExhaustedAction = ((byte) connectionPoolingProfile.getExhaustedAction());
            config.timeBetweenEvictionRunsMillis = connectionPoolingProfile.getEvictionCheckIntervalMillis();
            config.minEvictableIdleTimeMillis = connectionPoolingProfile.getMinEvictionMillis();
        }
        connectionPool = new GenericKeyedObjectPool(new SalesforceConnectorConnectionFactory(this), config);
        if (retryPolicyTemplate == null) {
            retryPolicyTemplate = muleContext.getRegistry().lookupObject(MuleProperties.OBJECT_DEFAULT_RETRY_POLICY_TEMPLATE);
        }
    }

    @Override
    public void dispose() {
        try {
            connectionPool.close();
        } catch (Exception e) {
        }
    }

    public SalesforceConnectorConnectionIdentifierAdapter acquireConnection(SalesforceConnectorConnectionKey key)
        throws Exception
    {
        return ((SalesforceConnectorConnectionIdentifierAdapter) connectionPool.borrowObject(key));
    }

    public void releaseConnection(SalesforceConnectorConnectionKey key, SalesforceConnectorConnectionIdentifierAdapter connection)
        throws Exception
    {
        connectionPool.returnObject(key, connection);
    }

    public void destroyConnection(SalesforceConnectorConnectionKey key, SalesforceConnectorConnectionIdentifierAdapter connection)
        throws Exception
    {
        connectionPool.invalidateObject(key, connection);
    }

    /**
     * Returns true if this module implements such capability
     * 
     */
    public boolean isCapableOf(ModuleCapability capability) {
        if (capability == ModuleCapability.LIFECYCLE_CAPABLE) {
            return true;
        }
        if (capability == ModuleCapability.CONNECTION_MANAGEMENT_CAPABLE) {
            return true;
        }
        return false;
    }

    @Override
    public<P >ProcessTemplate<P, SalesforceConnectorConnectionIdentifierAdapter> getProcessTemplate() {
        return new ManagedConnectionProcessTemplate(this, muleContext);
    }

    @Override
    public SalesforceConnectorConnectionKey getDefaultConnectionKey() {
        return new SalesforceConnectorConnectionKey(getUsername(), getPassword(), getSecurityToken(), getUrl(), getProxyHost(), getProxyPort(), getProxyUsername(), getProxyPassword(), getSessionId(), getServiceEndpoint());
    }

    @Override
    public SalesforceConnectorConnectionKey getEvaluatedConnectionKey(MuleEvent event)
        throws Exception
    {
        if (event!= null) {
            final String _transformedUsername = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_usernameType").getGenericType(), null, getUsername()));
            if (_transformedUsername == null) {
                throw new UnableToAcquireConnectionException("Parameter username in method connect can't be null because is not @Optional");
            }
            final String _transformedPassword = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_passwordType").getGenericType(), null, getPassword()));
            if (_transformedPassword == null) {
                throw new UnableToAcquireConnectionException("Parameter password in method connect can't be null because is not @Optional");
            }
            final String _transformedSecurityToken = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_securityTokenType").getGenericType(), null, getSecurityToken()));
            if (_transformedSecurityToken == null) {
                throw new UnableToAcquireConnectionException("Parameter securityToken in method connect can't be null because is not @Optional");
            }
            final String _transformedUrl = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_urlType").getGenericType(), null, getUrl()));
            final String _transformedProxyHost = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_proxyHostType").getGenericType(), null, getProxyHost()));
            final Integer _transformedProxyPort = ((Integer) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_proxyPortType").getGenericType(), null, getProxyPort()));
            final String _transformedProxyUsername = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_proxyUsernameType").getGenericType(), null, getProxyUsername()));
            final String _transformedProxyPassword = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_proxyPasswordType").getGenericType(), null, getProxyPassword()));
            final String _transformedSessionId = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_sessionIdType").getGenericType(), null, getSessionId()));
            final String _transformedServiceEndpoint = ((String) evaluateAndTransform(muleContext, event, AbstractConnectedProcessor.class.getDeclaredField("_serviceEndpointType").getGenericType(), null, getServiceEndpoint()));
            return new SalesforceConnectorConnectionKey(_transformedUsername, _transformedPassword, _transformedSecurityToken, _transformedUrl, _transformedProxyHost, _transformedProxyPort, _transformedProxyUsername, _transformedProxyPassword, _transformedSessionId, _transformedServiceEndpoint);
        }
        return getDefaultConnectionKey();
    }

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

    public TestResult test() {
        SalesforceConnectorConnectionIdentifierAdapter connection = null;
        DefaultTestResult result;
        SalesforceConnectorConnectionKey key = getDefaultConnectionKey();
        try {
            connection = acquireConnection(key);
            result = new DefaultTestResult(Result.Status.SUCCESS);
        } catch (Exception e) {
            try {
                destroyConnection(key, connection);
            } catch (Exception ie) {
            }
            result = ((DefaultTestResult) buildFailureTestResult(e));
        } finally {
            if (connection!= null) {
                try {
                    releaseConnection(key, connection);
                } catch (Exception ie) {
                }
            }
        }
        return result;
    }

    public DefaultResult buildFailureTestResult(Exception exception) {
        DefaultTestResult result;
        if (exception instanceof ConnectionException) {
            ConnectionExceptionCode code = ((ConnectionException) exception).getCode();
            if (code == ConnectionExceptionCode.UNKNOWN_HOST) {
                result = new DefaultTestResult(Result.Status.FAILURE, exception.getMessage(), FailureType.UNKNOWN_HOST, exception);
            } else {
                if (code == ConnectionExceptionCode.CANNOT_REACH) {
                    result = new DefaultTestResult(Result.Status.FAILURE, exception.getMessage(), FailureType.RESOURCE_UNAVAILABLE, exception);
                } else {
                    if (code == ConnectionExceptionCode.INCORRECT_CREDENTIALS) {
                        result = new DefaultTestResult(Result.Status.FAILURE, exception.getMessage(), FailureType.INVALID_CREDENTIALS, exception);
                    } else {
                        if (code == ConnectionExceptionCode.CREDENTIALS_EXPIRED) {
                            result = new DefaultTestResult(Result.Status.FAILURE, exception.getMessage(), FailureType.INVALID_CREDENTIALS, exception);
                        } else {
                            if (code == ConnectionExceptionCode.UNKNOWN) {
                                result = new DefaultTestResult(Result.Status.FAILURE, exception.getMessage(), FailureType.UNSPECIFIED, exception);
                            } else {
                                result = new DefaultTestResult(Result.Status.FAILURE, exception.getMessage(), FailureType.UNSPECIFIED, exception);
                            }
                        }
                    }
                }
            }
        } else {
            result = new DefaultTestResult(Result.Status.FAILURE, exception.getMessage(), FailureType.UNSPECIFIED, exception);
        }
        return result;
    }

    @Override
    public Result<List<MetaDataKey>> getMetaDataKeys() {
        SalesforceConnectorConnectionIdentifierAdapter connection = null;
        SalesforceConnectorConnectionKey key = getDefaultConnectionKey();
        try {
            connection = acquireConnection(key);
            try {
                return new DefaultResult<List<MetaDataKey>>(connection.getMetaDataKeys(), (Result.Status.SUCCESS));
            } catch (Exception e) {
                return new DefaultResult<List<MetaDataKey>>(null, (Result.Status.FAILURE), "There was an error retrieving the metadata keys from service provider after acquiring connection, for more detailed information please read the provided stacktrace", MetaDataFailureType.ERROR_METADATA_KEYS_RETRIEVER, e);
            }
        } catch (Exception e) {
            try {
                destroyConnection(key, connection);
            } catch (Exception ie) {
            }
            return ((DefaultResult<List<MetaDataKey>> ) buildFailureTestResult(e));
        } finally {
            if (connection!= null) {
                try {
                    releaseConnection(key, connection);
                } catch (Exception ie) {
                }
            }
        }
    }

    @Override
    public Result<MetaData> getMetaData(MetaDataKey metaDataKey) {
        SalesforceConnectorConnectionIdentifierAdapter connection = null;
        SalesforceConnectorConnectionKey key = getDefaultConnectionKey();
        try {
            connection = acquireConnection(key);
            try {
                return new DefaultResult<MetaData>(connection.getMetaData(metaDataKey));
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), getMetaDataException(metaDataKey), MetaDataFailureType.ERROR_METADATA_RETRIEVER, e);
            }
        } catch (Exception e) {
            try {
                destroyConnection(key, connection);
            } catch (Exception ie) {
            }
            return ((DefaultResult<MetaData> ) buildFailureTestResult(e));
        } finally {
            if (connection!= null) {
                try {
                    releaseConnection(key, connection);
                } catch (Exception ie) {
                }
            }
        }
    }

    private String getMetaDataException(MetaDataKey key) {
        if ((key!= null)&&(key.getId()!= null)) {
            return ("There was an error retrieving metadata from key: "+(key.getId()+" after acquiring the connection, for more detailed information please read the provided stacktrace"));
        } else {
            return "There was an error retrieving metadata after acquiring the connection, MetaDataKey is null or its id is null, for more detailed information please read the provided stacktrace";
        }
    }

    @Override
    public Result<String> toNativeQuery(DsqlQuery query) {
        SalesforceConnectorConnectionIdentifierAdapter connection = null;
        Result<String> result;
        SalesforceConnectorConnectionKey key = getDefaultConnectionKey();
        try {
            connection = acquireConnection(key);
            result = new DefaultResult<String>(connection.toNativeQuery(query).toString());
        } catch (Exception e) {
            try {
                destroyConnection(key, connection);
            } catch (Exception ie) {
            }
            result = new DefaultResult<String>(null, Result.Status.FAILURE, e.getMessage());
        } finally {
            if (connection!= null) {
                try {
                    releaseConnection(key, connection);
                } catch (Exception ie) {
                }
            }
        }
        return result;
    }

}
