/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal;

/**
 * @author André de Oliveira
 */
public class LiferayElasticsearchIndexingFixtureFactory {

	public static ElasticsearchIndexingFixtureBuilder builder() {
		return ElasticsearchIndexingFixtureFactory.builder(
		).liferayMappingsAddedToIndex(
			true
		);
	}

	public static ElasticsearchIndexingFixture getInstance() {
		return _elasticsearchIndexingFixture;
	}

	private static ElasticsearchIndexingFixture _buildInstance() {
		ElasticsearchIndexingFixtureBuilder
			elasticsearchIndexingFixtureBuilder = builder();

		return elasticsearchIndexingFixtureBuilder.build();
	}

	private static final ElasticsearchIndexingFixture
		_elasticsearchIndexingFixture = _buildInstance();

}