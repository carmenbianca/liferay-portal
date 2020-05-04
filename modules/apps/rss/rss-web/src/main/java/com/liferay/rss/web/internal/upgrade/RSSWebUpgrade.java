/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.rss.web.internal.upgrade;

import com.liferay.portal.configuration.persistence.upgrade.ConfigurationUpgradeStepFactory;
import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import com.liferay.portal.upgrade.v7_0_0.UpgradeKernelPackage;
import com.liferay.rss.constants.RSSPortletKeys;
import com.liferay.rss.web.internal.configuration.RSSPortletInstanceConfiguration;
import com.liferay.rss.web.internal.configuration.RSSWebCacheConfiguration;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class RSSWebUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "3.0.0", new DummyUpgradeStep());

		registry.register(
			"0.0.1", "1.0.0",
			new BaseUpgradePortletId() {

				@Override
				protected String[][] getRenamePortletIdsArray() {
					return new String[][] {{"39", RSSPortletKeys.RSS}};
				}

			});

		registry.register(
			"1.0.0", "3.0.0",
			new UpgradeKernelPackage() {

				@Override
				protected String[][] getClassNames() {
					return new String[][] {
						{
							"com.liferay.rss.web.util.RSSFeed",
							"com.liferay.rss.web.internal.util.RSSFeed"
						}
					};
				}

				@Override
				protected String[][] getResourceNames() {
					return new String[0][0];
				}

			});

		registry.register(
			"3.0.0", "3.0.1",
			_configurationUpgradeStepFactory.createUpgradeStep(
				"com.liferay.rss.web.configuration." +
					"RSSPortletInstanceConfiguration",
				RSSPortletInstanceConfiguration.class.getName()),
			_configurationUpgradeStepFactory.createUpgradeStep(
				"com.liferay.rss.web.configuration.RSSWebCacheConfiguration",
				RSSWebCacheConfiguration.class.getName()));
	}

	@Reference
	private ConfigurationUpgradeStepFactory _configurationUpgradeStepFactory;

}