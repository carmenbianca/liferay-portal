/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.mappings;

import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.mappings.BaseTitleFieldQueryBuilderTestCase;

import org.junit.Test;

/**
 * @author André de Oliveira
 * @author Rodrigo Paulino
 */
public class TitleFieldQueryBuilderTest
	extends BaseTitleFieldQueryBuilderTestCase {

	@Test
	public void testMultiwordPhrasePrefixesSolr() throws Exception {
		addDocument("Name Tags");
		addDocument("Names Tab");
		addDocument("Tag Names");
		addDocument("Tabs Names Tags");

		assertSearch("\"name ta*\"", 1);
		assertSearch("\"name tab*\"", 1);
		assertSearch("\"name tabs*\"", 1);
		assertSearch("\"name tag*\"", 1);
		assertSearch("\"name tags*\"", 1);
		assertSearch("\"names ta*\"", 3);
		assertSearch("\"names tab*\"", 3);
		assertSearch("\"names tabs*\"", 3);
		assertSearch("\"names tag*\"", 3);
		assertSearch("\"names tags*\"", 3);
		assertSearch("\"tab na*\"", 1);
		assertSearch("\"tab names*\"", 1);
		assertSearch("\"tabs na ta*\"", 1);
		assertSearch("\"tabs name ta*\"", 1);
		assertSearch("\"tabs name*\"", 1);
		assertSearch("\"tabs names ta*\"", 1);
		assertSearch("\"tabs names tag*\"", 1);
		assertSearch("\"tabs names tags*\"", 1);
		assertSearch("\"tabs names*\"", 1);
		assertSearch("\"tag na*\"", 1);
		assertSearch("\"tag name*\"", 1);
		assertSearch("\"tag names*\"", 1);
		assertSearch("\"tags na ta*\"", 2);
		assertSearch("\"tags names tabs*\"", 2);
		assertSearch("\"tags names*\"", 2);

		assertSearchNoHits("\"zz na*\"");
		assertSearchNoHits("\"zz name*\"");
		assertSearchNoHits("\"zz names*\"");
		assertSearchNoHits("\"zz ta*\"");
		assertSearchNoHits("\"zz tab*\"");
		assertSearchNoHits("\"zz tabs*\"");
		assertSearchNoHits("\"zz tag*\"");
		assertSearchNoHits("\"zz tags*\"");
	}

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return new SolrIndexingFixture();
	}

}