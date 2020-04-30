/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.bucket;

import com.liferay.portal.search.aggregation.AggregationResult;

import java.util.Collection;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface BucketAggregationResult extends AggregationResult {

	public Bucket addBucket(String key, long docCount);

	public Bucket getBucket(String key);

	public Collection<Bucket> getBuckets();

}