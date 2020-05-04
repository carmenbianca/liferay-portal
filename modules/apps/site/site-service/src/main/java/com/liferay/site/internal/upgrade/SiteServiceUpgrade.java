/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.internal.upgrade;

import com.liferay.portal.kernel.upgrade.BaseUpgradeSQLServerDatetime;
import com.liferay.portal.kernel.upgrade.UpgradeMVCCVersion;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import com.liferay.site.internal.upgrade.v2_0_0.util.SiteFriendlyURLTable;

import org.osgi.service.component.annotations.Component;

/**
 * @author José Ángel Jiménez
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class SiteServiceUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"1.0.0", "2.0.0",
			new BaseUpgradeSQLServerDatetime(
				new Class<?>[] {SiteFriendlyURLTable.class}));

		registry.register(
			"2.0.0", "2.1.0",
			new UpgradeMVCCVersion() {

				@Override
				protected String[] getModuleTableNames() {
					return new String[] {"SiteFriendlyURL"};
				}

			});
	}

}