/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_2_x;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.version.Version;
import com.liferay.portal.upgrade.util.PortalUpgradeProcessRegistry;

import java.util.TreeMap;

/**
 * @author José Ángel Jiménez
 */
public class PortalUpgradeProcessRegistryImpl
	implements PortalUpgradeProcessRegistry {

	@Override
	public void registerUpgradeProcesses(
		TreeMap<Version, UpgradeProcess> upgradeProcesses) {

		upgradeProcesses.put(
			new Version(3, 0, 0), new UpgradeSQLServerDatetime());

		upgradeProcesses.put(new Version(4, 0, 0), new UpgradeSchema());

		upgradeProcesses.put(new Version(5, 0, 0), new UpgradeBadColumnNames());

		upgradeProcesses.put(new Version(5, 0, 1), new UpgradePersonalMenu());

		upgradeProcesses.put(new Version(5, 0, 2), new UpgradeCountry());

		upgradeProcesses.put(new Version(5, 0, 3), new UpgradeModules());

		upgradeProcesses.put(new Version(5, 0, 4), new UpgradeLayout());

		upgradeProcesses.put(new Version(5, 0, 5), new UpgradeThemeId());

		upgradeProcesses.put(new Version(5, 1, 0), new UpgradeMVCCVersion());

		upgradeProcesses.put(new Version(5, 1, 1), new UpgradeVirtualHost());
	}

}