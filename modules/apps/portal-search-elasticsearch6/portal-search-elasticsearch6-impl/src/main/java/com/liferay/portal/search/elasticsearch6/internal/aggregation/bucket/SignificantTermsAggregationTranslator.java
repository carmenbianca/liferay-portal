/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.bucket.SignificantTermsAggregation;

import org.elasticsearch.search.aggregations.bucket.significant.SignificantTermsAggregationBuilder;

/**
 * @author Michael C. Han
 */
public interface SignificantTermsAggregationTranslator {

	public SignificantTermsAggregationBuilder translate(
		SignificantTermsAggregation significantTermsAggregation);

}