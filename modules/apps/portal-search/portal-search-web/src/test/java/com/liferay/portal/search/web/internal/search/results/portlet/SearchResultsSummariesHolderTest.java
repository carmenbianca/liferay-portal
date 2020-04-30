/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.search.results.portlet;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.web.internal.result.display.context.SearchResultSummaryDisplayContext;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mockito;

/**
 * @author André de Oliveira
 */
public class SearchResultsSummariesHolderTest {

	@Test
	public void testOrder() {
		int capacity = 1000;

		List<Document> expectedDocuments = new ArrayList<>(capacity);

		SearchResultsSummariesHolder searchResultsSummariesHolder =
			new SearchResultsSummariesHolder(capacity);

		for (int i = 0; i < capacity; i++) {
			Document document = Mockito.mock(Document.class);

			expectedDocuments.add(document);

			searchResultsSummariesHolder.put(
				document, new SearchResultSummaryDisplayContext());
		}

		List<Document> actualDocuments = new ArrayList<>(
			searchResultsSummariesHolder.getDocuments());

		for (int i = 0; i < capacity; i++) {
			Assert.assertSame(expectedDocuments.get(i), actualDocuments.get(i));
		}
	}

}