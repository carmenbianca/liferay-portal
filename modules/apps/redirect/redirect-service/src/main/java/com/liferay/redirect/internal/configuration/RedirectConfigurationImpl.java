/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.internal.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.redirect.configuration.RedirectConfiguration;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Alejandro Tardín
 */
@Component(
	configurationPid = "com.liferay.redirect.internal.configuration.FFRedirectConfiguration",
	service = RedirectConfiguration.class
)
public class RedirectConfigurationImpl implements RedirectConfiguration {

	@Override
	public boolean isEnabled() {
		return _ffRedirectConfiguration.enabled();
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_ffRedirectConfiguration = ConfigurableUtil.createConfigurable(
			FFRedirectConfiguration.class, properties);
	}

	private volatile FFRedirectConfiguration _ffRedirectConfiguration;

}