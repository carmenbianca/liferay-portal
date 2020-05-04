/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.jdbc.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.PGConnection;
import org.postgresql.PGStatement;
import org.postgresql.largeobject.LargeObject;
import org.postgresql.largeobject.LargeObjectManager;

/**
 * @author István András Dézsi
 */
public class PostgreSQLJDBCUtil {

	public static byte[] getLargeObject(ResultSet resultSet, String name)
		throws SQLException {

		Statement statement = resultSet.getStatement();

		Connection connection = statement.getConnection();

		connection.setAutoCommit(false);

		try {
			PGConnection pgConnection = connection.unwrap(PGConnection.class);

			LargeObjectManager largeObjectManager =
				pgConnection.getLargeObjectAPI();

			long id = resultSet.getLong(name);

			LargeObject largeObject = largeObjectManager.open(
				id, LargeObjectManager.READ);

			byte[] bytes = new byte[largeObject.size()];

			largeObject.read(bytes, 0, largeObject.size());

			largeObject.close();

			return bytes;
		}
		finally {
			connection.setAutoCommit(true);
		}
	}

	public static boolean isPGStatement(Statement statement)
		throws SQLException {

		if (statement.isWrapperFor(PGStatement.class)) {
			return true;
		}

		return false;
	}

	public static void setLargeObject(
			PreparedStatement preparedStatement, int index, byte[] bytes)
		throws SQLException {

		Connection connection = preparedStatement.getConnection();

		connection.setAutoCommit(false);

		try {
			PGConnection pgConnection = connection.unwrap(PGConnection.class);

			LargeObjectManager largeObjectManager =
				pgConnection.getLargeObjectAPI();

			long id = largeObjectManager.createLO(
				LargeObjectManager.READ | LargeObjectManager.WRITE);

			LargeObject largeObject = largeObjectManager.open(
				id, LargeObjectManager.WRITE);

			largeObject.write(bytes);

			largeObject.close();

			preparedStatement.setLong(index, id);
		}
		finally {
			connection.setAutoCommit(true);
		}
	}

}