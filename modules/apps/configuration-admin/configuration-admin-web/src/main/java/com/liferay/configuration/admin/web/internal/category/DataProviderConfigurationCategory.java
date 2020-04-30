/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.configuration.admin.web.internal.category;

import com.liferay.configuration.admin.category.ConfigurationCategory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Yuxing Wu
 */
@Component(service = ConfigurationCategory.class)
public class DataProviderConfigurationCategory
	implements ConfigurationCategory {

	@Override
	public String getCategoryKey() {
		return "data-providers";
	}

	@Override
	public String getCategorySection() {
		return "content-and-data";
	}

}