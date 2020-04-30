/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.upgrade.v3_5_0;

import com.liferay.dynamic.data.mapping.internal.upgrade.v3_5_0.util.DDMFormInstanceReportTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Marcos Martins
 */
public class UpgradeDDMFormInstanceReport extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasTable(DDMFormInstanceReportTable.TABLE_NAME)) {
			runSQL(DDMFormInstanceReportTable.TABLE_SQL_CREATE);
		}
	}

}