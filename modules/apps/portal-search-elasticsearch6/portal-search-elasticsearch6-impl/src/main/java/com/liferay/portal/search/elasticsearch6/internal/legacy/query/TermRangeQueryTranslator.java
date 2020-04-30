/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.legacy.query;

import com.liferay.portal.kernel.search.TermRangeQuery;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Miguel Angelo Caldas Gallindo
 */
public interface TermRangeQueryTranslator {

	public QueryBuilder translate(TermRangeQuery termRangeQuery);

}