/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.v7_3_x;

import com.liferay.portal.kernel.upgrade.UpgradeCTModel;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.version.Version;
import com.liferay.portal.upgrade.util.PortalUpgradeProcessRegistry;

import java.util.TreeMap;

/**
 * @author Alicia García
 */
public class PortalUpgradeProcessRegistryImpl
	implements PortalUpgradeProcessRegistry {

	@Override
	public void registerUpgradeProcesses(
		TreeMap<Version, UpgradeProcess> upgradeProcesses) {

		upgradeProcesses.put(new Version(6, 0, 0), new UpgradeMVCCVersion());

		upgradeProcesses.put(new Version(6, 0, 1), new UpgradeLayout());

		upgradeProcesses.put(new Version(6, 0, 2), new UpgradeLayoutSet());

		upgradeProcesses.put(new Version(6, 0, 3), new UpgradeClusterGroup());

		upgradeProcesses.put(new Version(6, 0, 4), new UpgradeAssetCategory());

		upgradeProcesses.put(new Version(7, 0, 0), new UpgradeRatingsStats());

		upgradeProcesses.put(
			new Version(7, 1, 0),
			new UpgradeCTModel(
				"AssetCategory", "AssetCategoryProperty", "AssetEntry",
				"AssetLink", "AssetTag", "AssetVocabulary", "Layout",
				"LayoutFriendlyURL", "PortletPreferences",
				"ResourcePermission"));

		upgradeProcesses.put(new Version(8, 0, 0), new UpgradeSchema());

		upgradeProcesses.put(
			new Version(8, 1, 0),
			new UpgradeCTModel(
				"AssetEntries_AssetCategories", "AssetEntries_AssetTags"));

		upgradeProcesses.put(
			new Version(8, 1, 1), new UpgradeAssetCategoryName());

		upgradeProcesses.put(
			new Version(8, 2, 0), new UpgradeAssetEntryMappingTables());

		upgradeProcesses.put(
			new Version(8, 3, 0), new UpgradeUserGroupGroupRole());

		upgradeProcesses.put(new Version(8, 4, 0), new UpgradeUserGroupRole());
	}

}