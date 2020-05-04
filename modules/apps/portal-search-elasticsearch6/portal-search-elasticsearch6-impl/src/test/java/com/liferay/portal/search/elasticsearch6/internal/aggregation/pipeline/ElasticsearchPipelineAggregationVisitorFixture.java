/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.aggregation.pipeline;

import com.liferay.portal.search.elasticsearch6.internal.query.ElasticsearchQueryTranslatorFixture;
import com.liferay.portal.search.elasticsearch6.internal.sort.ElasticsearchSortFieldTranslatorFixture;

/**
 * @author Michael C. Han
 */
public class ElasticsearchPipelineAggregationVisitorFixture {

	public ElasticsearchPipelineAggregationVisitorFixture() {
		ElasticsearchPipelineAggregationVisitor
			elasticsearchPipelineAggregationVisitor =
				new ElasticsearchPipelineAggregationVisitor();

		injectSortFieldTranslators(elasticsearchPipelineAggregationVisitor);

		_elasticsearchPipelineAggregationVisitor =
			elasticsearchPipelineAggregationVisitor;
	}

	public ElasticsearchPipelineAggregationVisitor
		getElasticsearchPipelineAggregationVisitor() {

		return _elasticsearchPipelineAggregationVisitor;
	}

	protected void injectSortFieldTranslators(
		ElasticsearchPipelineAggregationVisitor
			elasticsearchPipelineAggregationVisitor) {

		ElasticsearchQueryTranslatorFixture
			elasticsearchQueryTranslatorFixture =
				new ElasticsearchQueryTranslatorFixture();

		ElasticsearchSortFieldTranslatorFixture
			elasticsearchSortFieldTranslatorFixture =
				new ElasticsearchSortFieldTranslatorFixture(
					elasticsearchQueryTranslatorFixture.
						getElasticsearchQueryTranslator());

		elasticsearchPipelineAggregationVisitor.setSortFieldTranslator(
			elasticsearchSortFieldTranslatorFixture.
				getElasticsearchSortFieldTranslator());
	}

	private final ElasticsearchPipelineAggregationVisitor
		_elasticsearchPipelineAggregationVisitor;

}