/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.util.ParallelUpgradeSchemaUtil;

/**
 * @author Julio Camarero
 */
public class UpgradeSchema extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		ParallelUpgradeSchemaUtil.execute(
			this, "update-6.2.0-7.0.0.sql", "update-6.2.0-7.0.0-asset.sql",
			"update-6.2.0-7.0.0-group.sql", "update-6.2.0-7.0.0-layoutset.sql",
			"update-6.2.0-7.0.0-layoutsetbranch.sql");

		upgrade(new UpgradeMVCCVersion());
	}

}