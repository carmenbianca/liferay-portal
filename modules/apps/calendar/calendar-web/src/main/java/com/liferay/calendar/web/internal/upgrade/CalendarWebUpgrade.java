/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.web.internal.upgrade;

import com.liferay.calendar.web.internal.upgrade.v1_0_0.UpgradePortletId;
import com.liferay.calendar.web.internal.upgrade.v1_0_0.UpgradePortletPreferences;
import com.liferay.calendar.web.internal.upgrade.v1_1_0.UpgradePortalPreferences;
import com.liferay.calendar.web.internal.upgrade.v1_1_1.UpgradeEventsDisplayPortletId;
import com.liferay.portal.kernel.service.PortletPreferencesLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Marcellus Tavares
 * @author Manuel de la Peña
 */
@Component(
	immediate = true,
	service = {CalendarWebUpgrade.class, UpgradeStepRegistrator.class}
)
public class CalendarWebUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "1.0.0", new DummyUpgradeStep());

		registry.register(
			"0.0.1", "1.0.0", new UpgradePortletId(),
			new UpgradePortletPreferences());

		registry.register(
			"1.0.0", "1.0.1",
			new com.liferay.calendar.web.internal.upgrade.v1_0_1.
				UpgradePortletPreferences());

		registry.register(
			"1.0.1", "1.1.0", new UpgradePortalPreferences(),
			new com.liferay.calendar.web.internal.upgrade.v1_1_0.
				UpgradePortletId());

		registry.register(
			"1.1.0", "1.1.1",
			new UpgradeEventsDisplayPortletId(
				_portletPreferencesLocalService,
				_resourcePermissionLocalService));
	}

	@Reference
	private PortletPreferencesLocalService _portletPreferencesLocalService;

	@Reference
	private ResourcePermissionLocalService _resourcePermissionLocalService;

}