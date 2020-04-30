/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.CumulativeSumPipelineAggregationResult;
import com.liferay.portal.search.internal.aggregation.BaseAggregationResult;

/**
 * @author Michael C. Han
 */
public class CumulativeSumPipelineAggregationResultImpl
	extends BaseAggregationResult
	implements CumulativeSumPipelineAggregationResult {

	public CumulativeSumPipelineAggregationResultImpl(
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