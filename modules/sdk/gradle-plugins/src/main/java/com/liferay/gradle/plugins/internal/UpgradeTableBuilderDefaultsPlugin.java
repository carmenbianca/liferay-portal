/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.internal;

import com.liferay.gradle.plugins.BasePortalToolDefaultsPlugin;
import com.liferay.gradle.plugins.internal.util.GradleUtil;
import com.liferay.gradle.plugins.upgrade.table.builder.BuildUpgradeTableTask;
import com.liferay.gradle.plugins.upgrade.table.builder.UpgradeTableBuilderPlugin;

import java.io.File;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;

/**
 * @author Andrea Di Giorgi
 */
public class UpgradeTableBuilderDefaultsPlugin
	extends BasePortalToolDefaultsPlugin<UpgradeTableBuilderPlugin> {

	public static final Plugin<Project> INSTANCE =
		new UpgradeTableBuilderDefaultsPlugin();

	@Override
	protected void configureDefaults(
		Project project, UpgradeTableBuilderPlugin upgradeTableBuilderPlugin) {

		super.configureDefaults(project, upgradeTableBuilderPlugin);

		_configureTasksBuildUpgradeTable(project);
	}

	@Override
	protected Class<UpgradeTableBuilderPlugin> getPluginClass() {
		return UpgradeTableBuilderPlugin.class;
	}

	@Override
	protected String getPortalToolConfigurationName() {
		return UpgradeTableBuilderPlugin.CONFIGURATION_NAME;
	}

	@Override
	protected String getPortalToolName() {
		return _PORTAL_TOOL_NAME;
	}

	private UpgradeTableBuilderDefaultsPlugin() {
	}

	private void _configureTaskBuildUpgradeTable(
		BuildUpgradeTableTask buildUpgradeTableTask) {

		File file = GradleUtil.getProperty(
			buildUpgradeTableTask.getProject(), "upgrade.table.dir",
			(File)null);

		buildUpgradeTableTask.setUpgradeTableDir(file);
	}

	private void _configureTasksBuildUpgradeTable(Project project) {
		TaskContainer taskContainer = project.getTasks();

		taskContainer.withType(
			BuildUpgradeTableTask.class,
			new Action<BuildUpgradeTableTask>() {

				@Override
				public void execute(
					BuildUpgradeTableTask buildUpgradeTableTask) {

					_configureTaskBuildUpgradeTable(buildUpgradeTableTask);
				}

			});
	}

	private static final String _PORTAL_TOOL_NAME =
		"com.liferay.portal.tools.upgrade.table.builder";

}