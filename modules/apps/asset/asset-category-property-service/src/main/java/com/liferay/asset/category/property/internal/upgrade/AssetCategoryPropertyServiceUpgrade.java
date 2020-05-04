/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.category.property.internal.upgrade;

import com.liferay.asset.category.property.internal.upgrade.v1_0_0.UpgradeClassNames;
import com.liferay.asset.category.property.internal.upgrade.v2_0_0.util.AssetCategoryPropertyTable;
import com.liferay.asset.category.property.internal.upgrade.v2_2_0.UpgradeAssetCategoryProperty;
import com.liferay.portal.kernel.upgrade.BaseUpgradeSQLServerDatetime;
import com.liferay.portal.kernel.upgrade.UpgradeCTModel;
import com.liferay.portal.kernel.upgrade.UpgradeMVCCVersion;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class AssetCategoryPropertyServiceUpgrade
	implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.1", "1.0.0", new UpgradeClassNames());

		registry.register(
			"1.0.0", "2.0.0",
			new BaseUpgradeSQLServerDatetime(
				new Class<?>[] {AssetCategoryPropertyTable.class}));

		registry.register(
			"2.0.0", "2.1.0",
			new UpgradeMVCCVersion() {

				@Override
				protected String[] getModuleTableNames() {
					return new String[] {"AssetCategoryProperty"};
				}

			});

		registry.register("2.1.0", "2.2.0", new UpgradeAssetCategoryProperty());

		registry.register(
			"2.2.0", "2.3.0", new UpgradeCTModel("AssetCategoryProperty"));
	}

}