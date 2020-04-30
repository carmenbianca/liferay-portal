/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.web.internal.upgrade;

import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.settings.web.internal.upgrade.v1_0_0.UpgradePortletId;
import com.liferay.portal.settings.web.internal.upgrade.v1_0_1.UpgradeInstanceSettingsPortletId;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Philip Jones
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class PortalSettingWebUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "1.0.0", new DummyUpgradeStep());

		registry.register("0.0.1", "1.0.0", new UpgradePortletId());

		registry.register(
			"1.0.0", "1.0.1", new UpgradeInstanceSettingsPortletId());
	}

}