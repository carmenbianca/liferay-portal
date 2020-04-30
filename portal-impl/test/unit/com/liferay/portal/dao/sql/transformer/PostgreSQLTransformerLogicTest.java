/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.sql.transformer;

import com.liferay.portal.dao.db.PostgreSQLDB;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class PostgreSQLTransformerLogicTest
	extends BaseSQLTransformerLogicTestCase {

	public PostgreSQLTransformerLogicTest() {
		super(new PostgreSQLDB(1, 0));
	}

	@Override
	public String getDropTableIfExistsTextTransformedSQL() {
		return "DROP TABLE IF EXISTS Foo";
	}

	@Override
	@Test
	public void testReplaceModWithExtraWhitespace() {
		Assert.assertEquals(
			getModTransformedSQL(),
			sqlTransformer.transform(getModOriginalSQL()));
	}

	@Test
	public void testReplaceNegativeComparison() {
		Assert.assertEquals(
			"select * from Foo where foo != (-1)",
			sqlTransformer.transform("select * from Foo where foo != -1"));
		Assert.assertEquals(
			"select * from Foo where foo != (-1) and bar != (-1)",
			sqlTransformer.transform(
				"select * from Foo where foo != -1 and bar != -1"));
	}

	@Override
	protected String getBitwiseCheckTransformedSQL() {
		return "select (foo & bar) from Foo";
	}

	@Override
	protected String getCastClobTextTransformedSQL() {
		return "select CAST(foo AS TEXT) from Foo";
	}

	@Override
	protected String getCastLongOriginalSQL() {
		return "select CAST_LONG(foo) from Foo";
	}

	@Override
	protected String getCastLongTransformedSQL() {
		return "select CAST(foo AS BIGINT) from Foo";
	}

	@Override
	protected String getIntegerDivisionTransformedSQL() {
		return "select foo / bar from Foo";
	}

	@Override
	protected String getNullDateTransformedSQL() {
		return "select CAST(NULL AS TIMESTAMP) from Foo";
	}

}