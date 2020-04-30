/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.facet.category;

import com.liferay.portal.search.searcher.SearchRequestBuilder;

import java.util.function.Consumer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface CategoryFacetSearchContributor {

	public void contribute(
		SearchRequestBuilder searchRequestBuilder,
		Consumer<CategoryFacetBuilder> categoryFacetBuilderConsumer);

	@ProviderType
	public interface CategoryFacetBuilder {

		public CategoryFacetBuilder aggregationName(String aggregationName);

		public CategoryFacetBuilder frequencyThreshold(int frequencyThreshold);

		public CategoryFacetBuilder maxTerms(int maxTerms);

		public CategoryFacetBuilder selectedCategoryIds(
			long... selectedCategoryIds);

	}

}