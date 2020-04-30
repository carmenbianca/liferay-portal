/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lock.internal.upgrade.v2_0_1;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.lock.internal.upgrade.v2_0_1.util.LockTable;

/**
 * @author Rafael Praxedes
 */
public class UpgradeLock extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			LockTable.class, new AlterColumnType("key_", "VARCHAR(255) null"));
	}

}