/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.aggregation;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface HierarchicalAggregationResult extends AggregationResult {

	public void addChildrenAggregationResults(
		List<AggregationResult> aggregationResults);

	public AggregationResult getChildAggregationResult(String name);

	public Map<String, AggregationResult> getChildrenAggregationResultsMap();

}