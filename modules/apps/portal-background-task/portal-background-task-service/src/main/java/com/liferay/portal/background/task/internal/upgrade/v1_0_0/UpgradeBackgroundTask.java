/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.background.task.internal.upgrade.v1_0_0;

import com.liferay.portal.background.task.internal.upgrade.v1_0_0.util.BackgroundTaskTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

/**
 * @author Cristina González
 */
public class UpgradeBackgroundTask extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		alter(
			BackgroundTaskTable.class,
			new AlterColumnType("name", "VARCHAR(255) null"),
			new AlterColumnName("taskContext", "taskContextMap TEXT null"));
	}

}