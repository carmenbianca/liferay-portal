/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.messaging.internal.upgrade;

import com.liferay.portal.configuration.persistence.upgrade.ConfigurationUpgradeStepFactory;
import com.liferay.portal.messaging.internal.configuration.DestinationWorkerConfiguration;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Tom Wang
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class PortalMessagingUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register(
			"0.0.0", "1.0.0",
			_configurationUpgradeStepFactory.createUpgradeStep(
				"com.liferay.portal.messaging.configuration." +
					"DestinationWorkerConfiguration",
				DestinationWorkerConfiguration.class.getName()));
	}

	@Reference
	private ConfigurationUpgradeStepFactory _configurationUpgradeStepFactory;

}