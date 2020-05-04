/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.admin.web.internal.upgrade.v_1_0_3;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.db.DBType;
import com.liferay.portal.kernel.dao.db.DBTypeToSQLMap;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Sam Ziemer
 */
public class UpgradeLayoutTemplateId extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		updateLayoutTemplateId();
	}

	protected void updateLayoutTemplateId() throws Exception {
		DBTypeToSQLMap dbTypeToSQLMap = new DBTypeToSQLMap(
			StringBundler.concat(
				"update Layout set typeSettings = REPLACE(typeSettings, ",
				"'layout-template-id=1_2_1_columns\n', ",
				"'layout-template-id=1_2_1_columns_i\n')"));

		dbTypeToSQLMap.add(
			DBType.SYBASE,
			StringBundler.concat(
				"update Layout set typeSettings = ",
				"REPLACE(CAST_TEXT(typeSettings), ",
				"'layout-template-id=1_2_1_columns\n', ",
				"'layout-template-id=1_2_1_columns_i\n')"));

		runSQL(dbTypeToSQLMap);
	}

}