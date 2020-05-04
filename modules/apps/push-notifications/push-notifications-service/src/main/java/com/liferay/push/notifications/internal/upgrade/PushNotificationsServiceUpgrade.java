/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.push.notifications.internal.upgrade;

import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import com.liferay.push.notifications.internal.upgrade.v1_0_6.UpgradeCompanyId;

import org.osgi.service.component.annotations.Component;

/**
 * @author Bruno Farache
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class PushNotificationsServiceUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.1", "1.0.5", new DummyUpgradeStep());

		registry.register("1.0.5", "1.0.6", new UpgradeCompanyId());
	}

}