/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.StatsBucketPipelineAggregationResult;
import com.liferay.portal.search.internal.aggregation.metrics.StatsAggregationResultImpl;

/**
 * @author Michael C. Han
 */
public class StatsBucketPipelineAggregationResultImpl
	extends StatsAggregationResultImpl
	implements StatsBucketPipelineAggregationResult {

	public StatsBucketPipelineAggregationResultImpl(
		String name, double avg, long count, double min, double max,
		double sum) {

		super(name, avg, count, min, max, sum);
	}

}