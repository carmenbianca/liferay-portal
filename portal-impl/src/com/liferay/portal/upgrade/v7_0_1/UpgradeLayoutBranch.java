/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_1.util.LayoutBranchTable;

/**
 * @author Miguel Pastor
 */
public class UpgradeLayoutBranch extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			LayoutBranchTable.class,
			new AlterColumnName("LayoutBranchId", "layoutBranchId LONG"));
	}

}