/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.layout.set.prototype.internal.upgrade;

import com.liferay.document.library.layout.set.prototype.internal.upgrade.v1_0_0.UpgradeLocalizedColumn;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Leon Chi
 */
@Component(service = UpgradeStepRegistrator.class)
public class DocumentLibraryLayoutSetPrototypeUpgrade
	implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "1.0.0", new DummyUpgradeStep());

		registry.register("1.0.0", "1.0.1", new UpgradeLocalizedColumn());
	}

}