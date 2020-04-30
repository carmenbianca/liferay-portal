/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.filter;

import com.liferay.portal.search.filter.DateRangeFilter;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author André de Oliveira
 */
public interface DateRangeFilterTranslator {

	public QueryBuilder translate(DateRangeFilter dateRangeFilter);

}