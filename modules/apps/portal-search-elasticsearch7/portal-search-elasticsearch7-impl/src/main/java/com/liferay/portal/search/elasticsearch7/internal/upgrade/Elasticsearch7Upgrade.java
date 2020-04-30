/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.upgrade;

import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.search.elasticsearch7.internal.upgrade.v1_0_0.UpgradeElasticsearchConfiguration;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bryan Engler
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class Elasticsearch7Upgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "0.0.1", new DummyUpgradeStep());

		registry.register(
			"0.0.1", "1.0.0",
			new UpgradeElasticsearchConfiguration(_configurationAdmin));
	}

	@Reference
	private ConfigurationAdmin _configurationAdmin;

}