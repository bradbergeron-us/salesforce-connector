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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.mule.api.MuleException;
import org.mule.modules.salesforce.api.SalesforceHeader;
import org.mule.modules.salesforce.connection.CustomPartnerConnection;
import org.mule.streaming.ProviderAwarePagingDelegate;

import com.sforce.soap.partner.QueryResult;
import com.sforce.soap.partner.sobject.SObject;
import com.sforce.ws.ConnectionException;

public abstract class SalesforcePagingDelegate extends ProviderAwarePagingDelegate<Map<String, Object>, SalesforceConnector> {
    private String query;
    private Map<SalesforceHeader, Object> headers;
    private String queryLocator = null;
    private QueryResult cachedQueryResult = null;
    private boolean lastPageFound = false;

    public SalesforcePagingDelegate(String query, Map<SalesforceHeader, Object> headers) {
        this.query = query;
        this.headers = headers;
    }

    @Override
    public List<Map<String, Object>> getPage(SalesforceConnector connector) throws Exception {
        if (this.cachedQueryResult != null) {
            List<Map<String, Object>> items = this.consume(this.cachedQueryResult);
            this.cachedQueryResult = null;
            return items;
        }

        if (this.lastPageFound) {
            return Collections.emptyList();
        }

        QueryResult queryResult = getQueryResult(connector);
        setQueryLocatorStatus(queryResult);
        return this.consume(queryResult);
    }

    private void setQueryLocatorStatus(QueryResult queryResult) {
        if (queryResult.isDone()) {
            this.queryLocator = null;
            this.lastPageFound = true;
        } else {
            this.queryLocator = queryResult.getQueryLocator();
        }
    }

    private QueryResult getQueryResult(SalesforceConnector connector) throws ConnectionException {
        return this.queryLocator != null ? connector.getSalesforceSoapAdapter(headers).queryMore(this.queryLocator) : this.doQuery(connector.getSalesforceSoapAdapter(headers), query);
    }

    protected abstract QueryResult doQuery(CustomPartnerConnection connection, String query) throws ConnectionException;

    private List<Map<String, Object>> consume(QueryResult queryResult) {
        List<Map<String, Object>> result = null;
        SObject[] records = queryResult.getRecords();

        if (records != null && records.length > 0) {
            result = new ArrayList<Map<String, Object>>();
            for (SObject object : records) {
                result.add(SalesforceUtils.toMap(object));
            }
        }

        return result;
    }

    @Override
    public void close() throws MuleException {
        this.cachedQueryResult = null;
    }

    @Override
    public int getTotalResults(SalesforceConnector connector) throws Exception {
        if (this.cachedQueryResult == null) {
            this.cachedQueryResult = this.getQueryResult(connector);
            setQueryLocatorStatus(this.cachedQueryResult);
        }
        return this.cachedQueryResult.getSize();
    }

}


