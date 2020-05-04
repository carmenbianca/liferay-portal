/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.test;

import com.liferay.portal.kernel.dao.db.DBInspector;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.upgrade.BaseUpgradeDBColumnSize;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Preston Crary
 */
public abstract class BaseUpgradeDBColumnSizeTestCase {

	@Before
	public void setUp() throws Exception {
		try (Connection connection = DataAccess.getConnection();
			PreparedStatement ps = connection.prepareStatement(
				getCreateTestTableSQL())) {

			ps.executeUpdate();
		}
	}

	@After
	public void tearDown() throws Exception {
		try (Connection connection = DataAccess.getConnection();
			PreparedStatement ps = connection.prepareStatement(
				"drop table TestTable")) {

			ps.executeUpdate();
		}
	}

	@Test
	public void testUpgrade() throws Exception {
		_assertSize(getInitialSize());

		UpgradeProcess upgradeProcess = getUpgradeProcess();

		upgradeProcess.upgrade();

		_assertSize(4000);
	}

	protected abstract String getCreateTestTableSQL();

	protected abstract int getInitialSize();

	protected abstract String getTypeName();

	protected abstract BaseUpgradeDBColumnSize getUpgradeProcess();

	private void _assertSize(int size) throws Exception {
		try (Connection connection = DataAccess.getConnection()) {
			DatabaseMetaData databaseMetaData = connection.getMetaData();

			DBInspector dbInspector = new DBInspector(connection);

			String catalog = dbInspector.getCatalog();
			String schema = dbInspector.getSchema();

			String tableName = dbInspector.normalizeName("TestTable");
			String columnName = dbInspector.normalizeName("testValue");

			try (ResultSet columnRS = databaseMetaData.getColumns(
					catalog, schema, tableName, columnName)) {

				Assert.assertTrue(columnRS.next());

				Assert.assertEquals(
					columnName, columnRS.getString("COLUMN_NAME"));

				Assert.assertEquals(
					dbInspector.normalizeName(getTypeName()),
					columnRS.getString("TYPE_NAME"));

				Assert.assertEquals(size, columnRS.getInt("COLUMN_SIZE"));

				Assert.assertFalse(columnRS.next());
			}
		}
	}

}