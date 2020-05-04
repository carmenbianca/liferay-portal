/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.sort;

import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.sort.BaseDocumentSortTestCase;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Wade Cao
 */
public class SolrDocumentSortTest extends BaseDocumentSortTestCase {

	@Ignore("LPS-83586")
	@Override
	@Test
	public void testLongSort() throws Exception {
	}

	@Ignore("LPS-83586")
	@Override
	@Test
	public void testLongSortIgnoresScores() throws Exception {
	}

	@Override
	protected IndexingFixture createIndexingFixture() {
		return new SolrIndexingFixture();
	}

}