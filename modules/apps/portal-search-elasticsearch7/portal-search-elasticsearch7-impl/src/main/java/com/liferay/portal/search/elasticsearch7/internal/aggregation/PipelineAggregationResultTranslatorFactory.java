/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.aggregation;

import com.liferay.portal.search.aggregation.pipeline.PipelineAggregationResultTranslator;

import org.elasticsearch.search.aggregations.Aggregation;

/**
 * @author André de Oliveira
 */
public interface PipelineAggregationResultTranslatorFactory {

	public PipelineAggregationResultTranslator
		createPipelineAggregationResultTranslator(Aggregation aggregation);

}