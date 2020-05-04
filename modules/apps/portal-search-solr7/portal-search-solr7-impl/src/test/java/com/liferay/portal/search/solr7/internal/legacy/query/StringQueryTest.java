/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.legacy.query;

import com.liferay.portal.search.solr7.internal.SolrIndexingFixture;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.legacy.query.BaseStringQueryTestCase;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

/**
 * @author André de Oliveira
 */
public class StringQueryTest extends BaseStringQueryTestCase {

	@Test
	public void testBooleanOperatorNotDeepSolr() throws Exception {
		addDocuments("alpha bravo", "alpha charlie", "charlie delta");

		assertSearch("+(NOT alpha) +charlie", Collections.emptyList());
	}

	@Test
	public void testPrefixOperatorMustNotWithBooleanOperatorOrSolr()
		throws Exception {

		addDocuments("alpha bravo", "alpha charlie", "charlie delta");

		assertSearch(
			"(-bravo) OR (alpha)",
			Arrays.asList("alpha bravo", "alpha charlie"));
		assertSearch(
			"(-bravo) OR alpha", Arrays.asList("alpha bravo", "alpha charlie"));
	}

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return new SolrIndexingFixture();
	}

}