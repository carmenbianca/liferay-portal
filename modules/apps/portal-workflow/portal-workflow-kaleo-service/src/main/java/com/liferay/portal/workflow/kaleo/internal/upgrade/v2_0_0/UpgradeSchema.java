/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.kaleo.internal.upgrade.v2_0_0;

import com.liferay.portal.kernel.upgrade.UpgradeMVCCVersion;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LoggingTimer;
import com.liferay.portal.workflow.kaleo.internal.upgrade.v2_0_0.util.KaleoNotificationTable;

/**
 * @author Rafael Praxedes
 */
public class UpgradeSchema extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		upgrade(
			new UpgradeMVCCVersion() {

				@Override
				protected String[] getModuleTableNames() {
					return new String[] {
						"KaleoAction", "KaleoCondition", "KaleoDefinition",
						"KaleoDefinitionVersion", "KaleoInstance",
						"KaleoInstanceToken", "KaleoLog", "KaleoNode",
						"KaleoNotification", "KaleoNotificationRecipient",
						"KaleoTask", "KaleoTaskAssignment",
						"KaleoTaskAssignmentInstance", "KaleoTaskForm",
						"KaleoTaskFormInstance", "KaleoTaskInstanceToken",
						"KaleoTimer", "KaleoTimerInstanceToken",
						"KaleoTransition"
					};
				}

			});

		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			alter(
				KaleoNotificationTable.class,
				new AlterColumnType("notificationTypes", "VARCHAR(255) null"));
		}
	}

}