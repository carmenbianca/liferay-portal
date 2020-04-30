/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.metrics;

import com.liferay.portal.search.aggregation.metrics.TopHitsAggregationResult;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.internal.aggregation.BaseAggregationResult;

/**
 * @author Michael C. Han
 */
public class TopHitsAggregationResultImpl
	extends BaseAggregationResult implements TopHitsAggregationResult {

	public TopHitsAggregationResultImpl(String name, SearchHits searchHits) {
		super(name);

		_searchHits = searchHits;
	}

	@Override
	public SearchHits getSearchHits() {
		return _searchHits;
	}

	private final SearchHits _searchHits;

}