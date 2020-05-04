/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.BucketPipelineAggregationResult;
import com.liferay.portal.search.internal.aggregation.BaseAggregationResult;

/**
 * @author Michael C. Han
 */
public class BaseBucketPipelineAggregationResult
	extends BaseAggregationResult implements BucketPipelineAggregationResult {

	public BaseBucketPipelineAggregationResult(String name, double value) {
		super(name);

		_value = value;
	}

	@Override
	public String[] getKeys() {
		return _keys;
	}

	@Override
	public double getValue() {
		return _value;
	}

	@Override
	public void setKeys(String... keys) {
		_keys = keys;
	}

	private String[] _keys;
	private final double _value;

}