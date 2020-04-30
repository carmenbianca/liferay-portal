/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.search.elasticsearch6.internal.LiferayElasticsearchIndexingFixtureFactory;
import com.liferay.portal.search.test.util.indexing.IndexingFixture;
import com.liferay.portal.search.test.util.query.BaseStringQueryTestCase;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author Michael C. Han
 */
public class StringQueryTest extends BaseStringQueryTestCase {

	@Test
	public void testBooleanOperatorNotDeepElasticsearch() throws Exception {
		addDocuments("alpha bravo", "alpha charlie", "charlie delta");

		assertSearch("+(NOT alpha) +charlie", Arrays.asList("charlie delta"));
	}

	@Test
	public void testPrefixOperatorMustNotWithBooleanOperatorOrElasticsearch()
		throws Exception {

		addDocuments("alpha bravo", "alpha charlie", "charlie delta");

		assertSearch(
			"(-bravo) OR (alpha)",
			Arrays.asList("alpha bravo", "alpha charlie", "charlie delta"));
		assertSearch(
			"(-bravo) OR alpha",
			Arrays.asList("alpha bravo", "alpha charlie", "charlie delta"));
	}

	@Override
	protected IndexingFixture createIndexingFixture() throws Exception {
		return LiferayElasticsearchIndexingFixtureFactory.getInstance();
	}

}