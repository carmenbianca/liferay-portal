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
import com.liferay.gradle.plugins.css.builder.BuildCSSTask;
import com.liferay.gradle.plugins.css.builder.CSSBuilderPlugin;
import com.liferay.gradle.plugins.internal.util.GradleUtil;
import com.liferay.gradle.util.Validator;

import java.io.File;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;

/**
 * @author Andrea Di Giorgi
 */
public class CSSBuilderDefaultsPlugin
	extends BasePortalToolDefaultsPlugin<CSSBuilderPlugin> {

	public static final Plugin<Project> INSTANCE =
		new CSSBuilderDefaultsPlugin();

	@Override
	protected void applyPluginDefaults(
		Project project, CSSBuilderPlugin cssBuilderPlugin) {

		addPortalToolDependencies(project);

		addPortalToolDependencies(
			project, CSSBuilderPlugin.PORTAL_COMMON_CSS_CONFIGURATION_NAME,
			_FRONTEND_COMMON_CSS_NAME);

		_configureTasksBuildCSS(project);
	}

	@Override
	protected Class<CSSBuilderPlugin> getPluginClass() {
		return CSSBuilderPlugin.class;
	}

	@Override
	protected String getPortalToolConfigurationName() {
		return CSSBuilderPlugin.CSS_BUILDER_CONFIGURATION_NAME;
	}

	@Override
	protected String getPortalToolName() {
		return _PORTAL_TOOL_NAME;
	}

	private CSSBuilderDefaultsPlugin() {
	}

	private void _configureTaskBuildCSS(BuildCSSTask buildCSSTask) {
		Project project = buildCSSTask.getProject();

		File docrootDir = project.file("docroot");

		if (docrootDir.exists()) {
			buildCSSTask.setBaseDir(docrootDir);
		}

		String generateSourceMap = GradleUtil.getProperty(
			project, "sass.generate.source.map", (String)null);

		if (Validator.isNotNull(generateSourceMap)) {
			buildCSSTask.setGenerateSourceMap(
				Boolean.parseBoolean(generateSourceMap));
		}

		String precision = GradleUtil.getProperty(
			project, "sass.precision", (String)null);

		if (Validator.isNotNull(precision)) {
			buildCSSTask.setPrecision(precision);
		}

		String sassCompilerClassName = GradleUtil.getProperty(
			project, "sass.compiler.class.name", (String)null);

		buildCSSTask.setSassCompilerClassName(sassCompilerClassName);
	}

	private void _configureTasksBuildCSS(Project project) {
		TaskContainer taskContainer = project.getTasks();

		taskContainer.withType(
			BuildCSSTask.class,
			new Action<BuildCSSTask>() {

				@Override
				public void execute(BuildCSSTask buildCSSTask) {
					_configureTaskBuildCSS(buildCSSTask);
				}

			});
	}

	private static final String _FRONTEND_COMMON_CSS_NAME =
		"com.liferay.frontend.css.common";

	private static final String _PORTAL_TOOL_NAME = "com.liferay.css.builder";

}