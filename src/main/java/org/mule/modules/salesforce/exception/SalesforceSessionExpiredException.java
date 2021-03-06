/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce.exception;

public class SalesforceSessionExpiredException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public SalesforceSessionExpiredException() {
        super();
    }

    public SalesforceSessionExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public SalesforceSessionExpiredException(String message) {
        super(message);
    }

    public SalesforceSessionExpiredException(Throwable cause) {
        super(cause);
    }
}
