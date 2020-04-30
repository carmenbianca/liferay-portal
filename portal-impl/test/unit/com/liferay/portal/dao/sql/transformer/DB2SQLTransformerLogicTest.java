/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.sql.transformer;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.db.DBType;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Manuel de la Peña
 */
public class DB2SQLTransformerLogicTest
	extends BaseSQLTransformerLogicTestCase {

	public DB2SQLTransformerLogicTest() {
		super(new TestDB(DBType.DB2, 1, 0));
	}

	@Override
	public String getDropTableIfExistsTextTransformedSQL() {
		StringBundler sb = new StringBundler(5);

		sb.append("BEGIN\n");
		sb.append("DECLARE CONTINUE HANDLER FOR SQLSTATE '42704'\n");
		sb.append("BEGIN END;\n");
		sb.append("EXECUTE IMMEDIATE 'DROP TABLE Foo';\n");
		sb.append("END");

		return sb.toString();
	}

	@Override
	@Test
	public void testReplaceBitwiseCheckWithExtraWhitespace() {
		Assert.assertEquals(
			getBitwiseCheckTransformedSQL(),
			sqlTransformer.transform(getBitwiseCheckOriginalSQL()));
	}

	@Test
	public void testReplaceLike() {
		Assert.assertEquals(
			"select foo from Foo where foo LIKE COALESCE(" +
				"CAST(? AS VARCHAR(32672)),'')",
			sqlTransformer.transform("select foo from Foo where foo LIKE ?"));
	}

	@Override
	@Test
	public void testReplaceModWithExtraWhitespace() {
		Assert.assertEquals(
			getModTransformedSQL(),
			sqlTransformer.transform(getModOriginalSQL()));
	}

	@Override
	protected String getBooleanTransformedSQL() {
		return "select * from Foo where foo = FALSE and bar = TRUE";
	}

	@Override
	protected String getCastClobTextTransformedSQL() {
		return "select CAST(foo AS VARCHAR(254)) from Foo";
	}

	@Override
	protected String getIntegerDivisionTransformedSQL() {
		return "select foo / bar from Foo";
	}

	@Override
	protected String getNullDateTransformedSQL() {
		return "select NULL from Foo";
	}

}