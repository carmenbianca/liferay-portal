/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.internal.upgrade.v1_0_1;

import com.liferay.change.tracking.internal.upgrade.v1_0_1.util.CTCollectionTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Daniel Kocsis
 */
public class UpgradeCTCollection extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			CTCollectionTable.class,
			new AlterColumnType("description", "VARCHAR(200) null"));
	}

}