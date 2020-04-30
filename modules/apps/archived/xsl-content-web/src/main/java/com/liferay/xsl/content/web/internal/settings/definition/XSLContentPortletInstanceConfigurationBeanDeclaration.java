/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.xsl.content.web.internal.settings.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;
import com.liferay.xsl.content.web.internal.configuration.XSLContentPortletInstanceConfiguration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Juergen Kappler
 */
@Component(service = ConfigurationBeanDeclaration.class)
public class XSLContentPortletInstanceConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return XSLContentPortletInstanceConfiguration.class;
	}

}