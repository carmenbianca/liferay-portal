/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.sql.transformer;

import com.liferay.portal.kernel.dao.db.DBType;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class SQLServerSQLTransformerLogicTest
	extends BaseSQLTransformerLogicTestCase {

	public SQLServerSQLTransformerLogicTest() {
		super(new TestSQLServerDB(1, 0));
	}

	@Override
	public String getDropTableIfExistsTextTransformedSQL() {
		return "IF OBJECT_ID('Foo', 'U') IS NOT NULL DROP TABLE Foo";
	}

	@Test
	public void testReplaceCastText() {
		Assert.assertEquals(
			"select CAST(foo AS NVARCHAR(MAX)) from Foo",
			sqlTransformer.transform(getCastTextOriginalSQL()));
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
		return "select CAST(foo AS NVARCHAR(MAX)) from Foo";
	}

	@Override
	protected String getIntegerDivisionTransformedSQL() {
		return "select foo / bar from Foo";
	}

	@Override
	protected String getModTransformedSQL() {
		return "select foo % bar from Foo";
	}

	@Override
	protected String getNullDateTransformedSQL() {
		return "select NULL from Foo";
	}

	@Override
	protected String getSubstrOriginalSQL() {
		return "select SUBSTR(foo, 1, 1) from Foo";
	}

	@Override
	protected String getSubstrTransformedSQL() {
		return "select SUBSTRING(foo, 1, 1) from Foo";
	}

	private static final class TestSQLServerDB extends TestDB {

		public TestSQLServerDB(int majorVersion, int minorVersion) {
			super(DBType.SQLSERVER, majorVersion, minorVersion);
		}

		@Override
		protected String[] getTemplate() {
			return new String[] {
				"NOOP", "1", "0", "NOOP", "NOOP", " NOOP", " NOOP", " NOOP",
				" NOOP", " NOOP", " NOOP", " NOOP", " NOOP", " NOOP", " NOOP",
				" NOOP", "NOOP"
			};
		}

	}

}