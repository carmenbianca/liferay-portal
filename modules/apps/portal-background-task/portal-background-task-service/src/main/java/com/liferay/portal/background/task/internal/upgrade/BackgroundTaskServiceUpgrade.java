/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.background.task.internal.upgrade;

import com.liferay.portal.background.task.internal.upgrade.v1_0_0.UpgradeBackgroundTask;
import com.liferay.portal.background.task.internal.upgrade.v1_0_0.UpgradeKernelPackage;
import com.liferay.portal.background.task.internal.upgrade.v1_0_0.UpgradeSchema;
import com.liferay.portal.background.task.internal.upgrade.v2_0_0.util.BackgroundTaskTable;
import com.liferay.portal.kernel.upgrade.BaseUpgradeSQLServerDatetime;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Cristina Rodríguez
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class BackgroundTaskServiceUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"0.0.1", "0.0.2", new UpgradeSchema(), new UpgradeKernelPackage());

		registry.register("0.0.2", "1.0.0", new UpgradeBackgroundTask());

		registry.register(
			"1.0.0", "2.0.0",
			new BaseUpgradeSQLServerDatetime(
				new Class<?>[] {BackgroundTaskTable.class}));
	}

}