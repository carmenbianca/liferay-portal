/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
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
	protected void applyPluginDefaults(
		Project project, TLDFormatterPlugin tldFormatterPlugin) {

		addPortalToolDependencies(project);
	}

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