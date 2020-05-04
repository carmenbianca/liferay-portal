/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.sso.openid.internal.settings.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import com.liferay.portal.security.sso.openid.configuration.OpenIdConfiguration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Mika Koivisto
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class OpenIdCompanyServiceConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return OpenIdConfiguration.class;
	}

}