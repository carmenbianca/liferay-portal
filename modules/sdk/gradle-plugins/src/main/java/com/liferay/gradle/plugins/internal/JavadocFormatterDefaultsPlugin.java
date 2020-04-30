/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.internal;

import com.liferay.gradle.plugins.BasePortalToolDefaultsPlugin;
import com.liferay.gradle.plugins.javadoc.formatter.JavadocFormatterPlugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public class JavadocFormatterDefaultsPlugin
	extends BasePortalToolDefaultsPlugin<JavadocFormatterPlugin> {

	public static final Plugin<Project> INSTANCE =
		new JavadocFormatterDefaultsPlugin();

	@Override
	protected Class<JavadocFormatterPlugin> getPluginClass() {
		return JavadocFormatterPlugin.class;
	}

	@Override
	protected String getPortalToolConfigurationName() {
		return JavadocFormatterPlugin.CONFIGURATION_NAME;
	}

	@Override
	protected String getPortalToolName() {
		return _PORTAL_TOOL_NAME;
	}

	private JavadocFormatterDefaultsPlugin() {
	}

	private static final String _PORTAL_TOOL_NAME =
		"com.liferay.javadoc.formatter";

}