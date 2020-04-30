/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lock.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.lock.internal.upgrade.v1_0_0.util.LockTable;

/**
 * @author Miguel Pastor
 */
public class UpgradeLock extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			LockTable.class,
			new AlterColumnType("owner", "VARCHAR(1024) null"));
	}

}