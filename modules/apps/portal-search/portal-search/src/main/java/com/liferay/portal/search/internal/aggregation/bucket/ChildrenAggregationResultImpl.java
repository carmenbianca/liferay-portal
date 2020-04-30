/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.bucket.ChildrenAggregationResult;

/**
 * @author Michael C. Han
 */
public class ChildrenAggregationResultImpl
	extends BaseHierarchicalAggregationResult
	implements ChildrenAggregationResult {

	public ChildrenAggregationResultImpl(String name, long docCount) {
		super(name);

		_docCount = docCount;
	}

	@Override
	public long getDocCount() {
		return _docCount;
	}

	private final long _docCount;

}