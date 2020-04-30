/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.web.internal.upgrade;

import com.liferay.message.boards.constants.MBPortletKeys;
import com.liferay.message.boards.web.internal.upgrade.v1_0_0.UpgradePortletSettings;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.settings.SettingsFactory;
import com.liferay.portal.kernel.upgrade.BaseUpgradeStagingGroupTypeSettings;
import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Sergio González
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class MBWebUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "1.0.0", new DummyUpgradeStep());

		registry.register(
			"0.0.1", "1.0.0", new UpgradePortletSettings(_settingsFactory));

		registry.register(
			"1.0.0", "1.0.1",
			new BaseUpgradeStagingGroupTypeSettings(
				_companyLocalService, _groupLocalService,
				MBPortletKeys.MESSAGE_BOARDS,
				MBPortletKeys.MESSAGE_BOARDS_ADMIN));
	}

	@Reference(unbind = "-")
	public void setCompanyLocalService(
		CompanyLocalService companyLocalService) {

		_companyLocalService = companyLocalService;
	}

	@Reference(unbind = "-")
	public void setGroupLocalService(GroupLocalService groupLocalService) {
		_groupLocalService = groupLocalService;
	}

	@Reference(unbind = "-")
	protected void setSettingsFactory(SettingsFactory settingsFactory) {
		_settingsFactory = settingsFactory;
	}

	private CompanyLocalService _companyLocalService;
	private GroupLocalService _groupLocalService;
	private SettingsFactory _settingsFactory;

}