/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.internal.settings.definition;

import com.liferay.layout.seo.internal.configuration.LayoutSEOCompanyConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Cristina González
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class LayoutSEOConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class getConfigurationBeanClass() {
		return LayoutSEOCompanyConfiguration.class;
	}

}