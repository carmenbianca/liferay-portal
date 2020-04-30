/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.query;

import com.liferay.portal.search.query.DisMaxQuery;
import com.liferay.portal.search.query.QueryVisitor;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Michael C. Han
 */
public interface DisMaxQueryTranslator {

	public QueryBuilder translate(
		DisMaxQuery disMaxQuery, QueryVisitor<QueryBuilder> queryVisitor);

}