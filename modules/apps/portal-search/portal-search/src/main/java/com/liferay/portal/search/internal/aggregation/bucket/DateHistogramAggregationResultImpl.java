/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.bucket.DateHistogramAggregationResult;

/**
 * @author Michael C. Han
 */
public class DateHistogramAggregationResultImpl
	extends BaseBucketAggregationResult
	implements DateHistogramAggregationResult {

	public DateHistogramAggregationResultImpl(String name) {
		super(name);
	}

}