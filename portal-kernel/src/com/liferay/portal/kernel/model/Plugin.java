/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.model;

import com.liferay.portal.kernel.plugin.PluginPackage;

/**
 * @author Jorge Ferrer
 */
public interface Plugin {

	public static final String TYPE_HOOK = "hook";

	public static final String TYPE_LAYOUT_TEMPLATE = "layouttpl";

	public static final String TYPE_PORTLET = "portlet";

	public static final String TYPE_THEME = "theme";

	public static final String TYPE_WEB = "web";

	public PluginSetting getDefaultPluginSetting();

	public PluginSetting getDefaultPluginSetting(long companyId);

	public String getPluginId();

	public PluginPackage getPluginPackage();

	public String getPluginType();

	public void setDefaultPluginSetting(PluginSetting pluginSetting);

	public void setPluginPackage(PluginPackage pluginPackage);

}