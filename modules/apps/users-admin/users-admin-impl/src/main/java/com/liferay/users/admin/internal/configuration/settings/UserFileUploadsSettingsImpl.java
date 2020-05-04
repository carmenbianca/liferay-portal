/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.internal.configuration.settings;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.users.admin.configuration.UserFileUploadsConfiguration;
import com.liferay.users.admin.kernel.file.uploads.UserFileUploadsSettings;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Drew Brokke
 */
@Component(
	configurationPid = "com.liferay.users.admin.configuration.UserFileUploadsConfiguration",
	immediate = true, service = UserFileUploadsSettings.class
)
public class UserFileUploadsSettingsImpl implements UserFileUploadsSettings {

	@Override
	public int getImageMaxHeight() {
		return _userFileUploadsConfiguration.imageMaxHeight();
	}

	@Override
	public long getImageMaxSize() {
		return _userFileUploadsConfiguration.imageMaxSize();
	}

	@Override
	public int getImageMaxWidth() {
		return _userFileUploadsConfiguration.imageMaxWidth();
	}

	@Override
	public boolean isImageCheckToken() {
		return _userFileUploadsConfiguration.imageCheckToken();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x)
	 */
	@Deprecated
	@Override
	public boolean isImageDefaultUseInitials() {
		return false;
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_userFileUploadsConfiguration = ConfigurableUtil.createConfigurable(
			UserFileUploadsConfiguration.class, properties);
	}

	private UserFileUploadsConfiguration _userFileUploadsConfiguration;

}