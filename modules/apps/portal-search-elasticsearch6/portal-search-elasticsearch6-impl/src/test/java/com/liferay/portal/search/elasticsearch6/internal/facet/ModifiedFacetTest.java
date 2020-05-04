/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.facet;

import com.liferay.portal.search.elasticsearch6.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.test.util.facet.BaseModifiedFacetTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

import org.junit.Test;

/**
 * @author Bryan Engler
 */
public class ModifiedFacetTest extends BaseModifiedFacetTestCase {

	@Test
	public void testSearchEngineDateMath() throws Exception {
		addDocument("17760704000000");
		addDocument("27760704000000");

		String dateMathExpressionWithAlphabeticalOrderSwitched =
			"[now-500y TO now]";

		doTestSearchEngineDateMath(
			dateMathExpressionWithAlphabeticalOrderSwitched, 1);
	}

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.builder(
		).facetProcessor(
			new ModifiedFacetProcessor()
		).build();
	}

}