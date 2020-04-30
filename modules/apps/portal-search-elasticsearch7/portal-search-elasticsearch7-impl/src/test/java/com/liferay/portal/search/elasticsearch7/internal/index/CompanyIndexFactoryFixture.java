/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.index;

import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.elasticsearch7.internal.connection.IndexName;
import com.liferay.portal.search.index.IndexNameBuilder;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author Adam Brandizzi
 */
public class CompanyIndexFactoryFixture {

	public CompanyIndexFactoryFixture(
		ElasticsearchFixture elasticsearchFixture, String indexName) {

		_elasticsearchFixture = elasticsearchFixture;
		_indexName = indexName;
	}

	public void createIndices() {
		CompanyIndexFactory companyIndexFactory = getCompanyIndexFactory();

		RestHighLevelClient restHighLevelClient =
			_elasticsearchFixture.getRestHighLevelClient();

		companyIndexFactory.createIndices(
			restHighLevelClient.indices(), RandomTestUtil.randomLong());
	}

	public void deleteIndices() {
		CompanyIndexFactory companyIndexFactory = getCompanyIndexFactory();

		RestHighLevelClient restHighLevelClient =
			_elasticsearchFixture.getRestHighLevelClient();

		companyIndexFactory.deleteIndices(
			restHighLevelClient.indices(), RandomTestUtil.randomLong());
	}

	public CompanyIndexFactory getCompanyIndexFactory() {
		return new CompanyIndexFactory() {
			{
				indexNameBuilder = new TestIndexNameBuilder();
				jsonFactory = new JSONFactoryImpl();
			}
		};
	}

	public String getIndexName() {
		IndexName indexName = new IndexName(_indexName);

		return indexName.getName();
	}

	protected class TestIndexNameBuilder implements IndexNameBuilder {

		@Override
		public String getIndexName(long companyId) {
			return CompanyIndexFactoryFixture.this.getIndexName();
		}

	}

	private final ElasticsearchFixture _elasticsearchFixture;
	private final String _indexName;

}