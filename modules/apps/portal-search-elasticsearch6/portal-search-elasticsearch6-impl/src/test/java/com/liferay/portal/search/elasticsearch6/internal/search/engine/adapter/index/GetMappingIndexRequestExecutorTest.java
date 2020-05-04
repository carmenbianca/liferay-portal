/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.index;

import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.engine.adapter.index.GetMappingIndexRequest;

import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequest;
import org.elasticsearch.action.admin.indices.mapping.get.GetMappingsRequestBuilder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dylan Rebelak
 */
public class GetMappingIndexRequestExecutorTest {

	@Before
	public void setUp() throws Exception {
		_elasticsearchFixture = new ElasticsearchFixture(
			GetMappingIndexRequestExecutorTest.class.getSimpleName());

		_elasticsearchFixture.setUp();
	}

	@After
	public void tearDown() throws Exception {
		_elasticsearchFixture.tearDown();
	}

	@Test
	public void testIndexRequestTranslation() {
		GetMappingIndexRequest getMappingIndexRequest =
			new GetMappingIndexRequest(
				new String[] {_INDEX_NAME}, _MAPPING_NAME);

		GetMappingIndexRequestExecutorImpl getMappingIndexRequestExecutorImpl =
			new GetMappingIndexRequestExecutorImpl() {
				{
					setElasticsearchClientResolver(_elasticsearchFixture);
				}
			};

		GetMappingsRequestBuilder getMappingsRequestBuilder =
			getMappingIndexRequestExecutorImpl.createGetMappingsRequestBuilder(
				getMappingIndexRequest);

		GetMappingsRequest getMappingsRequest =
			getMappingsRequestBuilder.request();

		Assert.assertArrayEquals(
			new String[] {_INDEX_NAME}, getMappingsRequest.indices());
		Assert.assertArrayEquals(
			new String[] {_MAPPING_NAME}, getMappingsRequest.types());
	}

	private static final String _INDEX_NAME = "test_request_index";

	private static final String _MAPPING_NAME = "testMapping";

	private ElasticsearchFixture _elasticsearchFixture;

}