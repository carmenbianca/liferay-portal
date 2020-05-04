/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.query;

import com.liferay.portal.search.elasticsearch7.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.query.BaseRegexQueryTestCase;

/**
 * @author Michael C. Han
 */
public class RegexQueryTest extends BaseRegexQueryTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.getInstance();
	}

}