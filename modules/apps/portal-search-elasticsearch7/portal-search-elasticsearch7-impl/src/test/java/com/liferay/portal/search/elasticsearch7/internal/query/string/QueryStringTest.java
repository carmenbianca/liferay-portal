/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.query.string;

import com.liferay.portal.search.elasticsearch7.internal.ElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.query.string.BaseQueryStringTestCase;

/**
 * @author Wade Cao
 */
public class QueryStringTest extends BaseQueryStringTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return ElasticsearchIndexingFixtureFactory.getInstance();
	}

	@Override
	protected String getExpectedPartOfResponseString() {
		return "\"hits\":{\"total\":{\"value\":1,";
	}

}