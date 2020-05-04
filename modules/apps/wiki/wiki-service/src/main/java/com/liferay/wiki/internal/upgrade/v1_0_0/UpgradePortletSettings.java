/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.wiki.internal.upgrade.v1_0_0;

import com.liferay.portal.kernel.settings.SettingsFactory;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.wiki.constants.WikiConstants;
import com.liferay.wiki.constants.WikiPortletKeys;

/**
 * @author Iván Zaera
 */
public class UpgradePortletSettings
	extends com.liferay.portal.upgrade.v7_0_0.UpgradePortletSettings {

	public UpgradePortletSettings(SettingsFactory settingsFactory) {
		super(settingsFactory);
	}

	@Override
	protected void doUpgrade() throws Exception {
		upgradeDisplayPortlet(
			WikiPortletKeys.WIKI_DISPLAY, WikiConstants.SERVICE_NAME,
			PortletKeys.PREFS_OWNER_TYPE_LAYOUT);
	}

}