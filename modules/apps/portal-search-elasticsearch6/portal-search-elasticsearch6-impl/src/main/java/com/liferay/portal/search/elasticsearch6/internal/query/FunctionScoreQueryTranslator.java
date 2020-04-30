/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.search.query.FunctionScoreQuery;
import com.liferay.portal.search.query.QueryTranslator;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Michael C. Han
 */
public interface FunctionScoreQueryTranslator {

	public QueryBuilder translate(
		FunctionScoreQuery functionScoreQuery,
		QueryTranslator<QueryBuilder> queryTranslator);

}