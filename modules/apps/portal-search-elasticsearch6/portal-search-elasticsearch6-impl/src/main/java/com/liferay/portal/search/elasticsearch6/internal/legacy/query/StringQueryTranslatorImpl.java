/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.legacy.query;

import com.liferay.portal.kernel.search.generic.StringQuery;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = StringQueryTranslator.class)
public class StringQueryTranslatorImpl implements StringQueryTranslator {

	@Override
	public QueryBuilder translate(StringQuery stringQuery) {
		QueryStringQueryBuilder queryStringQueryBuilder =
			QueryBuilders.queryStringQuery(stringQuery.getQuery());

		if (!stringQuery.isDefaultBoost()) {
			queryStringQueryBuilder.boost(stringQuery.getBoost());
		}

		return queryStringQueryBuilder;
	}

}