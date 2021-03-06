/**
 * Mule Salesforce Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.modules.salesforce.api;

import java.lang.reflect.Method;
import java.util.Arrays;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import org.apache.log4j.Logger;
import org.mule.modules.salesforce.connection.CustomMetadataConnection;

/**
 * Adapter for Salesforce Rest Partner Connection
 *
 * @author Mulesoft, Inc
 */
public class SalesforceMetadataAdapter {
    private static final Logger logger = Logger.getLogger(SalesforceMetadataAdapter.class);
    
    private SalesforceMetadataAdapter() {
    }

    public static CustomMetadataConnection adapt(final CustomMetadataConnection facade) {

        return (CustomMetadataConnection) Enhancer.create(
        		CustomMetadataConnection.class,
            new InvocationHandler() {
                public Object invoke(Object proxy, Method method,
                                     Object[] args) throws Throwable {
                    if (logger.isDebugEnabled()) {
                        logger.debug(String.format(
                                "Invoked method %s with arguments %s",
                                method.getName(), Arrays.toString(args)));
                    }
                    try {
                        Object ret = method.invoke(facade, args);
                        if (logger.isDebugEnabled()) {
                            logger.debug(String.format(
                                    "Returned method %s with value %s",
                                    ret, Arrays.toString(args)));
                        }

                        return ret;
                    } catch (Exception e) {
                        if (logger.isDebugEnabled()) {
                            logger.debug("Method " + method.getName() + " threw " + e.getClass());
                        }

                        throw SalesforceExceptionHandlerAdapter.analyzeSoapException(e);
                    }

                }

            });
    }
}
