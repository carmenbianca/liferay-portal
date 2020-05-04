/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.query.QueryVisitor;

import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = BooleanQueryTranslator.class)
public class BooleanQueryTranslatorImpl implements BooleanQueryTranslator {

	@Override
	public QueryBuilder translate(
		BooleanQuery booleanQuery, QueryVisitor<QueryBuilder> queryVisitor) {

		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

		processQueryClause(
			booleanQuery.getMustQueryClauses(), queryVisitor,
			boolQueryBuilder::must);

		processQueryClause(
			booleanQuery.getMustNotQueryClauses(), queryVisitor,
			boolQueryBuilder::mustNot);

		processQueryClause(
			booleanQuery.getShouldQueryClauses(), queryVisitor,
			boolQueryBuilder::should);

		processQueryClause(
			booleanQuery.getFilterQueryClauses(), queryVisitor,
			boolQueryBuilder::filter);

		if (booleanQuery.getAdjustPureNegative() != null) {
			boolQueryBuilder.adjustPureNegative(
				booleanQuery.getAdjustPureNegative());
		}

		if (booleanQuery.getMinimumShouldMatch() != null) {
			boolQueryBuilder.minimumShouldMatch(
				booleanQuery.getMinimumShouldMatch());
		}

		boolQueryBuilder.queryName(booleanQuery.getQueryName());

		return boolQueryBuilder;
	}

	protected void processQueryClause(
		List<Query> queryClauses, QueryVisitor<QueryBuilder> queryVisitor,
		QueryBuilderConsumer queryBuilderConsumer) {

		for (Query query : queryClauses) {
			QueryBuilder queryBuilder = query.accept(queryVisitor);

			queryBuilderConsumer.accept(queryBuilder);
		}
	}

	protected interface QueryBuilderConsumer {

		public void accept(QueryBuilder queryBuilder);

	}

}