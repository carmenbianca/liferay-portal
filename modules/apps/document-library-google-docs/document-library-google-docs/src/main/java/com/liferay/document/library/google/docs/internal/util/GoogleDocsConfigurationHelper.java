/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.google.docs.internal.util;

import com.liferay.document.library.google.drive.configuration.DLGoogleDriveCompanyConfiguration;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil;

/**
 * @author Iván Zaera
 */
public class GoogleDocsConfigurationHelper {

	public GoogleDocsConfigurationHelper(long companyId)
		throws ConfigurationException {

		_dlGoogleDriveCompanyConfiguration =
			ConfigurationProviderUtil.getCompanyConfiguration(
				DLGoogleDriveCompanyConfiguration.class, companyId);
	}

	public String getGoogleAppsAPIKey() {
		return _dlGoogleDriveCompanyConfiguration.pickerAPIKey();
	}

	public String getGoogleClientId() {
		return _dlGoogleDriveCompanyConfiguration.clientId();
	}

	private final DLGoogleDriveCompanyConfiguration
		_dlGoogleDriveCompanyConfiguration;

}