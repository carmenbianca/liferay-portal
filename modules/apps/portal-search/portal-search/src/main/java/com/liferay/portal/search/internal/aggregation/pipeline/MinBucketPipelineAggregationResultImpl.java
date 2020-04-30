/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.MinBucketPipelineAggregationResult;

/**
 * @author Michael C. Han
 */
public class MinBucketPipelineAggregationResultImpl
	extends BaseBucketPipelineAggregationResult
	implements MinBucketPipelineAggregationResult {

	public MinBucketPipelineAggregationResultImpl(String name, double value) {
		super(name, value);
	}

}