/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation;

import com.liferay.portal.search.aggregation.AggregationResult;

/**
 * @author Michael C. Han
 */
public class BaseAggregationResult implements AggregationResult {

	public BaseAggregationResult(String name) {
		_name = name;
	}

	@Override
	public String getName() {
		return _name;
	}

	private final String _name;

}