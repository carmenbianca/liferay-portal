/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_0.util.ExpandoColumnTable;
import com.liferay.portal.upgrade.v7_0_0.util.ExpandoValueTable;

/**
 * @author Tibor Lipusz
 */
public class UpgradeExpando extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			ExpandoColumnTable.class,
			new AlterColumnType("defaultData", "TEXT null"));

		alter(
			ExpandoValueTable.class, new AlterColumnType("data_", "TEXT null"));
	}

}