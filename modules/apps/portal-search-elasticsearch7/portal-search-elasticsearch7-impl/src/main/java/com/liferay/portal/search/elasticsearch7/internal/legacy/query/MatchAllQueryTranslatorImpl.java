/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.legacy.query;

import com.liferay.portal.kernel.search.generic.MatchAllQuery;

import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = MatchAllQueryTranslator.class)
public class MatchAllQueryTranslatorImpl implements MatchAllQueryTranslator {

	@Override
	public QueryBuilder translate(MatchAllQuery matchAllQuery) {
		MatchAllQueryBuilder matchAllQueryBuilder =
			QueryBuilders.matchAllQuery();

		if (!matchAllQuery.isDefaultBoost()) {
			matchAllQueryBuilder.boost(matchAllQuery.getBoost());
		}

		return matchAllQueryBuilder;
	}

}