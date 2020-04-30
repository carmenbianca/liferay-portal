/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.bucket.BucketCountThresholds;

import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregator;

/**
 * @author Michael C. Han
 */
public class BucketCountThresholdsTranslator {

	public TermsAggregator.BucketCountThresholds translate(
		BucketCountThresholds bucketCountThresholds) {

		return new TermsAggregator.BucketCountThresholds(
			bucketCountThresholds.getMinDocCount(),
			bucketCountThresholds.getShardMinDocCount(),
			bucketCountThresholds.getRequiredSize(),
			bucketCountThresholds.getShardSize());
	}

}