/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.metrics;

import com.liferay.portal.search.aggregation.metrics.CardinalityAggregationResult;
import com.liferay.portal.search.internal.aggregation.BaseAggregationResult;

/**
 * @author Michael C. Han
 */
public class CardinalityAggregationResultImpl
	extends BaseAggregationResult implements CardinalityAggregationResult {

	public CardinalityAggregationResultImpl(String name, long value) {
		super(name);

		_value = value;
	}

	@Override
	public long getValue() {
		return _value;
	}

	private final long _value;

}