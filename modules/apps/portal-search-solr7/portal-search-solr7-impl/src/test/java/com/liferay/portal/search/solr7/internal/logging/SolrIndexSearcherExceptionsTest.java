/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.logging;

import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.search.generic.TermQueryImpl;
import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.indexing.BaseIndexingTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

import org.apache.solr.client.solrj.impl.HttpSolrClient;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Bryan Engler
 */
public class SolrIndexSearcherExceptionsTest extends BaseIndexingTestCase {

	@Test
	public void testExceptionThrownWhenQueryMalformedSearch() {
		expectedException.expect(HttpSolrClient.RemoteSolrException.class);
		expectedException.expectMessage(
			"Invalid Number: text for field priority");

		search(createSearchContext(), getMalformedQuery());
	}

	@Test
	public void testExceptionThrownWhenQueryMalformedSearchCount() {
		expectedException.expect(HttpSolrClient.RemoteSolrException.class);
		expectedException.expectMessage(
			"Invalid Number: text for field priority");

		searchCount(createSearchContext(), getMalformedQuery());
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return new SolrIndexingFixture();
	}

	protected Query getMalformedQuery() {
		BooleanQueryImpl booleanQueryImpl = new BooleanQueryImpl();

		booleanQueryImpl.add(
			new TermQueryImpl(Field.PRIORITY, "text"), BooleanClauseOccur.MUST);

		return booleanQueryImpl;
	}

}