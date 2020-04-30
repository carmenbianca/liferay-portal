/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
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
	protected void configureDefaults(Project project, WhipPlugin whipPlugin) {
		super.configureDefaults(project, whipPlugin);

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