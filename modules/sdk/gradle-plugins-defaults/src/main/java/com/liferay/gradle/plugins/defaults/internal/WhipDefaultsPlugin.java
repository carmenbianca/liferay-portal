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

package com.liferay.gradle.plugins.defaults.internal;

import com.liferay.gradle.plugins.BasePortalToolDefaultsPlugin;
import com.liferay.gradle.plugins.defaults.internal.util.GradleUtil;
import com.liferay.gradle.plugins.util.PortalTools;
import com.liferay.gradle.plugins.whip.WhipExtension;
import com.liferay.gradle.plugins.whip.WhipPlugin;
import com.liferay.gradle.plugins.whip.WhipTaskExtension;
import com.liferay.gradle.util.Validator;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;
import org.gradle.api.tasks.testing.Test;

/**
 * @author Andrea Di Giorgi
 */
public class WhipDefaultsPlugin
	extends BasePortalToolDefaultsPlugin<WhipPlugin> {

	public static final Plugin<Project> INSTANCE = new WhipDefaultsPlugin();

	@Override
	protected void addPortalToolDependencies(Project project) {
		WhipExtension whipExtension = GradleUtil.getExtension(
			project, WhipExtension.class);

		String version = PortalTools.getVersion(project, getPortalToolName());

		if (Validator.isNotNull(version)) {
			whipExtension.setVersion(version);
		}
	}

	@Override
	protected void applyPluginDefaults(Project project, WhipPlugin whipPlugin) {
		addPortalToolDependencies(project);

		_configureTasksTest(project);
	}

	@Override
	protected Class<WhipPlugin> getPluginClass() {
		return WhipPlugin.class;
	}

	@Override
	protected String getPortalToolConfigurationName() {
		return WhipPlugin.CONFIGURATION_NAME;
	}

	@Override
	protected String getPortalToolName() {
		return _PORTAL_TOOL_NAME;
	}

	private WhipDefaultsPlugin() {
	}

	private void _configureTasksTest(Project project) {
		TaskContainer taskContainer = project.getTasks();

		taskContainer.withType(
			Test.class,
			new Action<Test>() {

				@Override
				public void execute(Test test) {
					_configureTaskTest(test);
				}

			});
	}

	private void _configureTaskTest(Test test) {
		WhipTaskExtension whipTaskExtension = GradleUtil.getExtension(
			test, WhipTaskExtension.class);

		whipTaskExtension.excludes(
			".*Test", ".*Test\\$.*", ".*\\$Proxy.*", "com/liferay/whip/.*");
		whipTaskExtension.includes("com/liferay/.*");
	}

	private static final String _PORTAL_TOOL_NAME = "com.liferay.whip";

}