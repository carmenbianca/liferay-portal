/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.cluster;

import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchClientResolver;
import com.liferay.portal.search.engine.adapter.cluster.ClusterRequestExecutor;

/**
 * @author Dylan Rebelak
 */
public class ClusterRequestExecutorFixture {

	public ClusterRequestExecutor getClusterRequestExecutor() {
		return _clusterRequestExecutor;
	}

	public void setUp() {
		ClusterHealthStatusTranslator clusterHealthStatusTranslator =
			new ClusterHealthStatusTranslatorImpl();

		_clusterRequestExecutor = new ElasticsearchClusterRequestExecutor() {
			{
				setHealthClusterRequestExecutor(
					createHealthClusterRequestExecutor(
						clusterHealthStatusTranslator,
						_elasticsearchClientResolver));
				setStateClusterRequestExecutor(
					createStateClusterRequestExecutor(
						_elasticsearchClientResolver));
				setStatsClusterRequestExecutor(
					createStatsClusterRequestExecutor(
						clusterHealthStatusTranslator,
						_elasticsearchClientResolver));
			}
		};
	}

	protected static HealthClusterRequestExecutor
		createHealthClusterRequestExecutor(
			ClusterHealthStatusTranslator clusterHealthStatusTranslator,
			ElasticsearchClientResolver elasticsearchClientResolver) {

		return new HealthClusterRequestExecutorImpl() {
			{
				setClusterHealthStatusTranslator(clusterHealthStatusTranslator);
				setElasticsearchClientResolver(elasticsearchClientResolver);
			}
		};
	}

	protected static StateClusterRequestExecutor
		createStateClusterRequestExecutor(
			ElasticsearchClientResolver elasticsearchClientResolver) {

		return new StateClusterRequestExecutorImpl() {
			{
				setElasticsearchClientResolver(elasticsearchClientResolver);
			}
		};
	}

	protected static StatsClusterRequestExecutor
		createStatsClusterRequestExecutor(
			ClusterHealthStatusTranslator clusterHealthStatusTranslator,
			ElasticsearchClientResolver elasticsearchClientResolver) {

		return new StatsClusterRequestExecutorImpl() {
			{
				setClusterHealthStatusTranslator(clusterHealthStatusTranslator);
				setElasticsearchClientResolver(elasticsearchClientResolver);
			}
		};
	}

	protected void setElasticsearchClientResolver(
		ElasticsearchClientResolver elasticsearchClientResolver) {

		_elasticsearchClientResolver = elasticsearchClientResolver;
	}

	private ClusterRequestExecutor _clusterRequestExecutor;
	private ElasticsearchClientResolver _elasticsearchClientResolver;

}