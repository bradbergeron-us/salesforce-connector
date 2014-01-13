
package org.mule.modules.salesforce.oauth;

import java.io.Serializable;
import javax.annotation.Generated;
import org.mule.modules.salesforce.SalesforceOAuthConnector;


/**
 * Serializable class used to save and restore OAuth state from {@link SalesforceOAuthConnector }
 * 
 */
@Deprecated
@Generated(value = "Mule DevKit Version 3.5.0-cascade", date = "2014-01-13T09:22:38-06:00", comments = "Build UNNAMED.1791.ad9d188")
public class SalesforceOAuthConnectorOAuthState implements Serializable
{

    public String accessToken;
    public String authorizationUrl;
    public String accessTokenUrl;
    public String refreshToken;
    public String instanceId;

    /**
     * Retrieves accessToken
     * 
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * Sets accessToken
     * 
     * @param value Value to set
     */
    public void setAccessToken(String value) {
        this.accessToken = value;
    }

    /**
     * Retrieves authorizationUrl
     * 
     */
    public String getAuthorizationUrl() {
        return this.authorizationUrl;
    }

    /**
     * Sets authorizationUrl
     * 
     * @param value Value to set
     */
    public void setAuthorizationUrl(String value) {
        this.authorizationUrl = value;
    }

    /**
     * Retrieves accessTokenUrl
     * 
     */
    public String getAccessTokenUrl() {
        return this.accessTokenUrl;
    }

    /**
     * Sets accessTokenUrl
     * 
     * @param value Value to set
     */
    public void setAccessTokenUrl(String value) {
        this.accessTokenUrl = value;
    }

    /**
     * Retrieves refreshToken
     * 
     */
    public String getRefreshToken() {
        return this.refreshToken;
    }

    /**
     * Sets refreshToken
     * 
     * @param value Value to set
     */
    public void setRefreshToken(String value) {
        this.refreshToken = value;
    }

    /**
     * Retrieves instanceId
     * 
     */
    public String getInstanceId() {
        return this.instanceId;
    }

    /**
     * Sets instanceId
     * 
     * @param value Value to set
     */
    public void setInstanceId(String value) {
        this.instanceId = value;
    }

}
