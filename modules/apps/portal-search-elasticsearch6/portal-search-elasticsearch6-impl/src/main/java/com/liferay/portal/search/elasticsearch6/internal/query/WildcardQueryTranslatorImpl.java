/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.search.query.WildcardQuery;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Miguel Angelo Caldas Gallindo
 */
@Component(service = WildcardQueryTranslator.class)
public class WildcardQueryTranslatorImpl implements WildcardQueryTranslator {

	@Override
	public QueryBuilder translate(WildcardQuery wildcardQuery) {
		WildcardQueryBuilder wildcardQueryBuilder = QueryBuilders.wildcardQuery(
			wildcardQuery.getField(), wildcardQuery.getValue());

		if (wildcardQuery.getRewrite() != null) {
			wildcardQueryBuilder.rewrite(wildcardQuery.getRewrite());
		}

		return wildcardQueryBuilder;
	}

}