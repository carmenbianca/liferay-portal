/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.internal;

import com.liferay.gradle.plugins.BasePortalToolDefaultsPlugin;
import com.liferay.gradle.plugins.tld.formatter.TLDFormatterPlugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public class TLDFormatterDefaultsPlugin
	extends BasePortalToolDefaultsPlugin<TLDFormatterPlugin> {

	public static final Plugin<Project> INSTANCE =
		new TLDFormatterDefaultsPlugin();

	@Override
	protected Class<TLDFormatterPlugin> getPluginClass() {
		return TLDFormatterPlugin.class;
	}

	@Override
	protected String getPortalToolConfigurationName() {
		return TLDFormatterPlugin.CONFIGURATION_NAME;
	}

	@Override
	protected String getPortalToolName() {
		return _PORTAL_TOOL_NAME;
	}

	private TLDFormatterDefaultsPlugin() {
	}

	private static final String _PORTAL_TOOL_NAME = "com.liferay.tld.formatter";

}