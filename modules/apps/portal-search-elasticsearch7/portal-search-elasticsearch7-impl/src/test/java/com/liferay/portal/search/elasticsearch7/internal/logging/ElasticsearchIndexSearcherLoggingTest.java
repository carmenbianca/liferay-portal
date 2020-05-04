/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.logging;

import com.liferay.portal.kernel.search.generic.MatchAllQuery;
import com.liferay.portal.search.elasticsearch7.internal.ElasticsearchIndexSearcher;
import com.liferay.portal.search.elasticsearch7.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.search.CountSearchRequestExecutorImpl;
import com.liferay.portal.search.elasticsearch7.internal.search.engine.adapter.search.SearchSearchRequestExecutorImpl;
import com.liferay.portal.search.test.util.indexing.BaseIndexingTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.logging.ExpectedLogTestRule;

import java.util.logging.Level;

import org.junit.Rule;
import org.junit.Test;

/**
 * @author Bryan Engler
 * @author André de Oliveira
 */
public class ElasticsearchIndexSearcherLoggingTest
	extends BaseIndexingTestCase {

	@Test
	public void testCountSearchRequestExecutorLogsViaIndexer() {
		expectedLogTestRule.configure(
			CountSearchRequestExecutorImpl.class, Level.FINE);

		expectedLogTestRule.expectMessage("The search engine processed");

		searchCount(createSearchContext(), new MatchAllQuery());
	}

	@Test
	public void testIndexerSearchCountLogs() {
		expectedLogTestRule.configure(
			ElasticsearchIndexSearcher.class, Level.INFO);

		expectedLogTestRule.expectMessage("The search engine processed");

		searchCount(createSearchContext(), new MatchAllQuery());
	}

	@Test
	public void testIndexerSearchLogs() {
		expectedLogTestRule.configure(
			ElasticsearchIndexSearcher.class, Level.INFO);

		expectedLogTestRule.expectMessage("The search engine processed");

		search(createSearchContext());
	}

	@Test
	public void testSearchSearchRequestExecutorLogsPrettyPrintedString() {
		expectedLogTestRule.configure(
			SearchSearchRequestExecutorImpl.class, Level.FINEST);

		expectedLogTestRule.expectMessage("Search query:");

		search(createSearchContext());
	}

	@Test
	public void testSearchSearchRequestExecutorLogsViaIndexer() {
		expectedLogTestRule.configure(
			SearchSearchRequestExecutorImpl.class, Level.FINE);

		expectedLogTestRule.expectMessage("The search engine processed");

		search(createSearchContext());
	}

	@Rule
	public ExpectedLogTestRule expectedLogTestRule = ExpectedLogTestRule.none();

	@Override
	protected IndexingFixture createIndexingFixture() {
		return LiferayElasticsearchIndexingFixtureFactory.getInstance();
	}

}