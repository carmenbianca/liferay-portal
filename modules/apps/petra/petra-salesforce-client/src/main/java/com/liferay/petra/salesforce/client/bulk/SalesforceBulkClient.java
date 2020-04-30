/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.salesforce.client.bulk;

import com.liferay.petra.salesforce.client.SalesforceClient;

import com.sforce.async.AsyncApiException;
import com.sforce.async.BatchInfo;
import com.sforce.async.JobInfo;
import com.sforce.async.QueryResultList;
import com.sforce.ws.ConnectionException;

import java.io.InputStream;

/**
 * @author Brian Wing Shun Chan
 * @author Peter Shin
 */
public interface SalesforceBulkClient extends SalesforceClient {

	public JobInfo abortJob(String jobInfoId, int retryCount)
		throws AsyncApiException, ConnectionException;

	public JobInfo closeJob(String jobInfoId, int retryCount)
		throws AsyncApiException, ConnectionException;

	public BatchInfo createBatchFromStream(
			JobInfo jobInfo, InputStream inputStream, int retryCount)
		throws AsyncApiException, ConnectionException;

	public JobInfo createJob(JobInfo jobInfo, int retryCount)
		throws AsyncApiException, ConnectionException;

	public BatchInfo getBatchInfo(
			String jobInfoId, String batchInfoId, int retryCount)
		throws AsyncApiException, ConnectionException;

	public QueryResultList getQueryResultList(
			String jobInfoId, String batchInfoId, int retryCount)
		throws AsyncApiException, ConnectionException;

	public InputStream getQueryResultStream(
			String jobInfoId, String batchInfoId, String queryResultId,
			int retryCount)
		throws AsyncApiException, ConnectionException;

}