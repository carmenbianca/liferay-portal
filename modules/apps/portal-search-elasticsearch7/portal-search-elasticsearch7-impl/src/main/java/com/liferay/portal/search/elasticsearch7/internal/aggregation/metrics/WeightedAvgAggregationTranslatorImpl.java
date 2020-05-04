/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.aggregation.metrics;

import com.liferay.portal.search.aggregation.AggregationTranslator;
import com.liferay.portal.search.aggregation.metrics.WeightedAvgAggregation;
import com.liferay.portal.search.aggregation.pipeline.PipelineAggregationTranslator;
import com.liferay.portal.search.elasticsearch7.internal.aggregation.BaseAggregationTranslator;
import com.liferay.portal.search.elasticsearch7.internal.aggregation.ValueTypeTranslator;
import com.liferay.portal.search.elasticsearch7.internal.script.ScriptTranslator;
import com.liferay.portal.search.script.Script;

import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.PipelineAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;
import org.elasticsearch.search.aggregations.support.MultiValuesSourceFieldConfig;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = WeightedAvgAggregationTranslator.class)
public class WeightedAvgAggregationTranslatorImpl
	implements WeightedAvgAggregationTranslator {

	@Override
	public WeightedAvgAggregationBuilder translate(
		WeightedAvgAggregation weightedAvgAggregation,
		AggregationTranslator<AggregationBuilder> aggregationTranslator,
		PipelineAggregationTranslator<PipelineAggregationBuilder>
			pipelineAggregationTranslator) {

		WeightedAvgAggregationBuilder weightedAvgAggregationBuilder =
			AggregationBuilders.weightedAvg(weightedAvgAggregation.getName());

		MultiValuesSourceFieldConfig valueMultiValuesSourceFieldConfig =
			getMultiValuesSourceFieldConfig(
				weightedAvgAggregation.getValueField(),
				weightedAvgAggregation.getValueMissing(),
				weightedAvgAggregation.getValueScript());

		weightedAvgAggregationBuilder.value(valueMultiValuesSourceFieldConfig);

		MultiValuesSourceFieldConfig weightMultiValuesSourceFieldConfig =
			getMultiValuesSourceFieldConfig(
				weightedAvgAggregation.getWeightField(),
				weightedAvgAggregation.getWeightMissing(),
				weightedAvgAggregation.getWeightScript());

		weightedAvgAggregationBuilder.weight(
			weightMultiValuesSourceFieldConfig);

		if (weightedAvgAggregation.getFormat() != null) {
			weightedAvgAggregationBuilder.format(
				weightedAvgAggregation.getFormat());
		}

		if (weightedAvgAggregation.getValueType() != null) {
			weightedAvgAggregationBuilder.valueType(
				_valueTypeTranslator.translate(
					weightedAvgAggregation.getValueType()));
		}

		_baseAggregationTranslator.translate(
			weightedAvgAggregationBuilder, weightedAvgAggregation,
			aggregationTranslator, pipelineAggregationTranslator);

		return weightedAvgAggregationBuilder;
	}

	protected MultiValuesSourceFieldConfig getMultiValuesSourceFieldConfig(
		String field, Object missing, Script script) {

		MultiValuesSourceFieldConfig.Builder
			multiValuesSourceFieldConfigBuilder =
				new MultiValuesSourceFieldConfig.Builder();

		multiValuesSourceFieldConfigBuilder.setFieldName(field);

		if (missing != null) {
			multiValuesSourceFieldConfigBuilder.setMissing(missing);
		}

		if (script != null) {
			multiValuesSourceFieldConfigBuilder.setScript(
				_scriptTranslator.translate(script));
		}

		return multiValuesSourceFieldConfigBuilder.build();
	}

	private final BaseAggregationTranslator _baseAggregationTranslator =
		new BaseAggregationTranslator();
	private final ScriptTranslator _scriptTranslator = new ScriptTranslator();
	private final ValueTypeTranslator _valueTypeTranslator =
		new ValueTypeTranslator();

}