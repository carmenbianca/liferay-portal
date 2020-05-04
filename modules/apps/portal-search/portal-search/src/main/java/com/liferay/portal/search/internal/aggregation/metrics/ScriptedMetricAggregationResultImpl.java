/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.metrics;

import com.liferay.portal.search.aggregation.metrics.ScriptedMetricAggregationResult;
import com.liferay.portal.search.internal.aggregation.BaseAggregationResult;

/**
 * @author Michael C. Han
 */
public class ScriptedMetricAggregationResultImpl
	extends BaseAggregationResult implements ScriptedMetricAggregationResult {

	public ScriptedMetricAggregationResultImpl(String name, Object value) {
		super(name);

		_value = value;
	}

	@Override
	public Object getValue() {
		return _value;
	}

	@Override
	public void setValue(Object value) {
		_value = value;
	}

	private Object _value;

}