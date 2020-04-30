/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.MaxBucketPipelineAggregation;
import com.liferay.portal.search.aggregation.pipeline.PipelineAggregationVisitor;

/**
 * @author Michael C. Han
 */
public class MaxBucketPipelineAggregationImpl
	extends BucketMetricsPipelineAggregationImpl
	implements MaxBucketPipelineAggregation {

	public MaxBucketPipelineAggregationImpl(String name, String bucketsPath) {
		super(name, bucketsPath);
	}

	@Override
	public <T> T accept(
		PipelineAggregationVisitor<T> pipelineAggregationVisitor) {

		return pipelineAggregationVisitor.visit(this);
	}

}