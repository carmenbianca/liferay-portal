/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auto.login.internal.request.header.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;
import com.liferay.portal.security.auto.login.internal.request.header.configuration.RequestHeaderAutoLoginConfiguration;
import com.liferay.portal.security.auto.login.internal.request.header.constants.RequestHeaderAutoLoginConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author Mika Koivisto
 */
@Component(service = ConfigurationPidMapping.class)
public class RequestHeaderAutoLoginCompanyServiceConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return RequestHeaderAutoLoginConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return RequestHeaderAutoLoginConstants.SERVICE_NAME;
	}

}