/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_3;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.db.DBType;
import com.liferay.portal.kernel.upgrade.BaseUpgradeDBColumnSize;

/**
 * @author Cristina González
 */
public class UpgradeSybase extends BaseUpgradeDBColumnSize {

	public UpgradeSybase() {
		super(DBType.SYBASE, "varchar", 1000);
	}

	@Override
	protected void upgradeColumn(String tableName, String columnName)
		throws Exception {

		runSQL(
			StringBundler.concat(
				"alter table ", tableName, " modify ", columnName,
				" varchar(4000)"));
	}

}