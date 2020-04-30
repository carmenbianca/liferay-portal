/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.mappings;

import com.liferay.portal.search.elasticsearch7.internal.ElasticsearchIndexingFixture;
import com.liferay.portal.search.elasticsearch7.internal.connection.ElasticsearchFixture;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.mappings.BaseMaxExpansionsTestCase;

import org.junit.Ignore;

/**
 * @author Wade Cao
 */
@Ignore
public class MaxExpansionsTest extends BaseMaxExpansionsTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return new ElasticsearchIndexingFixture() {
			{
				setElasticsearchFixture(new ElasticsearchFixture(getClass()));
				setLiferayMappingsAddedToIndex(true);
			}
		};
	}

}