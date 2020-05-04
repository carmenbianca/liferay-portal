/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.search.engine.adapter.index;

import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.engine.adapter.index.PutMappingIndexRequest;

import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Dylan Rebelak
 */
public class PutMappingIndexRequestExecutorTest {

	@Before
	public void setUp() throws Exception {
		_elasticsearchFixture = new ElasticsearchFixture(
			PutMappingIndexRequestExecutorTest.class.getSimpleName());

		_elasticsearchFixture.setUp();
	}

	@After
	public void tearDown() throws Exception {
		_elasticsearchFixture.tearDown();
	}

	@Test
	public void testIndexRequestTranslation() {
		PutMappingIndexRequest putMappingIndexRequest =
			new PutMappingIndexRequest(
				new String[] {_INDEX_NAME}, _MAPPING_NAME, _FIELD_NAME);

		PutMappingIndexRequestExecutorImpl putMappingIndexRequestExecutorImpl =
			new PutMappingIndexRequestExecutorImpl() {
				{
					setElasticsearchClientResolver(_elasticsearchFixture);
				}
			};

		PutMappingRequestBuilder putMappingRequestBuilder =
			putMappingIndexRequestExecutorImpl.createPutMappingRequestBuilder(
				putMappingIndexRequest);

		PutMappingRequest putMappingRequest =
			putMappingRequestBuilder.request();

		Assert.assertArrayEquals(
			new String[] {_INDEX_NAME}, putMappingRequest.indices());
		Assert.assertEquals(_FIELD_NAME, putMappingRequest.source());
		Assert.assertEquals(_MAPPING_NAME, putMappingRequest.type());
	}

	private static final String _FIELD_NAME = "testField";

	private static final String _INDEX_NAME = "test_request_index";

	private static final String _MAPPING_NAME = "testMapping";

	private ElasticsearchFixture _elasticsearchFixture;

}