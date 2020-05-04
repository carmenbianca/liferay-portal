/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.stats;

import com.liferay.portal.search.stats.StatsRequest;
import com.liferay.portal.search.stats.StatsResponse;

import java.util.Map;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.search.aggregations.Aggregation;

/**
 * @author Michael C. Han
 */
public interface StatsTranslator {

	public void populateRequest(
		SearchRequestBuilder searchRequestBuilder, StatsRequest statsRequest);

	public StatsResponse translateResponse(
		Map<String, Aggregation> aggregationMap, StatsRequest statsRequest);

}