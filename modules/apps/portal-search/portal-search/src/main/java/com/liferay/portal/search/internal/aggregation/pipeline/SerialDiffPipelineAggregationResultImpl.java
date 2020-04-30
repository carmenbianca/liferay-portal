/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.SerialDiffPipelineAggregationResult;
import com.liferay.portal.search.internal.aggregation.BaseAggregationResult;

/**
 * @author Michael C. Han
 */
public class SerialDiffPipelineAggregationResultImpl
	extends BaseAggregationResult
	implements SerialDiffPipelineAggregationResult {

	public SerialDiffPipelineAggregationResultImpl(String name, double value) {
		super(name);

		_value = value;
	}

	@Override
	public double getValue() {
		return _value;
	}

	private final double _value;

}