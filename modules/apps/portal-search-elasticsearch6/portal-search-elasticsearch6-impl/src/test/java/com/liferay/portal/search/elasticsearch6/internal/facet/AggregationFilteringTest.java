/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.facet;

import com.liferay.portal.search.elasticsearch6.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.internal.facet.ModifiedFacetImpl;
import com.liferay.portal.search.test.util.facet.BaseAggregationFilteringTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

import java.util.Collections;

/**
 * @author André de Oliveira
 */
public class AggregationFilteringTest extends BaseAggregationFilteringTestCase {

	protected static FacetProcessor createFacetProcessor() {
		return new CompositeFacetProcessor() {
			{
				defaultFacetProcessor = new DefaultFacetProcessor();

				setFacetProcessor(
					new ModifiedFacetProcessor(),
					Collections.singletonMap(
						"class.name", ModifiedFacetImpl.class.getName()));
			}
		};
	}

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.builder(
		).facetProcessor(
			createFacetProcessor()
		).build();
	}

}