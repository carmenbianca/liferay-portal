/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.internal.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;
import com.liferay.portal.security.sso.openid.configuration.OpenIdConfiguration;
import com.liferay.portal.security.sso.openid.constants.OpenIdConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author Mika Koivisto
 */
@Component(service = ConfigurationPidMapping.class)
public class OpenIdCompanyServiceConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return OpenIdConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return OpenIdConstants.SERVICE_NAME;
	}

}