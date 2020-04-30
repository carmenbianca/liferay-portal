/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.filter;

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.FilterTranslator;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author André de Oliveira
 */
public interface FilterToQueryBuilderTranslator
	extends FilterTranslator<QueryBuilder> {

	@Override
	public QueryBuilder translate(Filter filter, SearchContext searchContext);

}