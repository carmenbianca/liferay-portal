/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.cluster;

import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

/**
 * @author Dylan Rebelak
 */
public class HealthClusterRequest
	extends CrossClusterRequest
	implements ClusterRequest<HealthClusterResponse> {

	public HealthClusterRequest() {
	}

	public HealthClusterRequest(String... indexNames) {
		_indexNames = indexNames;
	}

	@Override
	public HealthClusterResponse accept(
		ClusterRequestExecutor clusterRequestExecutor) {

		return clusterRequestExecutor.executeClusterRequest(this);
	}

	@Override
	public String[] getIndexNames() {
		return _indexNames;
	}

	public long getTimeout() {
		return _timeout;
	}

	public ClusterHealthStatus getWaitForClusterHealthStatus() {
		return _waitForClusterHealthStatus;
	}

	public void setTimeout(long timeout) {
		_timeout = timeout;
	}

	public void setWaitForClusterHealthStatus(
		ClusterHealthStatus waitForClusterHealthStatus) {

		_waitForClusterHealthStatus = waitForClusterHealthStatus;
	}

	private String[] _indexNames;
	private long _timeout;
	private ClusterHealthStatus _waitForClusterHealthStatus;

}