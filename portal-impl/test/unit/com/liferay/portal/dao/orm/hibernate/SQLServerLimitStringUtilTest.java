/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.orm.hibernate;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sampsa Sohlman
 */
public class SQLServerLimitStringUtilTest {

	@Test
	public void testInnerOrderBy() throws Exception {
		String sql = SQLServerLimitStringUtil.getLimitString(
			"SELECT articleId, userName FROM JournalArticle ORDER BY " +
				"modifiedDate ASC",
			10, 30);

		Assert.assertTrue(sql.indexOf("30") > 0);
		Assert.assertTrue(sql.indexOf("11") > 0);
		Assert.assertTrue(sql.indexOf("top") > 0);
	}

	@Test
	public void testNoInnerOrderBy() throws Exception {
		String sql = SQLServerLimitStringUtil.getLimitString(
			"SELECT articleId, userName FROM JournalArticle ORDER BY " +
				"userName ASC",
			10, 30);

		Assert.assertTrue(sql.indexOf("30") > 0);
		Assert.assertTrue(sql.indexOf("11") > 0);
		Assert.assertTrue(sql.indexOf("top") != 0);
	}

	@Test
	public void testUnionWithFieldsQuery() throws Exception {
		String sql = SQLServerLimitStringUtil.getLimitString(
			"( SELECT articleId, userName FROM JournalArticle ) UNION ALL ( " +
				"SELECT articleId, userName FROM JournalArticle )",
			10, 30);

		Assert.assertTrue(sql.indexOf("30") > 0);
		Assert.assertTrue(sql.indexOf("11") > 0);
		Assert.assertTrue(sql.indexOf("top") != 0);
	}

}