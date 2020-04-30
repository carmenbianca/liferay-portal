/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.defaults;

import com.liferay.gradle.plugins.SourceFormatterDefaultsPlugin;
import com.liferay.gradle.plugins.defaults.internal.util.FileUtil;
import com.liferay.gradle.plugins.defaults.internal.util.GradlePluginsDefaultsUtil;
import com.liferay.gradle.plugins.defaults.internal.util.GradleUtil;
import com.liferay.gradle.plugins.source.formatter.SourceFormatterPlugin;

import java.io.File;

import java.util.Map;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public class LiferayRootDefaultsPlugin implements Plugin<Project> {

	@Override
	public void apply(final Project project) {
		if (FileUtil.exists(project, "app.bnd")) {
			GradleUtil.applyPlugin(project, LiferayAppDefaultsPlugin.class);
		}

		GradleUtil.applyPlugin(project, SourceFormatterPlugin.class);
		SourceFormatterDefaultsPlugin.INSTANCE.apply(project);

		File portalRootDir = GradleUtil.getRootDir(
			project.getRootProject(), "portal-impl");

		GradlePluginsDefaultsUtil.configureRepositories(project, portalRootDir);

		for (Project subproject : project.getSubprojects()) {
			Map<String, Project> childProjects = subproject.getChildProjects();

			if (childProjects.isEmpty()) {
				GradleUtil.applyPlugin(subproject, LiferayDefaultsPlugin.class);
			}
		}

		if ((portalRootDir == null) && _hasYarnScriptFile(project)) {
			GradleUtil.applyPlugin(project, LiferayYarnDefaultsPlugin.class);
		}
	}

	private boolean _hasYarnScriptFile(Project project) {
		File projectDir = project.getProjectDir();

		File[] files = FileUtil.getFiles(projectDir, "yarn-", ".js");

		if ((files != null) && (files.length > 0)) {
			return true;
		}

		return false;
	}

}