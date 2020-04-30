/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.announcements.web.internal.upgrade;

import com.liferay.announcements.web.internal.upgrade.v1_0_2.UpgradePermission;
import com.liferay.announcements.web.internal.upgrade.v1_0_4.UpgradePortletPreferences;
import com.liferay.portal.kernel.upgrade.BaseReplacePortletId;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.kernel.upgrade.UpgradeException;
import com.liferay.portal.kernel.upgrade.UpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import com.liferay.portal.upgrade.release.BaseUpgradeWebModuleRelease;

import org.osgi.service.component.annotations.Component;

/**
 * @author Adolfo Pérez
 * @author Roberto Díaz
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class AnnouncementsWebUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		BaseUpgradeWebModuleRelease upgradeWebModuleRelease =
			new BaseUpgradeWebModuleRelease() {

				@Override
				protected String getBundleSymbolicName() {
					return "com.liferay.announcements.web";
				}

				@Override
				protected String[] getPortletIds() {
					return new String[] {
						"1_WAR_soannouncementsportlet", "83", "84"
					};
				}

			};

		try {
			upgradeWebModuleRelease.upgrade();
		}
		catch (UpgradeException upgradeException) {
			throw new RuntimeException(upgradeException);
		}

		registry.register("0.0.0", "2.0.0", new DummyUpgradeStep());

		UpgradeStep upgradePortletId = new BaseReplacePortletId() {

			@Override
			protected String[][] getRenamePortletIdsArray() {
				return new String[][] {
					{
						"1_WAR_soannouncementsportlet",
						"com_liferay_announcements_web_portlet_" +
							"AnnouncementsPortlet"
					},
					{
						"83",
						"com_liferay_announcements_web_portlet_AlertsPortlet"
					},
					{
						"84",
						"com_liferay_announcements_web_portlet_" +
							"AnnouncementsPortlet"
					}
				};
			}

		};

		registry.register("0.0.1", "1.0.1", upgradePortletId);

		// See LPS-65946

		registry.register("1.0.0", "1.0.1", upgradePortletId);

		registry.register("1.0.1", "1.0.2", new UpgradePermission(true));

		// See LPS-69656

		registry.register(
			"1.0.2", "1.0.3", upgradePortletId, new UpgradePermission(true));

		registry.register("1.0.3", "1.0.4", new UpgradePortletPreferences());

		registry.register(
			"1.0.4", "2.0.0",
			new com.liferay.announcements.web.internal.upgrade.v2_0_0.
				UpgradePortletPreferences());
	}

}