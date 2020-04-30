/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.facet;

import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.facet.BaseModifiedFacetTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Bryan Engler
 */
public class ModifiedFacetTest extends BaseModifiedFacetTestCase {

	@Ignore
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
	protected IndexingFixture createIndexingFixture() {
		SolrIndexingFixture solrIndexingFixture = new SolrIndexingFixture();

		solrIndexingFixture.setFacetProcessor(
			new ModifiedFacetProcessor() {
				{
					jsonFactory = new JSONFactoryImpl();
				}
			});

		return solrIndexingFixture;
	}

}