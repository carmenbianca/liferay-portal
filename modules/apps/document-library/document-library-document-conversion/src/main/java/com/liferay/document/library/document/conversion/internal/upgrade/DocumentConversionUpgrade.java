/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.document.conversion.internal.upgrade;

import com.liferay.document.library.document.conversion.internal.upgrade.v1_0_0.UpgradeOpenOfficeConfiguration;
import com.liferay.portal.configuration.upgrade.PrefsPropsToConfigurationUpgradeHelper;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pei-Jung Lan
 */
@Component(service = UpgradeStepRegistrator.class)
public class DocumentConversionUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "0.0.1", new DummyUpgradeStep());

		registry.register(
			"0.0.1", "1.0.0",
			new UpgradeOpenOfficeConfiguration(
				_prefsPropsToConfigurationUpgradeHelper));
	}

	@Reference
	private PrefsPropsToConfigurationUpgradeHelper
		_prefsPropsToConfigurationUpgradeHelper;

}