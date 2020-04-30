/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.DerivativePipelineAggregationResult;
import com.liferay.portal.search.internal.aggregation.BaseAggregationResult;

/**
 * @author Michael C. Han
 */
public class DerivativePipelineAggregationResultImpl
	extends BaseAggregationResult
	implements DerivativePipelineAggregationResult {

	public DerivativePipelineAggregationResultImpl(
		String name, double normalizedValue) {

		super(name);

		_normalizedValue = normalizedValue;
	}

	@Override
	public double getNormalizedValue() {
		return _normalizedValue;
	}

	private final double _normalizedValue;

}