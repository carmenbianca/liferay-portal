/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.filter;

import com.liferay.portal.kernel.search.filter.QueryFilter;
import com.liferay.portal.kernel.search.query.QueryTranslator;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Michael C. Han
 */
public class QueryFilterTranslatorImpl implements QueryFilterTranslator {

	public QueryFilterTranslatorImpl(
		QueryTranslator<QueryBuilder> queryTranslator) {

		_queryTranslator = queryTranslator;
	}

	@Override
	public QueryBuilder translate(QueryFilter queryFilter) {
		return _queryTranslator.translate(queryFilter.getQuery(), null);
	}

	private final QueryTranslator<QueryBuilder> _queryTranslator;

}