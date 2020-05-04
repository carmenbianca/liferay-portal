/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.list.internal.upgrade;

import com.liferay.asset.list.internal.upgrade.v1_3_0.UpgradeAssetListEntry;
import com.liferay.portal.kernel.upgrade.UpgradeCTModel;
import com.liferay.portal.kernel.upgrade.UpgradeMVCCVersion;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Preston Crary
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class AssetListServiceUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"1.0.0", "1.1.0",
			new UpgradeMVCCVersion() {

				@Override
				protected String[] getModuleTableNames() {
					return new String[] {
						"AssetListEntry", "AssetListEntryAssetEntryRel",
						"AssetListEntrySegmentsEntryRel", "AssetListEntryUsage"
					};
				}

			});

		registry.register(
			"1.1.0", "1.2.0",
			new UpgradeCTModel(
				"AssetListEntry", "AssetListEntryAssetEntryRel",
				"AssetListEntrySegmentsEntryRel", "AssetListEntryUsage"));

		registry.register("1.2.0", "1.3.0", new UpgradeAssetListEntry());
	}

}