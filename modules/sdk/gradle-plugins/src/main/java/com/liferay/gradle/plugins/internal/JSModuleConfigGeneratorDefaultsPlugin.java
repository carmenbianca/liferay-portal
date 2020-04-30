/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.internal;

import com.liferay.gradle.plugins.BaseDefaultsPlugin;
import com.liferay.gradle.plugins.internal.util.GradleUtil;
import com.liferay.gradle.plugins.js.module.config.generator.ConfigJSModulesTask;
import com.liferay.gradle.plugins.js.module.config.generator.JSModuleConfigGeneratorExtension;
import com.liferay.gradle.plugins.js.module.config.generator.JSModuleConfigGeneratorPlugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public class JSModuleConfigGeneratorDefaultsPlugin
	extends BaseDefaultsPlugin<JSModuleConfigGeneratorPlugin> {

	public static final Plugin<Project> INSTANCE =
		new JSModuleConfigGeneratorDefaultsPlugin();

	@Override
	protected void configureDefaults(
		Project project,
		JSModuleConfigGeneratorPlugin jsModuleConfigGeneratorPlugin) {

		_configureJSModuleConfigGenerator(project);
		_configureTaskConfigJSModules(project);
	}

	@Override
	protected Class<JSModuleConfigGeneratorPlugin> getPluginClass() {
		return JSModuleConfigGeneratorPlugin.class;
	}

	private JSModuleConfigGeneratorDefaultsPlugin() {
	}

	private void _configureJSModuleConfigGenerator(final Project project) {
		JSModuleConfigGeneratorExtension jsModuleConfigGeneratorExtension =
			GradleUtil.getExtension(
				project, JSModuleConfigGeneratorExtension.class);

		String version = GradleUtil.getProperty(
			project, "nodejs.liferay.module.config.generator.version",
			_VERSION);

		jsModuleConfigGeneratorExtension.setVersion(version);
	}

	private void _configureTaskConfigJSModules(Project project) {
		ConfigJSModulesTask configJSModulesTask =
			(ConfigJSModulesTask)GradleUtil.getTask(
				project,
				JSModuleConfigGeneratorPlugin.CONFIG_JS_MODULES_TASK_NAME);

		configJSModulesTask.setConfigVariable("");
		configJSModulesTask.setIgnorePath(true);
		configJSModulesTask.setModuleExtension("");
		configJSModulesTask.setModuleFormat("/_/g,-");
	}

	private static final String _VERSION = "1.3.3";

}