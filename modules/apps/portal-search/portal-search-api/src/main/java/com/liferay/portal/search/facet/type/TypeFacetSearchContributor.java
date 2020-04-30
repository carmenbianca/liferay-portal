/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.facet.type;

import com.liferay.portal.search.searcher.SearchRequestBuilder;

import java.util.function.Consumer;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
public interface TypeFacetSearchContributor {

	public void contribute(
		SearchRequestBuilder searchRequestBuilder,
		Consumer<TypeFacetBuilder> typeFacetBuilderConsumer);

	@ProviderType
	public interface TypeFacetBuilder {

		public TypeFacetBuilder aggregationName(String aggregationName);

		public TypeFacetBuilder frequencyThreshold(int frequencyThreshold);

		public TypeFacetBuilder selectedEntryClassNames(
			String... selectedEntryClassNames);

	}

}