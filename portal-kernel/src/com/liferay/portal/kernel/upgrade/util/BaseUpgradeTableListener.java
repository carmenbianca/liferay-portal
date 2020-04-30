/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade.util;

import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.model.ServiceComponent;

import java.io.IOException;

import java.sql.SQLException;

/**
 * @author Brian Wing Shun Chan
 */
public abstract class BaseUpgradeTableListener implements UpgradeTableListener {

	@Override
	public void onAfterUpdateTable(
			ServiceComponent previousServiceComponent,
			UpgradeTable upgradeTable)
		throws Exception {
	}

	@Override
	public void onBeforeUpdateTable(
			ServiceComponent previousServiceComponent,
			UpgradeTable upgradeTable)
		throws Exception {
	}

	protected void runSQL(String template) throws IOException, SQLException {
		DB db = DBManagerUtil.getDB();

		db.runSQL(template);
	}

}