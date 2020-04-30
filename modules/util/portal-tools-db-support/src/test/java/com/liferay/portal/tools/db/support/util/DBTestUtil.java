/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.db.support.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;

/**
 * @author Andrea Di Giorgi
 */
public class DBTestUtil {

	public static void assertTableExists(
			DatabaseMetaData databaseMetaData, String name)
		throws SQLException {

		try (ResultSet resultSet = _getTables(databaseMetaData, name)) {
			Assert.assertTrue(
				"Missing table \"" + name + "\"", resultSet.next());
		}
	}

	public static void assertTableNotExists(
			DatabaseMetaData databaseMetaData, String name)
		throws SQLException {

		try (ResultSet resultSet = _getTables(databaseMetaData, name)) {
			Assert.assertFalse(
				"Unexpected table \"" + name + "\"", resultSet.next());
		}
	}

	public static void assertTableRowCount(
			Connection connection, String name, int expectedCount)
		throws SQLException {

		String sql = "select count(*) from " + name;

		try (Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql)) {

			Assert.assertTrue(resultSet.next());

			Assert.assertEquals(
				"Unexpected row count in table \"" + name + "\"", expectedCount,
				resultSet.getInt(1));
		}
	}

	private static ResultSet _getTables(
			DatabaseMetaData databaseMetaData, String name)
		throws SQLException {

		// See https://www.h2database.com/javadoc/org/h2/engine/DbSettings.html#DATABASE_TO_UPPER

		return databaseMetaData.getTables(
			null, null, name.toUpperCase(), new String[] {"TABLE"});
	}

}