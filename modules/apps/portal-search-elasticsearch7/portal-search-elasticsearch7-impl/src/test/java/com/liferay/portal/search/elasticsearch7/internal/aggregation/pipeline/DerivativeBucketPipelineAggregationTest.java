/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.aggregation.pipeline;

import com.liferay.portal.search.elasticsearch7.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.test.util.aggregation.pipeline.BaseDerivativePipelineAggregationTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

/**
 * @author Michael C. Han
 */
public class DerivativeBucketPipelineAggregationTest
	extends BaseDerivativePipelineAggregationTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.getInstance();
	}

}