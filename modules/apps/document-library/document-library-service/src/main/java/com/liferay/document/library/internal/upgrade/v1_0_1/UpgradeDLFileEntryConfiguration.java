/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.internal.upgrade.v1_0_1;

import com.liferay.document.library.configuration.DLFileEntryConfiguration;
import com.liferay.document.library.internal.constants.LegacyDLKeys;
import com.liferay.portal.configuration.upgrade.PrefsPropsToConfigurationUpgradeHelper;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.KeyValuePair;

/**
 * @author Drew Brokke
 */
public class UpgradeDLFileEntryConfiguration extends UpgradeProcess {

	public UpgradeDLFileEntryConfiguration(
		PrefsPropsToConfigurationUpgradeHelper
			prefsPropsToConfigurationUpgradeHelper) {

		_prefsPropsToConfigurationUpgradeHelper =
			prefsPropsToConfigurationUpgradeHelper;
	}

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeConfiguration();
	}

	private void _upgradeConfiguration() throws Exception {
		_prefsPropsToConfigurationUpgradeHelper.mapConfigurations(
			DLFileEntryConfiguration.class,
			new KeyValuePair(
				LegacyDLKeys.DL_FILE_ENTRY_PREVIEWABLE_PROCESSOR_MAX_SIZE,
				"previewableProcessorMaxSize"));
	}

	private final PrefsPropsToConfigurationUpgradeHelper
		_prefsPropsToConfigurationUpgradeHelper;

}