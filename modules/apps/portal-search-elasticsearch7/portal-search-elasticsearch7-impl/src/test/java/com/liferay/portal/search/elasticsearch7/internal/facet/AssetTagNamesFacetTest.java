/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.facet;

import com.liferay.portal.search.elasticsearch7.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.test.util.facet.BaseAssetTagNamesFacetTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

/**
 * @author André de Oliveira
 */
public class AssetTagNamesFacetTest extends BaseAssetTagNamesFacetTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.getInstance();
	}

}