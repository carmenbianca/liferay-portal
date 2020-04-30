/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.web.internal.configuration;

import com.liferay.depot.configuration.DepotConfiguration;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Alejandro Tardín
 */
@Component(
	configurationPid = "com.liferay.depot.web.internal.configuration.FFDepotConfiguration",
	service = DepotConfiguration.class
)
public class DepotConfigurationImpl implements DepotConfiguration {

	public boolean isEnabled() {
		return _ffDepotConfiguration.enabled();
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_ffDepotConfiguration = ConfigurableUtil.createConfigurable(
			FFDepotConfiguration.class, properties);
	}

	private volatile FFDepotConfiguration _ffDepotConfiguration;

}