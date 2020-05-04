/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.upgrade;

import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.search.web.internal.upgrade.v1_0_0.UpgradePortletId;
import com.liferay.portal.search.web.internal.upgrade.v1_0_0.UpgradePortletPreferences;
import com.liferay.portal.search.web.internal.upgrade.v2_0_0.UpgradeSearchPortlet;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class SearchWebUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "1.0.0", new DummyUpgradeStep());

		registry.register(
			"0.0.1", "1.0.0", new UpgradePortletId(),
			new UpgradePortletPreferences());

		registry.register("1.0.0", "2.0.0", new UpgradeSearchPortlet());
	}

}