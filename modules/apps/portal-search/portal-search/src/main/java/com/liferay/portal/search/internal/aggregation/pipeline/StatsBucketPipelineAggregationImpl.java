/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.PipelineAggregationVisitor;
import com.liferay.portal.search.aggregation.pipeline.StatsBucketPipelineAggregation;

/**
 * @author Michael C. Han
 */
public class StatsBucketPipelineAggregationImpl
	extends BucketMetricsPipelineAggregationImpl
	implements StatsBucketPipelineAggregation {

	public StatsBucketPipelineAggregationImpl(String name, String bucketsPath) {
		super(name, bucketsPath);
	}

	@Override
	public <T> T accept(
		PipelineAggregationVisitor<T> pipelineAggregationVisitor) {

		return pipelineAggregationVisitor.visit(this);
	}

}