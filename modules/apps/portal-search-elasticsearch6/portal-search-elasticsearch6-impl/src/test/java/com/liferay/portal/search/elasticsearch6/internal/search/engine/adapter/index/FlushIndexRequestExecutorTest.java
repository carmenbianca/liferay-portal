/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.index;

import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.engine.adapter.index.FlushIndexRequest;

import org.elasticsearch.action.admin.indices.flush.FlushRequest;
import org.elasticsearch.action.admin.indices.flush.FlushRequestBuilder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class FlushIndexRequestExecutorTest {

	@Before
	public void setUp() throws Exception {
		_elasticsearchFixture = new ElasticsearchFixture(
			FlushIndexRequestExecutorTest.class.getSimpleName());

		_elasticsearchFixture.setUp();
	}

	@After
	public void tearDown() throws Exception {
		_elasticsearchFixture.tearDown();
	}

	@Test
	public void testIndexRequestTranslation() {
		FlushIndexRequest flushIndexRequest = new FlushIndexRequest(
			_INDEX_NAME);

		flushIndexRequest.setForce(true);
		flushIndexRequest.setWaitIfOngoing(true);

		FlushIndexRequestExecutorImpl flushIndexRequestExecutorImpl =
			new FlushIndexRequestExecutorImpl() {
				{
					setElasticsearchClientResolver(_elasticsearchFixture);

					setIndexRequestShardFailureTranslator(
						new IndexRequestShardFailureTranslatorImpl());
				}
			};

		FlushRequestBuilder flushRequestBuilder =
			flushIndexRequestExecutorImpl.createFlushRequestBuilder(
				flushIndexRequest);

		FlushRequest flushRequest = flushRequestBuilder.request();

		Assert.assertArrayEquals(
			new String[] {_INDEX_NAME}, flushRequest.indices());
		Assert.assertTrue(flushRequest.force());
		Assert.assertTrue(flushRequest.waitIfOngoing());
	}

	private static final String _INDEX_NAME = "test_request_index";

	private ElasticsearchFixture _elasticsearchFixture;

}