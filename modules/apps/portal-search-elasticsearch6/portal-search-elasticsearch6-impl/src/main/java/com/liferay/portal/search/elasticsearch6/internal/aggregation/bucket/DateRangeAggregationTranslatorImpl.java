/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.aggregation.bucket;

import com.liferay.portal.search.aggregation.AggregationTranslator;
import com.liferay.portal.search.aggregation.bucket.DateRangeAggregation;
import com.liferay.portal.search.aggregation.pipeline.PipelineAggregationTranslator;
import com.liferay.portal.search.elasticsearch6.internal.aggregation.BaseFieldAggregationTranslator;

import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.PipelineAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.range.DateRangeAggregationBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = DateRangeAggregationTranslator.class)
public class DateRangeAggregationTranslatorImpl
	extends RangeAggregationTranslatorImpl
	implements DateRangeAggregationTranslator {

	@Override
	public DateRangeAggregationBuilder translate(
		DateRangeAggregation dateRangeAggregation,
		AggregationTranslator<AggregationBuilder> aggregationTranslator,
		PipelineAggregationTranslator<PipelineAggregationBuilder>
			pipelineAggregationTranslator) {

		DateRangeAggregationBuilder dateRangeAggregationBuilder =
			_baseFieldAggregationTranslator.translate(
				baseMetricsAggregation -> AggregationBuilders.dateRange(
					baseMetricsAggregation.getName()),
				dateRangeAggregation, aggregationTranslator,
				pipelineAggregationTranslator);

		populateRangeAggregationBuilder(
			dateRangeAggregation, dateRangeAggregationBuilder);

		return dateRangeAggregationBuilder;
	}

	private final BaseFieldAggregationTranslator
		_baseFieldAggregationTranslator = new BaseFieldAggregationTranslator();

}