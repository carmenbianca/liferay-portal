/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.bucket.SamplerAggregationResult;

/**
 * @author Michael C. Han
 */
public class SamplerAggregationResultImpl
	extends BaseHierarchicalAggregationResult
	implements SamplerAggregationResult {

	public SamplerAggregationResultImpl(String name, long docCount) {
		super(name);

		_docCount = docCount;
	}

	@Override
	public long getDocCount() {
		return _docCount;
	}

	@Override
	public void setDocCount(long docCount) {
		_docCount = docCount;
	}

	private long _docCount;

}