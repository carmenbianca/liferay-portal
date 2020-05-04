/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.stats;

import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.stats.BaseStatisticsTestCase;

/**
 * @author Miguel Angelo Caldas Gallindo
 */
public class StatisticsTest extends BaseStatisticsTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() {
		return new SolrIndexingFixture();
	}

}