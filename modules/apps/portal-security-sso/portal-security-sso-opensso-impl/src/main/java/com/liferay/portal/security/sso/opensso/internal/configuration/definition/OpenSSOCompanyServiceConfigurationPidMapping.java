/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.opensso.internal.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;
import com.liferay.portal.security.sso.opensso.configuration.OpenSSOConfiguration;
import com.liferay.portal.security.sso.opensso.constants.OpenSSOConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author Mika Koivisto
 */
@Component(service = ConfigurationPidMapping.class)
public class OpenSSOCompanyServiceConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return OpenSSOConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return OpenSSOConstants.SERVICE_NAME;
	}

}