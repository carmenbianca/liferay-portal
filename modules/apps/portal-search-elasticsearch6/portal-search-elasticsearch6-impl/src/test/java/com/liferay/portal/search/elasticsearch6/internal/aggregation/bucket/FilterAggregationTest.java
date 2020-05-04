/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.aggregation.bucket;

import com.liferay.portal.search.elasticsearch6.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.test.util.aggregation.bucket.BaseFilterAggregationTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

/**
 * @author Michael C. Han
 */
public class FilterAggregationTest extends BaseFilterAggregationTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.getInstance();
	}

}