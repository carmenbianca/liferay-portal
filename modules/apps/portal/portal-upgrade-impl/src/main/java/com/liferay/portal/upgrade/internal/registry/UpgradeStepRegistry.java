/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.internal.registry;

import com.liferay.portal.kernel.upgrade.UpgradeStep;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Preston Crary
 */
public class UpgradeStepRegistry implements UpgradeStepRegistrator.Registry {

	public UpgradeStepRegistry(int buildNumber) {
		_buildNumber = buildNumber;
	}

	public List<UpgradeInfo> getUpgradeInfos() {
		return _upgradeInfos;
	}

	@Override
	public void register(
		String fromSchemaVersionString, String toSchemaVersionString,
		UpgradeStep... upgradeSteps) {

		_createUpgradeInfos(
			fromSchemaVersionString, toSchemaVersionString, _buildNumber,
			upgradeSteps);
	}

	private void _createUpgradeInfos(
		String fromSchemaVersionString, String toSchemaVersionString,
		int buildNumber, UpgradeStep... upgradeSteps) {

		if (ArrayUtil.isEmpty(upgradeSteps)) {
			return;
		}

		String upgradeInfoFromSchemaVersionString = fromSchemaVersionString;

		for (int i = 0; i < (upgradeSteps.length - 1); i++) {
			UpgradeStep upgradeStep = upgradeSteps[i];

			String upgradeInfoToSchemaVersionString =
				toSchemaVersionString + ".step" + (i - upgradeSteps.length + 1);

			UpgradeInfo upgradeInfo = new UpgradeInfo(
				upgradeInfoFromSchemaVersionString,
				upgradeInfoToSchemaVersionString, buildNumber, upgradeStep);

			_upgradeInfos.add(upgradeInfo);

			upgradeInfoFromSchemaVersionString =
				upgradeInfoToSchemaVersionString;
		}

		UpgradeInfo upgradeInfo = new UpgradeInfo(
			upgradeInfoFromSchemaVersionString, toSchemaVersionString,
			buildNumber, upgradeSteps[upgradeSteps.length - 1]);

		_upgradeInfos.add(upgradeInfo);
	}

	private final int _buildNumber;
	private final List<UpgradeInfo> _upgradeInfos = new ArrayList<>();

}