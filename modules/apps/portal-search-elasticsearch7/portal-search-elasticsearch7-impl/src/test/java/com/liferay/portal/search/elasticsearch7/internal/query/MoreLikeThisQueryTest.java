/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.query;

import com.liferay.portal.search.elasticsearch7.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.query.MoreLikeThisQuery;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.query.BaseMoreLikeThisQueryTestCase;

import java.util.Collections;

import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.client.ResponseException;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Wade Cao
 */
public class MoreLikeThisQueryTest extends BaseMoreLikeThisQueryTestCase {

	@Override
	@Test
	public void testMoreLikeThisWithoutFields() throws Exception {
		addDocuments("java eclipse", "eclipse liferay", "java liferay eclipse");

		MoreLikeThisQuery moreLikeThisQuery = queries.moreLikeThis(
			Collections.emptyList(), "java");

		try {
			assertSearch(moreLikeThisQuery, Collections.emptyList());

			Assert.fail();
		}
		catch (ElasticsearchStatusException elasticsearchStatusException) {
			Throwable[] throwables =
				elasticsearchStatusException.getSuppressed();

			ResponseException responseException =
				(ResponseException)throwables[0];

			String message = responseException.getMessage();

			Assert.assertTrue(
				message,
				message.contains(
					"[more_like_this] query cannot infer the field"));
		}
	}

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.getInstance();
	}

}