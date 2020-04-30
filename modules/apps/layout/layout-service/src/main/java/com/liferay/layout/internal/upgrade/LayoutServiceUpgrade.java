/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.internal.upgrade;

import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.service.AssetEntryUsageLocalService;
import com.liferay.layout.internal.upgrade.v1_0_0.UpgradeLayout;
import com.liferay.layout.internal.upgrade.v1_0_0.UpgradeLayoutClassedModelUsage;
import com.liferay.layout.internal.upgrade.v1_0_0.UpgradeLayoutPermissions;
import com.liferay.layout.internal.upgrade.v1_1_0.UpgradeCompanyId;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class LayoutServiceUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"0.0.0", "1.0.0",
			new UpgradeLayoutClassedModelUsage(
				_assetEntryLocalService, _assetEntryUsageLocalService),
			new UpgradeLayoutPermissions());

		registry.register("1.0.0", "1.0.1", new UpgradeLayout());

		registry.register("1.0.1", "1.1.0", new UpgradeCompanyId());
	}

	@Reference
	private AssetEntryLocalService _assetEntryLocalService;

	@Reference
	private AssetEntryUsageLocalService _assetEntryUsageLocalService;

}