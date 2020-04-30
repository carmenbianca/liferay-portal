/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.aggregation.metrics;

import com.liferay.portal.search.elasticsearch6.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.test.util.aggregation.metrics.BaseExtendedStatsAggregationTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

/**
 * @author Rafael Praxedes
 */
public class ExtendedStatsAggregationTest
	extends BaseExtendedStatsAggregationTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.getInstance();
	}

}