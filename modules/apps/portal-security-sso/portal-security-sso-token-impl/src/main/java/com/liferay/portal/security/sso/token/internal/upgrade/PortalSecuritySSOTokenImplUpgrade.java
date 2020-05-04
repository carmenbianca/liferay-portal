/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.token.internal.upgrade;

import com.liferay.portal.configuration.persistence.upgrade.ConfigurationUpgradeStepFactory;
import com.liferay.portal.security.sso.token.internal.upgrade.v2_0_0.UpgradeTokenConfiguration;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tom Wang
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class PortalSecuritySSOTokenImplUpgrade
	implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"0.0.0", "1.0.0",
			_configurationUpgradeStepFactory.createUpgradeStep(
				"com.liferay.portal.security.sso.token.configuration." +
					"TokenConfiguration",
				"com.liferay.portal.security.sso.token.internal." +
					"configuration.TokenConfiguration"));

		registry.register("1.0.0", "1.0.1", new UpgradeTokenConfiguration());

		registry.register(
			"1.0.1", "2.0.0",
			_configurationUpgradeStepFactory.createUpgradeStep(
				"com.liferay.portal.security.sso.token.internal." +
					"configuration.TokenConfiguration",
				"com.liferay.portal.security.sso.token.configuration." +
					"TokenConfiguration"));
	}

	@Reference
	private ConfigurationUpgradeStepFactory _configurationUpgradeStepFactory;

}