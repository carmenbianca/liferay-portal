/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.AggregationVisitor;
import com.liferay.portal.search.aggregation.bucket.NestedAggregation;
import com.liferay.portal.search.internal.aggregation.BaseAggregation;

/**
 * @author Michael C. Han
 */
public class NestedAggregationImpl
	extends BaseAggregation implements NestedAggregation {

	public NestedAggregationImpl(String name, String path) {
		super(name);

		_path = path;
	}

	@Override
	public <T> T accept(AggregationVisitor<T> aggregationVisitor) {
		return aggregationVisitor.visit(this);
	}

	@Override
	public String getPath() {
		return _path;
	}

	private final String _path;

}