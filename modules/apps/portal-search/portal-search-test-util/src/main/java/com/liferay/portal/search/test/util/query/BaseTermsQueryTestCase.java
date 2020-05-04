/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.test.util.query;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.query.TermsQuery;
import com.liferay.portal.search.sort.Sort;
import com.liferay.portal.search.sort.SortOrder;
import com.liferay.portal.search.test.util.DocumentsAssert;
import com.liferay.portal.search.test.util.indexing.BaseIndexingTestCase;
import com.liferay.portal.search.test.util.indexing.DocumentCreationHelpers;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Michael C. Han
 */
public abstract class BaseTermsQueryTestCase extends BaseIndexingTestCase {

	@Test
	public void testTermsQuery() {
		Stream.of(
			"alpha", "bravo", "charlie", "delta"
		).forEach(
			userName -> addDocument(
				DocumentCreationHelpers.singleKeyword(
					Field.USER_NAME, userName))
		);

		TermsQuery termsQuery = queries.terms(Field.USER_NAME);

		termsQuery.addValues("bravo", "charlie");

		Sort sort = sorts.field(Field.USER_NAME, SortOrder.DESC);

		String expected = "[charlie, bravo]";

		assertSearch(
			indexingTestHelper -> {
				indexingTestHelper.defineRequest(
					searchRequestBuilder -> searchRequestBuilder.query(
						termsQuery
					).sorts(
						sort
					));

				indexingTestHelper.search();

				indexingTestHelper.verifyResponse(
					searchResponse -> {
						DocumentsAssert.assertValues(
							searchResponse.getRequestString(),
							searchResponse.getDocumentsStream(),
							Field.USER_NAME, expected);

						SearchHits searchHits = searchResponse.getSearchHits();

						Assert.assertEquals(
							"Total hits", 2, searchHits.getTotalHits());
					});
			});
	}

}