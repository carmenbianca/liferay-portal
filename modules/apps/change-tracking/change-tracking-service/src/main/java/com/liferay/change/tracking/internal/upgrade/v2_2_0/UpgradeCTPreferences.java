/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal.upgrade.v2_2_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Samuel Trong Tran
 */
public class UpgradeCTPreferences extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL("alter table CTPreferences add previousCtCollectionId LONG");
	}

}