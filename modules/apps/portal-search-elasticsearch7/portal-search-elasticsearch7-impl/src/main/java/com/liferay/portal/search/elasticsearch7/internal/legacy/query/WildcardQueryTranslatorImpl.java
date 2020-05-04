/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.legacy.query;

import com.liferay.portal.kernel.search.QueryTerm;
import com.liferay.portal.kernel.search.WildcardQuery;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Miguel Angelo Caldas Gallindo
 */
@Component(immediate = true, service = WildcardQueryTranslator.class)
public class WildcardQueryTranslatorImpl implements WildcardQueryTranslator {

	@Override
	public QueryBuilder translate(WildcardQuery wildcardQuery) {
		QueryTerm queryTerm = wildcardQuery.getQueryTerm();

		WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery(
			queryTerm.getField(), queryTerm.getValue());

		if (!wildcardQuery.isDefaultBoost()) {
			wildcardQueryBuilder.boost(wildcardQuery.getBoost());
		}

		return wildcardQueryBuilder;
	}

}