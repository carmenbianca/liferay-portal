/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.query.string;

import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.query.string.BaseQueryStringTestCase;

/**
 * @author Wade Cao
 */
public class QueryStringTest extends BaseQueryStringTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return new SolrIndexingFixture();
	}

	@Override
	protected String getExpectedPartOfResponseString() {
		return "response={numFound=1,";
	}

}