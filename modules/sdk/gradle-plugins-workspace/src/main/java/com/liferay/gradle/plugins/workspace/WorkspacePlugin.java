/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.workspace;

import com.liferay.gradle.plugins.util.PortalTools;
import com.liferay.gradle.plugins.workspace.internal.util.GradleUtil;
import com.liferay.gradle.util.Validator;

import groovy.lang.Closure;

import java.io.File;

import java.util.HashMap;
import java.util.Map;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.initialization.Settings;
import org.gradle.api.invocation.Gradle;
import org.gradle.api.plugins.ExtensionAware;
import org.gradle.api.plugins.ExtensionContainer;

/**
 * @author David Truong
 * @author Andrea Di Giorgi
 */
public class WorkspacePlugin implements Plugin<Settings> {

	public static final String EXTENSION_NAME = "liferayWorkspace";

	public static final String PROPERTY_PREFIX = "liferay.workspace.";

	@Override
	@SuppressWarnings("serial")
	public void apply(Settings settings) {
		Gradle gradle = settings.getGradle();

		final WorkspaceExtension workspaceExtension = _addWorkspaceExtension(
			settings);

		for (ProjectConfigurator projectConfigurator :
				workspaceExtension.getProjectConfigurators()) {

			for (File rootDir : projectConfigurator.getDefaultRootDirs()) {
				for (File projectDir :
						projectConfigurator.getProjectDirs(rootDir)) {

					String projectPath = GradleUtil.getProjectPath(
						projectDir, settings.getRootDir());

					settings.include(new String[] {projectPath});

					_projectConfiguratorsMap.put(
						projectPath, projectConfigurator);
				}
			}
		}

		gradle.beforeProject(
			new Closure<Void>(settings) {

				@SuppressWarnings("unused")
				public void doCall(Project project) {
					_setPortalVersion(project, workspaceExtension);

					Plugin<Project> plugin = null;

					if (project.getParent() == null) {
						for (ProjectConfigurator projectConfigurator :
								workspaceExtension.getProjectConfigurators()) {

							projectConfigurator.configureRootProject(
								project, workspaceExtension);
						}

						plugin =
							workspaceExtension.getRootProjectConfigurator();
					}
					else {
						plugin = _projectConfiguratorsMap.get(
							project.getPath());
					}

					if (plugin != null) {
						plugin.apply(project);
					}
				}

			});
	}

	private WorkspaceExtension _addWorkspaceExtension(Settings settings) {
		ExtensionAware extensionAware = (ExtensionAware)settings.getGradle();

		ExtensionContainer extensionContainer = extensionAware.getExtensions();

		return extensionContainer.create(
			EXTENSION_NAME, WorkspaceExtension.class, settings);
	}

	private void _setPortalVersion(
		Project project, WorkspaceExtension workspaceExtension) {

		String portalVersion = GradleUtil.getProperty(
			project, PortalTools.PORTAL_VERSION_PROPERTY_NAME, (String)null);

		if (Validator.isNotNull(portalVersion)) {
			return;
		}

		String bundleUrl = workspaceExtension.getBundleUrl();

		if (bundleUrl.contains("7.0.")) {
			GradleUtil.setProperty(project, "portal.version", "7.0.x");
		}
	}

	private static final Map<String, ProjectConfigurator>
		_projectConfiguratorsMap = new HashMap<>();

}