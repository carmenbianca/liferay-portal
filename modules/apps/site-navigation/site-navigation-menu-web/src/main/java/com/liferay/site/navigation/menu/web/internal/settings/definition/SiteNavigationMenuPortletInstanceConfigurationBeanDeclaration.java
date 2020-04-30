/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.menu.web.internal.settings.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import com.liferay.site.navigation.menu.web.internal.configuration.SiteNavigationMenuPortletInstanceConfiguration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Juergen Kappler
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class SiteNavigationMenuPortletInstanceConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return SiteNavigationMenuPortletInstanceConfiguration.class;
	}

}