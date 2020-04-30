/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upgrade.registry;

import com.liferay.portal.kernel.upgrade.UpgradeStep;

/**
 * @author Carlos Sierra Andrés
 */
public interface UpgradeStepRegistrator {

	public void register(Registry registry);

	public interface Registry {

		public void register(
			String fromSchemaVersionString, String toSchemaVersionString,
			UpgradeStep... upgradeSteps);

	}

}