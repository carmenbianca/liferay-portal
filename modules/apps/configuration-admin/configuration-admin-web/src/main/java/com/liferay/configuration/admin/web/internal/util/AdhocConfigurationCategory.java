/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.configuration.admin.web.internal.util;

import com.liferay.configuration.admin.category.ConfigurationCategory;

/**
 * @author Jorge Ferrer
 */
public class AdhocConfigurationCategory implements ConfigurationCategory {

	public AdhocConfigurationCategory(String key) {
		_key = key;
	}

	@Override
	public String getCategoryKey() {
		return _key;
	}

	@Override
	public String getCategorySection() {
		return "other";
	}

	private final String _key;

}