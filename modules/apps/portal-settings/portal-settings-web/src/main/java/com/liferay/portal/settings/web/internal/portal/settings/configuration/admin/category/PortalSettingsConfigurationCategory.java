/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.web.internal.portal.settings.configuration.admin.category;

import com.liferay.configuration.admin.category.ConfigurationCategory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Drew Brokke
 */
@Component(service = ConfigurationCategory.class)
public class PortalSettingsConfigurationCategory
	implements ConfigurationCategory {

	@Override
	public String getBundleSymbolicName() {
		return "com.liferay.portal.settings.web";
	}

	@Override
	public String getCategoryKey() {
		return "instance-configuration";
	}

	@Override
	public String getCategorySection() {
		return "platform";
	}

}