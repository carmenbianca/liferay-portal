/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.filter.tags;

import com.liferay.portal.search.elasticsearch6.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.test.util.filter.tags.BaseAssetTagNamesQueryPreFilterContributorTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

/**
 * @author Wade Cao
 */
public class AssetTagNamesQueryPreFilterContributorTest
	extends BaseAssetTagNamesQueryPreFilterContributorTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.getInstance();
	}

}