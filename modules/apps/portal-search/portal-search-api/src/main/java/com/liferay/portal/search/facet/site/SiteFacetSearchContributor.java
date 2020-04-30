/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.facet.site;

import com.liferay.portal.search.searcher.SearchRequestBuilder;

import java.util.function.Consumer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface SiteFacetSearchContributor {

	public void contribute(
		SearchRequestBuilder searchRequestBuilder,
		Consumer<SiteFacetBuilder> siteFacetBuilderConsumer);

	@ProviderType
	public interface SiteFacetBuilder {

		public SiteFacetBuilder aggregationName(String aggregationName);

		public SiteFacetBuilder frequencyThreshold(int frequencyThreshold);

		public SiteFacetBuilder maxTerms(int maxTerms);

		public SiteFacetBuilder selectedGroupIds(String... selectedGroupIds);

	}

}