/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation.metrics;

import com.liferay.portal.search.aggregation.AggregationResult;
import com.liferay.portal.search.hits.SearchHits;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface TopHitsAggregationResult extends AggregationResult {

	public SearchHits getSearchHits();

}