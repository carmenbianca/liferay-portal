/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.metrics;

import com.liferay.portal.search.aggregation.metrics.MaxAggregationResult;
import com.liferay.portal.search.internal.aggregation.BaseAggregationResult;

/**
 * @author Michael C. Han
 */
public class MaxAggregationResultImpl
	extends BaseAggregationResult implements MaxAggregationResult {

	public MaxAggregationResultImpl(String name, double value) {
		super(name);

		_value = value;
	}

	@Override
	public double getValue() {
		return _value;
	}

	private final double _value;

}