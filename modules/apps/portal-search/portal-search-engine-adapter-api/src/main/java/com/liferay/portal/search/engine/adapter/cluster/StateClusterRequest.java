/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.engine.adapter.cluster;

import com.liferay.portal.search.engine.adapter.ccr.CrossClusterRequest;

/**
 * @author Dylan Rebelak
 */
public class StateClusterRequest
	extends CrossClusterRequest
	implements ClusterRequest<StateClusterResponse> {

	public StateClusterRequest(String[] indexNames) {
		_indexNames = indexNames;
	}

	@Override
	public StateClusterResponse accept(
		ClusterRequestExecutor clusterRequestExecutor) {

		return clusterRequestExecutor.executeClusterRequest(this);
	}

	@Override
	public String[] getIndexNames() {
		return _indexNames;
	}

	private final String[] _indexNames;

}