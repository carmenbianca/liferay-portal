/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.sort;

import com.liferay.portal.search.query.QueryTranslator;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Michael C. Han
 */
public class ElasticsearchSortFieldTranslatorFixture {

	public ElasticsearchSortFieldTranslatorFixture(
		QueryTranslator<QueryBuilder> queryTranslator) {

		_elasticsearchSortFieldTranslator =
			new ElasticsearchSortFieldTranslator() {
				{
					setQueryTranslator(queryTranslator);
				}
			};
	}

	public ElasticsearchSortFieldTranslator
		getElasticsearchSortFieldTranslator() {

		return _elasticsearchSortFieldTranslator;
	}

	private final ElasticsearchSortFieldTranslator
		_elasticsearchSortFieldTranslator;

}