/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.browser.web.internal.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Eudaldo Alonso
 */
public class AssetBrowserWebConfigurationValues {

	public static final boolean SEARCH_WITH_DATABASE = GetterUtil.getBoolean(
		AssetBrowserWebConfigurationUtil.get("search.with.database"));

}