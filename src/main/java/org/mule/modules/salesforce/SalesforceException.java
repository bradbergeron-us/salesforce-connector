/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce;

import com.sforce.soap.partner.StatusCode;

/**
 * A runtime exception that wraps a {@link StatusCode}
 */
public class SalesforceException extends Exception {

    private final StatusCode statusCode;

    public SalesforceException(StatusCode statusCode, String message, Throwable e) {
        super(message, e);
        this.statusCode = statusCode;
    }

    public SalesforceException(StatusCode statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

}
