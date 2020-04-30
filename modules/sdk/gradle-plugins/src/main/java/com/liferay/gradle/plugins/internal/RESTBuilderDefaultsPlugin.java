/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.internal;

import com.liferay.gradle.plugins.BasePortalToolDefaultsPlugin;
import com.liferay.gradle.plugins.internal.util.GradleUtil;
import com.liferay.gradle.plugins.rest.builder.BuildRESTTask;
import com.liferay.gradle.plugins.rest.builder.RESTBuilderPlugin;

import groovy.lang.Closure;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.file.CopySpec;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.tasks.Copy;

/**
 * @author Peter Shin
 */
public class RESTBuilderDefaultsPlugin
	extends BasePortalToolDefaultsPlugin<RESTBuilderPlugin> {

	public static final Plugin<Project> INSTANCE =
		new RESTBuilderDefaultsPlugin();

	@Override
	protected void configureDefaults(
		final Project project, RESTBuilderPlugin restBuilderPlugin) {

		super.configureDefaults(project, restBuilderPlugin);

		BuildRESTTask buildRESTTask = (BuildRESTTask)GradleUtil.getTask(
			project, RESTBuilderPlugin.BUILD_REST_TASK_NAME);

		_configureTaskProcessResources(buildRESTTask);
	}

	@Override
	protected Class<RESTBuilderPlugin> getPluginClass() {
		return RESTBuilderPlugin.class;
	}

	@Override
	protected String getPortalToolConfigurationName() {
		return RESTBuilderPlugin.CONFIGURATION_NAME;
	}

	@Override
	protected String getPortalToolName() {
		return _PORTAL_TOOL_NAME;
	}

	private RESTBuilderDefaultsPlugin() {
	}

	@SuppressWarnings("serial")
	private void _configureTaskProcessResources(BuildRESTTask buildRESTTask) {
		final Project project = buildRESTTask.getProject();

		Copy copy = (Copy)GradleUtil.getTask(
			project, JavaPlugin.PROCESS_RESOURCES_TASK_NAME);

		copy.into(
			"META-INF/liferay/rest",
			new Closure<Void>(copy) {

				@SuppressWarnings("unused")
				public void doCall(CopySpec copySpec) {
					copySpec.from(project.getProjectDir());
					copySpec.include("*.yaml");
				}

			});
	}

	private static final String _PORTAL_TOOL_NAME =
		"com.liferay.portal.tools.rest.builder";

}