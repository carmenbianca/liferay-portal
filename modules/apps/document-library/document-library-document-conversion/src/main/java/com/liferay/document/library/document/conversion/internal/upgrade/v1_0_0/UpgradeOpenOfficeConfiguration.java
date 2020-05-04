/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.document.conversion.internal.upgrade.v1_0_0;

import com.liferay.document.library.document.conversion.internal.configuration.OpenOfficeConfiguration;
import com.liferay.document.library.document.conversion.internal.constants.LegacyOpenOfficePropsKeys;
import com.liferay.portal.configuration.upgrade.PrefsPropsToConfigurationUpgradeHelper;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.KeyValuePair;

/**
 * @author Pei-Jung Lan
 */
public class UpgradeOpenOfficeConfiguration extends UpgradeProcess {

	public UpgradeOpenOfficeConfiguration(
		PrefsPropsToConfigurationUpgradeHelper
			prefsPropsToConfigurationUpgradeHelper) {

		_prefsPropsToConfigurationUpgradeHelper =
			prefsPropsToConfigurationUpgradeHelper;
	}

	@Override
	protected void doUpgrade() throws Exception {
		_prefsPropsToConfigurationUpgradeHelper.mapConfigurations(
			OpenOfficeConfiguration.class,
			new KeyValuePair(
				LegacyOpenOfficePropsKeys.OPENOFFICE_CACHE_ENABLED,
				"cacheEnabled"),
			new KeyValuePair(
				LegacyOpenOfficePropsKeys.OPENOFFICE_SERVER_ENABLED,
				"serverEnabled"),
			new KeyValuePair(
				LegacyOpenOfficePropsKeys.OPENOFFICE_SERVER_HOST, "serverHost"),
			new KeyValuePair(
				LegacyOpenOfficePropsKeys.OPENOFFICE_SERVER_PORT,
				"serverPort"));
	}

	private final PrefsPropsToConfigurationUpgradeHelper
		_prefsPropsToConfigurationUpgradeHelper;

}