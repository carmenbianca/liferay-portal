/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.internal.upgrade;

import com.liferay.data.engine.internal.upgrade.v1_0_0.UpgradeSchema;
import com.liferay.data.engine.internal.upgrade.v2_0_0.UpgradeCompanyId;
import com.liferay.data.engine.internal.upgrade.v2_1_0.UpgradeDEDataDefinitionFieldLink;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jeyvison Nascimento
 */
@Component(
	immediate = true,
	service = {DEServiceUpgrade.class, UpgradeStepRegistrator.class}
)
public class DEServiceUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("1.0.0", "1.1.0", new UpgradeSchema());

		registry.register("1.1.0", "2.0.0", new UpgradeCompanyId());

		registry.register(
			"2.0.0", "2.1.0", new UpgradeDEDataDefinitionFieldLink());
	}

}