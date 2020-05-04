/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.util;

import com.liferay.portal.kernel.dao.db.DBInspector;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Set;

import org.junit.Assert;

/**
 * @author Preston Crary
 */
public class DBAssertionUtil {

	public static void assertColumns(String tableName, String... columnNames)
		throws SQLException {

		for (int i = 0; i < columnNames.length; i++) {
			columnNames[i] = StringUtil.toLowerCase(columnNames[i]);
		}

		Set<String> columnNamesSet = SetUtil.fromArray(columnNames);

		try (Connection connection = DataAccess.getConnection()) {
			DBInspector dbInspector = new DBInspector(connection);

			DatabaseMetaData databaseMetaData = connection.getMetaData();

			try (ResultSet rs = databaseMetaData.getColumns(
					dbInspector.getCatalog(), dbInspector.getSchema(),
					dbInspector.normalizeName(tableName), null)) {

				while (rs.next()) {
					String columnName = StringUtil.toLowerCase(
						rs.getString("COLUMN_NAME"));

					Assert.assertTrue(
						columnName + " should not exist",
						columnNamesSet.remove(columnName));
				}
			}
		}

		Assert.assertEquals(
			columnNamesSet.toString(), 0, columnNamesSet.size());
	}

}