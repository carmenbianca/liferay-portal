/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.v7_0_0.util.PhoneTable;

/**
 * @author Brian Wing Shun Chan
 */
public class UpgradePhone extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(PhoneTable.class, new AlterColumnType("typeId", "LONG"));
	}

}