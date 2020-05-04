/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.filter;

import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.FilterVisitor;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Michael C. Han
 */
public interface BooleanFilterTranslator {

	public QueryBuilder translate(
		BooleanFilter booleanFilter, FilterVisitor<QueryBuilder> filterVisitor);

}