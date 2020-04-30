/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.test.util.aggregation;

import com.liferay.portal.search.aggregation.bucket.Bucket;
import com.liferay.portal.search.aggregation.bucket.BucketAggregationResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

/**
 * @author André de Oliveira
 */
public class AggregationAssert {

	public static void assertBuckets(
		String expected, BucketAggregationResult bucketAggregationResult) {

		Assert.assertEquals(
			expected,
			String.valueOf(
				new ArrayList<>(bucketAggregationResult.getBuckets())));
	}

	public static void assertBucketValues(
		String expected, Function<Bucket, Double> function,
		BucketAggregationResult bucketAggregationResult) {

		Collection<Bucket> buckets = bucketAggregationResult.getBuckets();

		Stream<Bucket> stream = buckets.stream();

		Assert.assertEquals(
			expected,
			stream.map(
				function
			).map(
				String::valueOf
			).collect(
				Collectors.joining(", ")
			));
	}

}