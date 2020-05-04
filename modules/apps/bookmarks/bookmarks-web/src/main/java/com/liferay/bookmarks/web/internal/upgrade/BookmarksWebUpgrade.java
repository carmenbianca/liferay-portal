/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.web.internal.upgrade;

import com.liferay.bookmarks.constants.BookmarksPortletKeys;
import com.liferay.bookmarks.web.internal.upgrade.v1_0_0.UpgradeAdminPortlets;
import com.liferay.bookmarks.web.internal.upgrade.v1_0_0.UpgradePortletPreferences;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.upgrade.BaseUpgradeStagingGroupTypeSettings;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Miguel Pastor
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class BookmarksWebUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "1.0.0", new DummyUpgradeStep());

		registry.register(
			"0.0.1", "1.0.0", new UpgradeAdminPortlets(),
			new UpgradePortletPreferences());

		registry.register(
			"1.0.0", "1.0.1",
			new BaseUpgradeStagingGroupTypeSettings(
				_companyLocalService, _groupLocalService,
				BookmarksPortletKeys.BOOKMARKS,
				BookmarksPortletKeys.BOOKMARKS_ADMIN));
	}

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private GroupLocalService _groupLocalService;

}