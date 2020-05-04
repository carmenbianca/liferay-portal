/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.web.internal.upgrade.v1_0_0;

import com.liferay.knowledge.base.configuration.KBGroupServiceConfiguration;
import com.liferay.knowledge.base.constants.KBPortletKeys;
import com.liferay.portal.kernel.settings.SettingsFactory;
import com.liferay.portal.kernel.util.PortletKeys;

/**
 * @author Roberto Díaz
 */
public class UpgradePortletSettings
	extends com.liferay.portal.upgrade.v7_0_0.UpgradePortletSettings {

	public UpgradePortletSettings(SettingsFactory settingsFactory) {
		super(settingsFactory);
	}

	@Override
	protected void doUpgrade() throws Exception {
		upgradeMainPortlet(
			KBPortletKeys.KNOWLEDGE_BASE_ADMIN,
			KBGroupServiceConfiguration.class.getName(),
			PortletKeys.PREFS_OWNER_TYPE_GROUP, false);
	}

}