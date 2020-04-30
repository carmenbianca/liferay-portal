/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.bucket.DateHistogramAggregation;

import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;

/**
 * @author Michael C. Han
 */
public interface DateHistogramAggregationTranslator {

	public DateHistogramAggregationBuilder translate(
		DateHistogramAggregation histogramAggregation);

}