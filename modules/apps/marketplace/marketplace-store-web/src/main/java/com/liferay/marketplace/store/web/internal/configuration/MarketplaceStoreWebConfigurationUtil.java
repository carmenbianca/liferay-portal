/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.store.web.internal.configuration;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;

/**
 * @author Joan Kim
 * @author Ryan Park
 */
public class MarketplaceStoreWebConfigurationUtil {

	public static String get(String key) {
		return _configuration.get(key);
	}

	private static final Configuration _configuration =
		ConfigurationFactoryUtil.getConfiguration(
			MarketplaceStoreWebConfigurationUtil.class.getClassLoader(),
			"portlet");

}