/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.legacy.query;

import com.liferay.portal.kernel.search.QueryTerm;
import com.liferay.portal.kernel.search.TermQuery;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 * @author Miguel Angelo Caldas Gallindo
 */
@Component(immediate = true, service = TermQueryTranslator.class)
public class TermQueryTranslatorImpl implements TermQueryTranslator {

	@Override
	public QueryBuilder translate(TermQuery termQuery) {
		QueryTerm queryTerm = termQuery.getQueryTerm();

		TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery(
			queryTerm.getField(), queryTerm.getValue());

		if (!termQuery.isDefaultBoost()) {
			termQueryBuilder.boost(termQuery.getBoost());
		}

		return termQueryBuilder;
	}

}