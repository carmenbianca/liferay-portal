/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.searcher;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Creates a search request builder for building a search request object that
 * can be sent to the search engine when performing a search.
 *
 * @author André de Oliveira
 */
@ProviderType
public interface SearchRequestBuilderFactory {

	/**
	 * Instantiates a new search request builder.
	 *
	 * @return the search request builder
	 */
	public SearchRequestBuilder builder();

	public SearchRequestBuilder builder(SearchRequest searchRequest);

}