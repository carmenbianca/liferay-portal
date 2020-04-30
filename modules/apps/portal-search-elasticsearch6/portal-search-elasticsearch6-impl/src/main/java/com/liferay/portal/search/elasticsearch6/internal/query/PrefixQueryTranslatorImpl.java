/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.search.query.PrefixQuery;

import org.elasticsearch.index.query.PrefixQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = PrefixQueryTranslator.class)
public class PrefixQueryTranslatorImpl implements PrefixQueryTranslator {

	@Override
	public QueryBuilder translate(PrefixQuery prefixQuery) {
		PrefixQueryBuilder prefixQueryBuilder = QueryBuilders.prefixQuery(
			prefixQuery.getField(), prefixQuery.getPrefix());

		if (prefixQuery.getRewrite() != null) {
			prefixQueryBuilder.rewrite(prefixQuery.getRewrite());
		}

		return prefixQueryBuilder;
	}

}