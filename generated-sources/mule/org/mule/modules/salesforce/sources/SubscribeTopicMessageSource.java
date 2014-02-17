
package org.mule.modules.salesforce.sources;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MessagingException;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.callback.SourceCallback;
import org.mule.api.callback.StopSourceCallback;
import org.mule.api.construct.FlowConstructAware;
import org.mule.api.context.MuleContextAware;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.lifecycle.Startable;
import org.mule.api.lifecycle.Stoppable;
import org.mule.api.source.ClusterizableMessageSource;
import org.mule.config.i18n.CoreMessages;
import org.mule.modules.salesforce.BaseSalesforceConnector;
import org.mule.security.oauth.callback.ProcessCallback;
import org.mule.security.oauth.processor.AbstractListeningMessageProcessor;


/**
 * SubscribeTopicMessageSource wraps {@link org.mule.modules.salesforce.BaseSalesforceConnector#subscribeTopic(java.lang.String, org.mule.api.callback.SourceCallback)} method in {@link BaseSalesforceConnector } as a message source capable of generating Mule events.  The POJO's method is invoked in its own thread.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-02-17T03:16:10-06:00", comments = "Build UNKNOWN_BUILDNUMBER")
public class SubscribeTopicMessageSource
    extends AbstractListeningMessageProcessor
    implements FlowConstructAware, MuleContextAware, Startable, Stoppable, ClusterizableMessageSource
{

    protected Object topic;
    protected String _topicType;
    protected Object username;
    protected String _usernameType;
    protected Object password;
    protected String _passwordType;
    protected Object securityToken;
    protected String _securityTokenType;
    protected Object url;
    protected String _urlType;
    protected Object proxyHost;
    protected String _proxyHostType;
    protected Object proxyPort;
    protected int _proxyPortType;
    protected Object proxyUsername;
    protected String _proxyUsernameType;
    protected Object proxyPassword;
    protected String _proxyPasswordType;
    protected Object sessionId;
    protected String _sessionIdType;
    protected Object serviceEndpoint;
    protected String _serviceEndpointType;
    private StopSourceCallback stopSourceCallback;

    public SubscribeTopicMessageSource(String operationName) {
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

    /**
     * Sets topic
     * 
     * @param value Value to set
     */
    public void setTopic(Object value) {
        this.topic = value;
    }

    /**
     * Sets proxyUsername
     * 
     * @param value Value to set
     */
    public void setProxyUsername(Object value) {
        this.proxyUsername = value;
    }

    /**
     * Sets username
     * 
     * @param value Value to set
     */
    public void setUsername(Object value) {
        this.username = value;
    }

    /**
     * Sets sessionId
     * 
     * @param value Value to set
     */
    public void setSessionId(Object value) {
        this.sessionId = value;
    }

    /**
     * Sets proxyHost
     * 
     * @param value Value to set
     */
    public void setProxyHost(Object value) {
        this.proxyHost = value;
    }

    /**
     * Sets securityToken
     * 
     * @param value Value to set
     */
    public void setSecurityToken(Object value) {
        this.securityToken = value;
    }

    /**
     * Sets serviceEndpoint
     * 
     * @param value Value to set
     */
    public void setServiceEndpoint(Object value) {
        this.serviceEndpoint = value;
    }

    /**
     * Sets proxyPort
     * 
     * @param value Value to set
     */
    public void setProxyPort(Object value) {
        this.proxyPort = value;
    }

    /**
     * Sets password
     * 
     * @param value Value to set
     */
    public void setPassword(Object value) {
        this.password = value;
    }

    /**
     * Sets proxyPassword
     * 
     * @param value Value to set
     */
    public void setProxyPassword(Object value) {
        this.proxyPassword = value;
    }

    /**
     * Sets url
     * 
     * @param value Value to set
     */
    public void setUrl(Object value) {
        this.url = value;
    }

    /**
     * Method to be called when Mule instance gets started.
     * 
     */
    public void start()
        throws MuleException
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(ProcessAdapter.class, false, null);
            ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            final SourceCallback sourceCallback = this;
            final String transformedTopic = ((String) transform(getMuleContext(), ((MuleEvent) null), getClass().getDeclaredField("_topicType").getGenericType(), null, topic));
            processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    stopSourceCallback = ((BaseSalesforceConnector) object).subscribeTopic(transformedTopic, sourceCallback);
                    return null;
                }

            }
            , null, ((MuleEvent) null));
        } catch (Exception e) {
            getMuleContext().getExceptionListener().handleException(e);
        }
    }

    /**
     * Method to be called when Mule instance gets stopped.
     * 
     */
    public void stop()
        throws MuleException
    {
        if (stopSourceCallback!= null) {
            try {
                stopSourceCallback.stop();
            } catch (Exception e) {
                throw new MessagingException(CoreMessages.failedToStop("subscribeTopic"), ((MuleEvent) null), e);
            }
        }
    }

}
