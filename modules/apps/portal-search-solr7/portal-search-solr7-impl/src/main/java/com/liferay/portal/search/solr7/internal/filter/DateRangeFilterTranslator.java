/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.filter;

import com.liferay.portal.search.filter.DateRangeFilter;

import org.apache.lucene.search.Query;

/**
 * @author André de Oliveira
 */
public interface DateRangeFilterTranslator {

	public Query translate(DateRangeFilter dateRangeFilter);

}