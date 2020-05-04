/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.search.engine.adapter.cluster;

import com.liferay.portal.search.engine.adapter.cluster.ClusterRequest;
import com.liferay.portal.search.engine.adapter.cluster.ClusterRequestExecutor;
import com.liferay.portal.search.engine.adapter.cluster.ClusterResponse;
import com.liferay.portal.search.engine.adapter.cluster.HealthClusterRequest;
import com.liferay.portal.search.engine.adapter.cluster.HealthClusterResponse;
import com.liferay.portal.search.engine.adapter.cluster.StateClusterRequest;
import com.liferay.portal.search.engine.adapter.cluster.StateClusterResponse;
import com.liferay.portal.search.engine.adapter.cluster.StatsClusterRequest;
import com.liferay.portal.search.engine.adapter.cluster.StatsClusterResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(
	immediate = true, property = "search.engine.impl=Solr",
	service = ClusterRequestExecutor.class
)
public class SolrClusterRequestExecutor implements ClusterRequestExecutor {

	@Override
	public <T extends ClusterResponse> T execute(
		ClusterRequest<T> clusterRequest) {

		return clusterRequest.accept(this);
	}

	@Override
	public HealthClusterResponse executeClusterRequest(
		HealthClusterRequest healthClusterRequest) {

		return _healthClusterRequestExecutor.execute(healthClusterRequest);
	}

	@Override
	public StateClusterResponse executeClusterRequest(
		StateClusterRequest stateClusterRequest) {

		return _stateClusterRequestExecutor.execute(stateClusterRequest);
	}

	@Override
	public StatsClusterResponse executeClusterRequest(
		StatsClusterRequest statsClusterRequest) {

		return _statsClusterRequestExecutor.execute(statsClusterRequest);
	}

	@Reference(unbind = "-")
	protected void setHealthClusterRequestExecutor(
		HealthClusterRequestExecutor healthClusterRequestExecutor) {

		_healthClusterRequestExecutor = healthClusterRequestExecutor;
	}

	@Reference(unbind = "-")
	protected void setStateClusterRequestExecutor(
		StateClusterRequestExecutor stateClusterRequestExecutor) {

		_stateClusterRequestExecutor = stateClusterRequestExecutor;
	}

	@Reference(unbind = "-")
	protected void setStatsClusterRequestExecutor(
		StatsClusterRequestExecutor statsClusterRequestExecutor) {

		_statsClusterRequestExecutor = statsClusterRequestExecutor;
	}

	private HealthClusterRequestExecutor _healthClusterRequestExecutor;
	private StateClusterRequestExecutor _stateClusterRequestExecutor;
	private StatsClusterRequestExecutor _statsClusterRequestExecutor;

}