/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.sql.transformer;

import com.liferay.portal.dao.db.MySQLDB;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class MySQLSQLTransformerLogicTest
	extends BaseSQLTransformerLogicTestCase {

	public MySQLSQLTransformerLogicTest() {
		super(
			new MySQLDB(5, 7) {

				@Override
				public boolean isSupportsStringCaseSensitiveQuery() {
					return false;
				}

			});
	}

	@Override
	public String getDropTableIfExistsTextTransformedSQL() {
		return "DROP TABLE IF EXISTS Foo";
	}

	@Test
	public void testReplaceLower() {
		Assert.assertEquals(
			"select foo from Foo",
			sqlTransformer.transform("select lower(foo) from Foo"));
	}

	@Test
	public void testReplaceLowerMultiple() {
		Assert.assertEquals(
			"select foo, bar, baaz from Foo",
			sqlTransformer.transform(
				"select lower(foo), bar, lower(baaz) from Foo"));
	}

	@Test
	public void testReplaceLowerRecursive() {
		Assert.assertEquals(
			"select lower(foo) from Foo",
			sqlTransformer.transform("select lower(lower(foo)) from Foo"));
	}

	@Test
	public void testReplaceLowerWithoutClosing() {
		String sql = "select lower(foo from Foo";

		Assert.assertEquals(sql, sqlTransformer.transform(sql));
	}

	@Override
	@Test
	public void testReplaceModWithExtraWhitespace() {
		Assert.assertEquals(
			getModTransformedSQL(),
			sqlTransformer.transform(getModOriginalSQL()));
	}

	@Test
	public void testReplaceSupportsStringCaseSensitiveQuery() {
		String sql = "select * from foo";

		MySQLDB mySQLDB = new MySQLDB(5, 7);

		SQLTransformer sqlTransformer = SQLTransformerFactory.getSQLTransformer(
			mySQLDB);

		Assert.assertEquals(sql, sqlTransformer.transform(sql));

		sql = "select lower(foo) from Foo";

		Assert.assertEquals(sql, sqlTransformer.transform(sql));
	}

	@Override
	protected String getBitwiseCheckTransformedSQL() {
		return "select (foo & bar) from Foo";
	}

	@Override
	protected String getBooleanTransformedSQL() {
		return "select * from Foo where foo = 0 and bar = 1";
	}

	@Override
	protected String getCastClobTextTransformedSQL() {
		return "select foo from Foo";
	}

	@Override
	protected String getCastLongOriginalSQL() {
		return "select CAST_LONG(foo) from Foo";
	}

	@Override
	protected String getCastLongTransformedSQL() {
		return "select foo from Foo";
	}

	@Override
	protected String getIntegerDivisionTransformedSQL() {
		return "select foo DIV bar from Foo";
	}

	@Override
	protected String getNullDateTransformedSQL() {
		return "select NULL from Foo";
	}

}