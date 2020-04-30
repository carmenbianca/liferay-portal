/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.filter;

import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.filter.BaseDateRangeFilterTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

import org.junit.Test;

/**
 * @author Eric Yan
 */
public class SolrDateRangeFilterTest extends BaseDateRangeFilterTestCase {

	@Test
	public void testMalformed() throws Exception {
		addDocument(getDate(2000, 11, 22));

		dateRangeFilterBuilder.setFrom("11212000000000");
		dateRangeFilterBuilder.setTo("11232000000000");

		assertNoHits();
	}

	@Test
	public void testMalformedMultiple() throws Exception {
		addDocument(getDate(2000, 11, 22));

		dateRangeFilterBuilder.setFrom("2000");
		dateRangeFilterBuilder.setTo("11232000000000");

		assertNoHits();
	}

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return new SolrIndexingFixture();
	}

}