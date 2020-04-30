/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.blogs.web.internal.configuration.definition;

import com.liferay.blogs.constants.BlogsPortletKeys;
import com.liferay.blogs.web.internal.configuration.BlogsPortletInstanceConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

import org.osgi.service.component.annotations.Component;

/**
 * @author Iván Zaera
 */
@Component(service = ConfigurationPidMapping.class)
public class BlogsAdminPortletInstanceConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return BlogsPortletInstanceConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return BlogsPortletKeys.BLOGS_ADMIN;
	}

}