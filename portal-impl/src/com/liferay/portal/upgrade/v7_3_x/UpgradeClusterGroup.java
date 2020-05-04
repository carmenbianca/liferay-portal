/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_3_x;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Tina Tian
 */
public class UpgradeClusterGroup extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		runSQL("DROP_TABLE_IF_EXISTS(ClusterGroup)");
	}

}