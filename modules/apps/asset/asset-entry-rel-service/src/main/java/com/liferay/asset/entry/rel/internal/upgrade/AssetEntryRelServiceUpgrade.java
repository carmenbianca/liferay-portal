/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.entry.rel.internal.upgrade;

import com.liferay.asset.entry.rel.internal.upgrade.v1_0_0.UpgradeAssetEntryAssetCategoryRel;
import com.liferay.asset.entry.rel.internal.upgrade.v2_0_0.UpgradeCompanyId;
import com.liferay.portal.kernel.upgrade.UpgradeCTModel;
import com.liferay.portal.kernel.upgrade.UpgradeMVCCVersion;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class AssetEntryRelServiceUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"0.0.1", "1.0.0", new UpgradeAssetEntryAssetCategoryRel());

		registry.register(
			"1.0.0", "1.1.0",
			new UpgradeMVCCVersion() {

				@Override
				protected String[] getModuleTableNames() {
					return new String[] {"AssetEntryAssetCategoryRel"};
				}

			});

		registry.register("1.1.0", "2.0.0", new UpgradeCompanyId());

		registry.register(
			"2.0.0", "2.1.0", new UpgradeCTModel("AssetEntryAssetCategoryRel"));
	}

}