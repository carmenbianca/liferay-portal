/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.MovingFunctionPipelineAggregationResult;
import com.liferay.portal.search.internal.aggregation.BaseAggregationResult;

/**
 * @author Michael C. Han
 */
public class MovingFunctionPipelineAggregationResultImpl
	extends BaseAggregationResult
	implements MovingFunctionPipelineAggregationResult {

	public MovingFunctionPipelineAggregationResultImpl(
		String name, double value) {

		super(name);

		_value = value;
	}

	@Override
	public double getValue() {
		return _value;
	}

	private final double _value;

}