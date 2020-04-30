/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.MaxBucketPipelineAggregationResult;

/**
 * @author Michael C. Han
 */
public class MaxBucketPipelineAggregationResultImpl
	extends BaseBucketPipelineAggregationResult
	implements MaxBucketPipelineAggregationResult {

	public MaxBucketPipelineAggregationResultImpl(String name, double value) {
		super(name, value);
	}

}