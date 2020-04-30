/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.query;

import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.query.QueryTranslator;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author André de Oliveira
 */
public interface QueryToQueryBuilderTranslator
	extends QueryTranslator<QueryBuilder> {

	@Override
	public QueryBuilder translate(Query query);

}