/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.configuration.web.internal.settings.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import com.liferay.portlet.configuration.web.internal.configuration.RoleVisibilityConfiguration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Peter Petrekanics
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class RoleVisibilityConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return RoleVisibilityConfiguration.class;
	}

}