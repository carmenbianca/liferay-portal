/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.legacy.searcher;

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.legacy.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchRequestBuilder;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author André de Oliveira
 */
@Component(immediate = true, service = SearchRequestBuilderFactory.class)
public class SearchRequestBuilderFactoryImpl
	implements SearchRequestBuilderFactory {

	@Override
	public SearchRequestBuilder builder(SearchContext searchContext) {
		return new SearchRequestBuilderImpl(
			searchRequestBuilderFactory, searchContext);
	}

	@Reference
	protected com.liferay.portal.search.searcher.SearchRequestBuilderFactory
		searchRequestBuilderFactory;

}