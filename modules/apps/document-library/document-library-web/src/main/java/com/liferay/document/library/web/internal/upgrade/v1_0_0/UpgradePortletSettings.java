/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.upgrade.v1_0_0;

import com.liferay.document.library.constants.DLPortletKeys;
import com.liferay.document.library.web.internal.settings.DLPortletInstanceSettings;
import com.liferay.portal.kernel.settings.SettingsFactory;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portlet.documentlibrary.DLGroupServiceSettings;
import com.liferay.portlet.documentlibrary.constants.DLConstants;

/**
 * @author Sergio González
 */
public class UpgradePortletSettings
	extends com.liferay.portal.upgrade.v7_0_0.UpgradePortletSettings {

	public UpgradePortletSettings(SettingsFactory settingsFactory) {
		super(settingsFactory);
	}

	@Override
	protected void doUpgrade() throws Exception {
		DLGroupServiceSettings.registerSettingsMetadata();
		DLPortletInstanceSettings.registerSettingsMetadata();

		upgradeMainPortlet(
			DLPortletKeys.DOCUMENT_LIBRARY, DLConstants.SERVICE_NAME,
			PortletKeys.PREFS_OWNER_TYPE_GROUP, true);

		upgradeDisplayPortlet(
			DLPortletKeys.DOCUMENT_LIBRARY, DLConstants.SERVICE_NAME,
			PortletKeys.PREFS_OWNER_TYPE_LAYOUT);
		upgradeDisplayPortlet(
			DLPortletKeys.MEDIA_GALLERY_DISPLAY, DLConstants.SERVICE_NAME,
			PortletKeys.PREFS_OWNER_TYPE_LAYOUT);
	}

}