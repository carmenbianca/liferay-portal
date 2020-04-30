/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.cluster;

import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.engine.adapter.cluster.StatsClusterRequest;
import com.liferay.portal.search.engine.adapter.cluster.StatsClusterResponse;

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
		setUpJSONFactoryUtil();

		_elasticsearchFixture = new ElasticsearchFixture(
			StatsClusterRequestExecutorTest.class.getSimpleName());

		_elasticsearchFixture.setUp();
	}

	@After
	public void tearDown() throws Exception {
		_elasticsearchFixture.tearDown();
	}

	@Test
	public void testClusterRequestExecution() {
		StatsClusterRequest statsClusterRequest = new StatsClusterRequest(
			new String[] {_NODE_ID});

		StatsClusterRequestExecutorImpl statsClusterRequestExecutorImpl =
			new StatsClusterRequestExecutorImpl() {
				{
					setElasticsearchClientResolver(_elasticsearchFixture);
					setClusterHealthStatusTranslator(
						new ClusterHealthStatusTranslatorImpl());
				}
			};

		StatsClusterResponse statsClusterResponse =
			statsClusterRequestExecutorImpl.execute(statsClusterRequest);

		Assert.assertNotNull(statsClusterResponse);

		Assert.assertNotNull(statsClusterResponse.getClusterHealthStatus());
	}

	protected void setUpJSONFactoryUtil() {
		JSONFactoryUtil jsonFactoryUtil = new JSONFactoryUtil();

		jsonFactoryUtil.setJSONFactory(_jsonFactory);
	}

	private static final String _NODE_ID = "liferay";

	private ElasticsearchFixture _elasticsearchFixture;
	private final JSONFactory _jsonFactory = new JSONFactoryImpl();

}