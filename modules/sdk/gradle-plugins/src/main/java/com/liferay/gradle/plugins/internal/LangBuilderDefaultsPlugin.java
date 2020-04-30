/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.internal;

import com.liferay.gradle.plugins.BasePortalToolDefaultsPlugin;
import com.liferay.gradle.plugins.internal.util.GradleUtil;
import com.liferay.gradle.plugins.lang.builder.BuildLangTask;
import com.liferay.gradle.plugins.lang.builder.LangBuilderPlugin;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskContainer;

/**
 * @author Andrea Di Giorgi
 */
public class LangBuilderDefaultsPlugin
	extends BasePortalToolDefaultsPlugin<LangBuilderPlugin> {

	public static final Plugin<Project> INSTANCE =
		new LangBuilderDefaultsPlugin();

	@Override
	protected void configureDefaults(
		Project project, LangBuilderPlugin langBuilderPlugin) {

		super.configureDefaults(project, langBuilderPlugin);

		_configureTasksBuildLang(project);
	}

	@Override
	protected Class<LangBuilderPlugin> getPluginClass() {
		return LangBuilderPlugin.class;
	}

	@Override
	protected String getPortalToolConfigurationName() {
		return LangBuilderPlugin.CONFIGURATION_NAME;
	}

	@Override
	protected String getPortalToolName() {
		return _PORTAL_TOOL_NAME;
	}

	private LangBuilderDefaultsPlugin() {
	}

	private void _configureTaskBuildLang(BuildLangTask buildLangTask) {
		String translateSubscriptionKey = GradleUtil.getProperty(
			buildLangTask.getProject(), "microsoft.translator.subscription.key",
			(String)null);

		buildLangTask.setTranslateSubscriptionKey(translateSubscriptionKey);
	}

	private void _configureTasksBuildLang(Project project) {
		TaskContainer taskContainer = project.getTasks();

		taskContainer.withType(
			BuildLangTask.class,
			new Action<BuildLangTask>() {

				@Override
				public void execute(BuildLangTask buildLangTask) {
					_configureTaskBuildLang(buildLangTask);
				}

			});
	}

	private static final String _PORTAL_TOOL_NAME = "com.liferay.lang.builder";

}