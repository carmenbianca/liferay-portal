/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.mappings;

import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.mappings.BaseSubstringFieldQueryBuilderTestCase;

/**
 * @author André de Oliveira
 * @author Rodrigo Paulino
 */
public class SubstringFieldQueryBuilderTest
	extends BaseSubstringFieldQueryBuilderTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return new SolrIndexingFixture();
	}

}