/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_1_x;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.db.DBType;
import com.liferay.portal.kernel.upgrade.BaseUpgradeDBColumnSize;

/**
 * @author Preston Crary
 */
public class UpgradeDB2 extends BaseUpgradeDBColumnSize {

	public UpgradeDB2() {
		super(DBType.DB2, "varchar", 750);
	}

	@Override
	protected void upgradeColumn(String tableName, String columnName)
		throws Exception {

		runSQL(
			StringBundler.concat(
				"alter table ", tableName, " alter column ", columnName,
				" set data type varchar(4000)"));
	}

}