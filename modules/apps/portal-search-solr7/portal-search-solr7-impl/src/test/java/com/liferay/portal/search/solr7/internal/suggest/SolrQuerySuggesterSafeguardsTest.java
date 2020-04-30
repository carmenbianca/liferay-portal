/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.suggest;

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.search.solr7.internal.SolrQuerySuggester;
import com.liferay.portal.search.solr7.internal.connection.SolrClientManager;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author André de Oliveira
 */
public class SolrQuerySuggesterSafeguardsTest {

	@Test
	public void testErrorReturnsEmptyResults() throws Exception {
		SolrQuerySuggester solrQuerySuggester = createSolrQuerySuggester();

		String[] querySuggestions = solrQuerySuggester.suggestKeywordQueries(
			createSearchContext(), 0);

		Assert.assertEquals(
			Arrays.toString(querySuggestions), 0, querySuggestions.length);
	}

	protected SearchContext createSearchContext() {
		return new SearchContext() {
			{
				setKeywords(RandomTestUtil.randomString());
			}
		};
	}

	protected SolrQuerySuggester createSolrQuerySuggester() {
		return new SolrQuerySuggester() {
			{
				setSolrClientManager(Mockito.mock(SolrClientManager.class));
			}
		};
	}

}