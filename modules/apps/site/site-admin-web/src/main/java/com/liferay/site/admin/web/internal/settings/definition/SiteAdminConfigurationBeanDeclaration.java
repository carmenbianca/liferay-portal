/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.admin.web.internal.settings.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import com.liferay.site.admin.web.internal.configuration.SiteAdminConfiguration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Vendel Töreki
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class SiteAdminConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return SiteAdminConfiguration.class;
	}

}