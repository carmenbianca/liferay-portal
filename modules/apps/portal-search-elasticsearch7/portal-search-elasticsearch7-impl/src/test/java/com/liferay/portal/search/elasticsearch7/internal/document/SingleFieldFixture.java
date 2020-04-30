/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.document;

import com.liferay.portal.search.elasticsearch7.internal.connection.IndexName;
import com.liferay.portal.search.elasticsearch7.internal.query.QueryBuilderFactory;
import com.liferay.portal.search.elasticsearch7.internal.query.SearchAssert;

import java.io.IOException;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author André de Oliveira
 */
public class SingleFieldFixture {

	public SingleFieldFixture(
		RestHighLevelClient restHighLevelClient, IndexName indexName,
		String type) {

		_restHighLevelClient = restHighLevelClient;
		_type = type;

		_index = indexName.getName();
	}

	public void assertNoHits(String text) throws Exception {
		SearchAssert.assertNoHits(
			_restHighLevelClient, _field, _createQueryBuilder(text));
	}

	public void assertSearch(String text, String... expected) throws Exception {
		SearchAssert.assertSearch(
			_restHighLevelClient, _field, _createQueryBuilder(text), expected);
	}

	public void indexDocument(String value) {
		IndexRequest indexRequest = new IndexRequest(_index, _type);

		indexRequest.source(_field, value);

		try {
			_restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
		}
		catch (IOException ioException) {
			throw new RuntimeException(ioException);
		}
	}

	public void setField(String field) {
		_field = field;
	}

	public void setQueryBuilderFactory(
		QueryBuilderFactory queryBuilderFactory) {

		_queryBuilderFactory = queryBuilderFactory;
	}

	private QueryBuilder _createQueryBuilder(String text) {
		return _queryBuilderFactory.create(_field, text);
	}

	private String _field;
	private final String _index;
	private QueryBuilderFactory _queryBuilderFactory;
	private final RestHighLevelClient _restHighLevelClient;
	private final String _type;

}