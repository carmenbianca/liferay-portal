/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.background.task;

import com.liferay.portal.search.elasticsearch6.internal.ElasticsearchSearchEngineFixture;
import com.liferay.portal.search.elasticsearch6.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.elasticsearch6.internal.index.FieldMappingAssert;
import com.liferay.portal.search.elasticsearch6.internal.index.LiferayTypeMappingsConstants;
import com.liferay.portal.search.test.util.background.task.BaseReindexSingleIndexerBackgroundTaskExecutorTestCase;
import com.liferay.portal.search.test.util.search.engine.SearchEngineFixture;

/**
 * @author Adam Brandizzi
 */
public class ReindexSingleIndexerBackgroundTaskExecutorTest
	extends BaseReindexSingleIndexerBackgroundTaskExecutorTestCase {

	@Override
	protected void assertFieldType(String fieldName, String fieldType)
		throws Exception {

		ElasticsearchFixture elasticsearchFixture =
			_elasticsearchSearchEngineFixture.getElasticsearchFixture();

		FieldMappingAssert.assertType(
			fieldType, fieldName,
			LiferayTypeMappingsConstants.LIFERAY_DOCUMENT_TYPE, getIndexName(),
			elasticsearchFixture.getIndicesAdminClient());
	}

	@Override
	protected SearchEngineFixture getSearchEngineFixture() {
		_elasticsearchSearchEngineFixture =
			new ElasticsearchSearchEngineFixture(
				ReindexSingleIndexerBackgroundTaskExecutorTest.class.
					getSimpleName());

		return _elasticsearchSearchEngineFixture;
	}

	private ElasticsearchSearchEngineFixture _elasticsearchSearchEngineFixture;

}