/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.facet;

import org.elasticsearch.search.aggregations.AggregationBuilder;

/**
 * @author André de Oliveira
 */
public interface FacetProcessorContext {

	public AggregationBuilder postProcessAggregationBuilder(
		AggregationBuilder aggregationBuilder);

}