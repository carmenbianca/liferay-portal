/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.bucket.SignificantTermsAggregationResult;

/**
 * @author Michael C. Han
 */
public class SignificantTermsAggregationResultImpl
	extends BaseBucketAggregationResult
	implements SignificantTermsAggregationResult {

	public SignificantTermsAggregationResultImpl(
		String name, long errorDocCounts, long otherDocCounts) {

		super(name);

		_errorDocCounts = errorDocCounts;
		_otherDocCounts = otherDocCounts;
	}

	@Override
	public long getErrorDocCounts() {
		return _errorDocCounts;
	}

	@Override
	public long getOtherDocCounts() {
		return _otherDocCounts;
	}

	private final long _errorDocCounts;
	private final long _otherDocCounts;

}