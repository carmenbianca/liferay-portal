/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.dao.db;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Mariano Álvaro Sáiz
 */
public class DBTypeSQLMapTest {

	@Test
	public void testGetReturnsActual() {
		DBTypeToSQLMap dbTypeToSQLMap = new DBTypeToSQLMap(_SQL_DEFAULT);

		dbTypeToSQLMap.add(DBType.MYSQL, _SQL_MYSQL);

		String sql = dbTypeToSQLMap.get(DBType.MYSQL);

		Assert.assertEquals(_SQL_MYSQL, sql);
	}

	@Test
	public void testGetReturnsDefault() {
		DBTypeToSQLMap dbTypeToSQLMap = new DBTypeToSQLMap(_SQL_DEFAULT);

		dbTypeToSQLMap.add(DBType.MYSQL, _SQL_MYSQL);

		String sql = dbTypeToSQLMap.get(DBType.ORACLE);

		Assert.assertEquals(_SQL_DEFAULT, sql);
	}

	private static final String _SQL_DEFAULT = "select * from table";

	private static final String _SQL_MYSQL = "select * from myTable";

}