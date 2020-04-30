/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.bucket.HistogramAggregationResult;

/**
 * @author Michael C. Han
 */
public class HistogramAggregationResultImpl
	extends BaseBucketAggregationResult implements HistogramAggregationResult {

	public HistogramAggregationResultImpl(String name) {
		super(name);
	}

}