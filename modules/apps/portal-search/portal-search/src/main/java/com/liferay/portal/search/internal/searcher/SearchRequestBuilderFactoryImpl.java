/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.searcher;

import com.liferay.portal.search.internal.legacy.searcher.SearchRequestBuilderImpl;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author André de Oliveira
 */
@Component(immediate = true, service = SearchRequestBuilderFactory.class)
public class SearchRequestBuilderFactoryImpl
	implements SearchRequestBuilderFactory {

	@Override
	public SearchRequestBuilder builder() {
		return new SearchRequestBuilderImpl(this);
	}

	@Override
	public SearchRequestBuilder builder(SearchRequest searchRequest) {
		return new SearchRequestBuilderImpl(this, searchRequest);
	}

}