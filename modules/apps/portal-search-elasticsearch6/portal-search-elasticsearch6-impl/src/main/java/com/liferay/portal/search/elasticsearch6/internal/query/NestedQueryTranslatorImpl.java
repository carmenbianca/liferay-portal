/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.search.query.NestedQuery;
import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.query.QueryVisitor;

import org.apache.lucene.search.join.ScoreMode;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = NestedQueryTranslator.class)
public class NestedQueryTranslatorImpl implements NestedQueryTranslator {

	@Override
	public QueryBuilder translate(
		NestedQuery nestedQuery, QueryVisitor<QueryBuilder> queryVisitor) {

		Query query = nestedQuery.getQuery();

		QueryBuilder queryBuilder = query.accept(queryVisitor);

		return QueryBuilders.nestedQuery(
			nestedQuery.getPath(), queryBuilder, ScoreMode.Total);
	}

}