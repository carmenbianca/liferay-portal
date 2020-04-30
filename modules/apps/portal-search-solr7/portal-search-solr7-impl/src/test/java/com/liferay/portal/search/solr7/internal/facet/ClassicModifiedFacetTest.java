/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.facet;

import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.facet.BaseClassicModifiedFacetTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

/**
 * @author André de Oliveira
 */
public class ClassicModifiedFacetTest extends BaseClassicModifiedFacetTestCase {

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