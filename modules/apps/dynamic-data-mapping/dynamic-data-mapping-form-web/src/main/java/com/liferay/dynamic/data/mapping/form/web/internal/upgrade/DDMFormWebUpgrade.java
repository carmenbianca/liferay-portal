/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.web.internal.upgrade;

import com.liferay.dynamic.data.mapping.form.web.internal.upgrade.v1_0_0.UpgradeDDMFormAdminPortletId;
import com.liferay.dynamic.data.mapping.form.web.internal.upgrade.v1_0_0.UpgradeDDMFormPortletId;
import com.liferay.dynamic.data.mapping.form.web.internal.upgrade.v1_0_0.UpgradeDDMFormPortletPreferences;
import com.liferay.portal.kernel.service.PortletPreferencesLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Praxedes
 */
@Component(
	immediate = true,
	service = {DDMFormWebUpgrade.class, UpgradeStepRegistrator.class}
)
public class DDMFormWebUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"0.0.0", "1.0.0", new UpgradeDDMFormAdminPortletId(),
			new UpgradeDDMFormPortletId(),
			new UpgradeDDMFormPortletPreferences());
	}

	@Reference
	private PortletPreferencesLocalService _portletPreferencesLocalService;

	@Reference
	private ResourcePermissionLocalService _resourcePermissionLocalService;

}