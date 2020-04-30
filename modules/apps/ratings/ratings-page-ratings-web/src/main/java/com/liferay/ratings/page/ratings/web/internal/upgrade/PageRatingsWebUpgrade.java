/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.ratings.page.ratings.web.internal.upgrade;

import com.liferay.portal.kernel.upgrade.BaseUpgradePortletId;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.kernel.upgrade.UpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import com.liferay.ratings.page.ratings.constants.PageRatingsPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Roberto Díaz
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class PageRatingsWebUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "1.0.0", new DummyUpgradeStep());

		UpgradeStep upgradePortletId = new BaseUpgradePortletId() {

			@Override
			protected String[][] getRenamePortletIdsArray() {
				return new String[][] {
					{"108", PageRatingsPortletKeys.PAGE_RATINGS}
				};
			}

		};

		registry.register("0.0.1", "1.0.0", upgradePortletId);
	}

}