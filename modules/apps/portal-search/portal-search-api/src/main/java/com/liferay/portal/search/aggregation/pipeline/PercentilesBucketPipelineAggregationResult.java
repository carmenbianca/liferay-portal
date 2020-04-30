/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.pipeline;

import com.liferay.portal.search.aggregation.metrics.PercentilesAggregationResult;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface PercentilesBucketPipelineAggregationResult
	extends PercentilesAggregationResult {
}