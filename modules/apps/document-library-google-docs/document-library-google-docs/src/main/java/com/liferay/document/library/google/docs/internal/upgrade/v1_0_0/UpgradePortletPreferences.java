/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.google.docs.internal.upgrade.v1_0_0;

import com.liferay.document.library.google.drive.configuration.DLGoogleDriveCompanyConfiguration;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.util.PrefsProps;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalInstances;

import javax.portlet.PortletPreferences;

/**
 * @author Alejandro Tardín
 */
public class UpgradePortletPreferences extends UpgradeProcess {

	public UpgradePortletPreferences(
		ConfigurationProvider configurationProvider, PrefsProps prefsProps) {

		_configurationProvider = configurationProvider;
		_prefsProps = prefsProps;
	}

	@Override
	protected void doUpgrade() throws Exception {
		for (long companyId : PortalInstances.getCompanyIdsBySQL()) {
			DLGoogleDriveCompanyConfiguration
				dlGoogleDriveCompanyConfiguration =
					_configurationProvider.getCompanyConfiguration(
						DLGoogleDriveCompanyConfiguration.class, companyId);

			PortletPreferences portletPreferences = _prefsProps.getPreferences(
				companyId);

			String apiKey = portletPreferences.getValue(
				"googleAppsAPIKey", StringPool.BLANK);
			String clientId = portletPreferences.getValue(
				"googleClientId", StringPool.BLANK);

			if (Validator.isNotNull(apiKey) && Validator.isNotNull(clientId) &&
				Validator.isNull(
					dlGoogleDriveCompanyConfiguration.clientId()) &&
				Validator.isNull(
					dlGoogleDriveCompanyConfiguration.clientSecret())) {

				_configurationProvider.saveCompanyConfiguration(
					DLGoogleDriveCompanyConfiguration.class, companyId,
					new HashMapDictionary<String, Object>() {
						{
							put("clientId", clientId);
							put("pickerAPIKey", apiKey);
						}
					});
			}
		}
	}

	private final ConfigurationProvider _configurationProvider;
	private final PrefsProps _prefsProps;

}