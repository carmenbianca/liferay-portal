/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.cluster;

import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.engine.adapter.cluster.StatsClusterRequest;

import org.elasticsearch.action.admin.cluster.stats.ClusterStatsRequest;
import org.elasticsearch.action.admin.cluster.stats.ClusterStatsRequestBuilder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dylan Rebelak
 */
public class StatsClusterRequestExecutorTest {

	@Before
	public void setUp() throws Exception {
		_elasticsearchFixture = new ElasticsearchFixture(
			StatsClusterRequestExecutorTest.class.getSimpleName());

		_elasticsearchFixture.setUp();
	}

	@After
	public void tearDown() throws Exception {
		_elasticsearchFixture.tearDown();
	}

	@Test
	public void testClusterRequestTranslation() {
		StatsClusterRequest statsClusterRequest = new StatsClusterRequest(
			new String[] {_INDEX_NAME});

		StatsClusterRequestExecutorImpl statsClusterRequestExecutorImpl =
			new StatsClusterRequestExecutorImpl() {
				{
					setElasticsearchClientResolver(_elasticsearchFixture);
				}
			};

		ClusterStatsRequestBuilder clusterStatsRequestBuilder =
			statsClusterRequestExecutorImpl.createClusterStatsRequestBuilder(
				statsClusterRequest);

		ClusterStatsRequest clusterStatsRequest =
			clusterStatsRequestBuilder.request();

		Assert.assertNotNull(clusterStatsRequest);
	}

	private static final String _INDEX_NAME = "test_request_index";

	private ElasticsearchFixture _elasticsearchFixture;

}