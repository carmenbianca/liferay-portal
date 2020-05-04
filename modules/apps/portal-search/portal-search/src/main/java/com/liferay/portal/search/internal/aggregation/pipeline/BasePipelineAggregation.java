/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.pipeline;

import com.liferay.portal.search.aggregation.pipeline.PipelineAggregation;

/**
 * @author Michael C. Han
 */
public abstract class BasePipelineAggregation implements PipelineAggregation {

	public BasePipelineAggregation(String name) {
		_name = name;
	}

	@Override
	public String getName() {
		return _name;
	}

	private final String _name;

}