/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_3;

import com.liferay.portal.kernel.dao.db.DBInspector;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_3.util.GroupTable;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Types;

/**
 * @author Alberto Chaparro
 */
public class UpgradeGroup extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		DBInspector dbInspector = new DBInspector(connection);

		try (ResultSet rs = databaseMetaData.getColumns(
				dbInspector.getCatalog(), dbInspector.getSchema(),
				dbInspector.normalizeName("Group_"),
				dbInspector.normalizeName("groupKey"))) {

			if (rs.next()) {
				int columnSize = rs.getInt("COLUMN_SIZE");
				int dataType = rs.getInt("DATA_TYPE");

				if ((dataType != Types.VARCHAR) || (columnSize != 150)) {
					alter(
						GroupTable.class,
						new AlterColumnType("groupKey", "VARCHAR(150) null"));
				}
			}
		}
	}

}