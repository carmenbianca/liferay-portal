/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.count;

import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.count.BaseDocumentCountTestCase;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;

/**
 * @author Wade Cao
 */
public class SolrDocumentCountTest extends BaseDocumentCountTestCase {

	@Override
	protected IndexingFixture createIndexingFixture() {
		return new SolrIndexingFixture();
	}

}