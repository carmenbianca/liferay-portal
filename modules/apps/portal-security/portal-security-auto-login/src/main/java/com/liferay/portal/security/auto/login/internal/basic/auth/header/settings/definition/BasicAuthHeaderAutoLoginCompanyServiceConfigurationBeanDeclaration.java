/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.auto.login.internal.basic.auth.header.settings.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import com.liferay.portal.security.auto.login.internal.basic.auth.header.configuration.BasicAuthHeaderAutoLoginConfiguration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Tomas Polesovsky
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class BasicAuthHeaderAutoLoginCompanyServiceConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return BasicAuthHeaderAutoLoginConfiguration.class;
	}

}