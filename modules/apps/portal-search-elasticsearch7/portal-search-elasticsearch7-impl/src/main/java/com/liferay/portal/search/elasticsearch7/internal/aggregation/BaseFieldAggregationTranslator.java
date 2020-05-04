/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.aggregation;

import com.liferay.portal.search.aggregation.AggregationTranslator;
import com.liferay.portal.search.aggregation.FieldAggregation;
import com.liferay.portal.search.aggregation.pipeline.PipelineAggregationTranslator;
import com.liferay.portal.search.elasticsearch7.internal.script.ScriptTranslator;

import org.elasticsearch.script.Script;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.PipelineAggregationBuilder;
import org.elasticsearch.search.aggregations.support.ValuesSourceAggregationBuilder;

/**
 * @author Michael C. Han
 */
public class BaseFieldAggregationTranslator {

	public <T extends ValuesSourceAggregationBuilder> T translate(
		ValuesSourceAggregationBuilderFactory<T>
			valuesSourceAggregationBuilderFactory,
		FieldAggregation baseFieldAggregation,
		AggregationTranslator<AggregationBuilder> aggregationTranslator,
		PipelineAggregationTranslator<PipelineAggregationBuilder>
			pipelineAggregationTranslator) {

		T valuesSourceAggregationBuilder =
			valuesSourceAggregationBuilderFactory.create(baseFieldAggregation);

		setField(valuesSourceAggregationBuilder, baseFieldAggregation);
		setMissing(valuesSourceAggregationBuilder, baseFieldAggregation);
		setScript(valuesSourceAggregationBuilder, baseFieldAggregation);

		_baseAggregationTranslator.translate(
			valuesSourceAggregationBuilder, baseFieldAggregation,
			aggregationTranslator, pipelineAggregationTranslator);

		return valuesSourceAggregationBuilder;
	}

	public interface ValuesSourceAggregationBuilderFactory
		<T extends ValuesSourceAggregationBuilder> {

		public T create(FieldAggregation baseFieldAggregation);

	}

	protected <T extends ValuesSourceAggregationBuilder> void setField(
		T valuesSourceAggregationBuilder,
		FieldAggregation baseFieldAggregation) {

		if (baseFieldAggregation.getField() != null) {
			valuesSourceAggregationBuilder.field(
				baseFieldAggregation.getField());
		}
	}

	protected <T extends ValuesSourceAggregationBuilder> void setMissing(
		T valuesSourceAggregationBuilder,
		FieldAggregation baseFieldAggregation) {

		if (baseFieldAggregation.getMissing() != null) {
			valuesSourceAggregationBuilder.missing(
				baseFieldAggregation.getMissing());
		}
	}

	protected <T extends ValuesSourceAggregationBuilder> void setScript(
		T valuesSourceAggregationBuilder,
		FieldAggregation baseFieldAggregation) {

		if (baseFieldAggregation.getScript() != null) {
			Script elasticsearchScript = _scriptTranslator.translate(
				baseFieldAggregation.getScript());

			valuesSourceAggregationBuilder.script(elasticsearchScript);
		}
	}

	private final BaseAggregationTranslator _baseAggregationTranslator =
		new BaseAggregationTranslator();
	private final ScriptTranslator _scriptTranslator = new ScriptTranslator();

}