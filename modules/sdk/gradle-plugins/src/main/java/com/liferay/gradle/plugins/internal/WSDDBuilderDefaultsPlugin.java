/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.internal;

import com.liferay.gradle.plugins.BasePortalToolDefaultsPlugin;
import com.liferay.gradle.plugins.wsdd.builder.WSDDBuilderPlugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public class WSDDBuilderDefaultsPlugin
	extends BasePortalToolDefaultsPlugin<WSDDBuilderPlugin> {

	public static final Plugin<Project> INSTANCE =
		new WSDDBuilderDefaultsPlugin();

	@Override
	protected Class<WSDDBuilderPlugin> getPluginClass() {
		return WSDDBuilderPlugin.class;
	}

	@Override
	protected String getPortalToolConfigurationName() {
		return WSDDBuilderPlugin.CONFIGURATION_NAME;
	}

	@Override
	protected String getPortalToolName() {
		return _PORTAL_TOOL_NAME;
	}

	private WSDDBuilderDefaultsPlugin() {
	}

	private static final String _PORTAL_TOOL_NAME =
		"com.liferay.portal.tools.wsdd.builder";

}