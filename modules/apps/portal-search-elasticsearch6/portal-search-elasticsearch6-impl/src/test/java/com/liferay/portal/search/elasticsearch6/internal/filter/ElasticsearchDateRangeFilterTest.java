/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.filter;

import com.liferay.portal.search.elasticsearch6.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.test.util.filter.BaseDateRangeFilterTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

import org.elasticsearch.action.search.SearchPhaseExecutionException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Eric Yan
 */
public class ElasticsearchDateRangeFilterTest
	extends BaseDateRangeFilterTestCase {

	@Test
	public void testDateFormat() throws Exception {
		addDocument(getDate(2000, 11, 22));

		dateRangeFilterBuilder.setFormat("MMddyyyyHHmmss");
		dateRangeFilterBuilder.setFrom("11212000000000");
		dateRangeFilterBuilder.setTo("11232000000000");

		assertHits("20001122000000");
	}

	@Test
	public void testDateFormatWithMultiplePatterns() throws Exception {
		addDocument(getDate(2000, 11, 22));

		dateRangeFilterBuilder.setFormat("MMddyyyyHHmmss || yyyy");
		dateRangeFilterBuilder.setFrom("2000");
		dateRangeFilterBuilder.setTo("11232000000000");

		assertHits("20001122000000");
	}

	@Test
	public void testMalformed() throws Exception {
		expectedException.expect(SearchPhaseExecutionException.class);
		expectedException.expectMessage("all shards failed");

		addDocument(getDate(2000, 11, 22));

		dateRangeFilterBuilder.setFrom("11212000000000");
		dateRangeFilterBuilder.setTo("11232000000000");

		assertNoHits();
	}

	@Test
	public void testMalformedMultiple() throws Exception {
		expectedException.expect(SearchPhaseExecutionException.class);
		expectedException.expectMessage("all shards failed");

		addDocument(getDate(2000, 11, 22));

		dateRangeFilterBuilder.setFrom("2000");
		dateRangeFilterBuilder.setTo("11232000000000");

		assertNoHits();
	}

	@Test
	public void testTimeZone() throws Exception {
		addDocument(getDate(2000, 11, 22));

		dateRangeFilterBuilder.setFrom("20001122010000");
		dateRangeFilterBuilder.setTimeZoneId("Etc/GMT-2");
		dateRangeFilterBuilder.setTo("20001122030000");

		assertHits("20001122000000");
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.getInstance();
	}

}