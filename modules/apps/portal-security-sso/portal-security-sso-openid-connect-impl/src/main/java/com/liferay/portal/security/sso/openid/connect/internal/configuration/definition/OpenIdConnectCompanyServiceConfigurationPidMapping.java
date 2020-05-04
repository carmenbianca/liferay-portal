/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.connect.internal.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;
import com.liferay.portal.security.sso.openid.connect.configuration.OpenIdConnectConfiguration;
import com.liferay.portal.security.sso.openid.connect.constants.OpenIdConnectConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = ConfigurationPidMapping.class)
public class OpenIdConnectCompanyServiceConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return OpenIdConnectConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return OpenIdConnectConstants.SERVICE_NAME;
	}

}