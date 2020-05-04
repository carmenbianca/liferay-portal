/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.legacy.query;

import com.liferay.portal.kernel.search.TermRangeQuery;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Miguel Angelo Caldas Gallindo
 */
@Component(immediate = true, service = TermRangeQueryTranslator.class)
public class TermRangeQueryTranslatorImpl implements TermRangeQueryTranslator {

	@Override
	public QueryBuilder translate(TermRangeQuery termRangeQuery) {
		RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery(
			termRangeQuery.getField());

		rangeQueryBuilder.from(termRangeQuery.getLowerTerm());
		rangeQueryBuilder.includeLower(termRangeQuery.includesLower());
		rangeQueryBuilder.includeUpper(termRangeQuery.includesUpper());
		rangeQueryBuilder.to(termRangeQuery.getUpperTerm());

		if (!termRangeQuery.isDefaultBoost()) {
			rangeQueryBuilder.boost(termRangeQuery.getBoost());
		}

		return rangeQueryBuilder;
	}

}