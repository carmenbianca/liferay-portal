/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.facet;

import com.liferay.portal.kernel.search.facet.collector.FacetCollector;

import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.MultiBucketsAggregation;
import org.elasticsearch.search.aggregations.bucket.filter.InternalFilter;
import org.elasticsearch.search.aggregations.bucket.range.Range;

/**
 * @author André de Oliveira
 */
public class FacetCollectorFactory {

	public FacetCollector getFacetCollector(Aggregation aggregation) {
		if (aggregation instanceof InternalFilter) {
			InternalFilter internalFilter = (InternalFilter)aggregation;

			Aggregations aggregations = internalFilter.getAggregations();

			return getFacetCollector(aggregations.get(aggregation.getName()));
		}

		if (aggregation instanceof Range) {
			return new RangeFacetCollector((Range)aggregation);
		}

		if (aggregation instanceof MultiBucketsAggregation) {
			return new MultiBucketsAggregationFacetCollector(
				(MultiBucketsAggregation)aggregation);
		}

		return new ElasticsearchFacetFieldCollector(aggregation);
	}

}