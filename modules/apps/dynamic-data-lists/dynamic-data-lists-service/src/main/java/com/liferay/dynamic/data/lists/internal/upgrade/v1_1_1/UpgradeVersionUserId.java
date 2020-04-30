/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.lists.internal.upgrade.v1_1_1;

import com.liferay.dynamic.data.lists.internal.upgrade.v1_1_1.util.DDLRecordSetTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Christopher Kian
 */
public class UpgradeVersionUserId extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (hasColumnType(
				"DDLRecordSet", "versionUserId", "VARCHAR(75) null")) {

			alter(
				DDLRecordSetTable.class,
				new AlterColumnType("versionUserId", "LONG"));
		}
	}

}