/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.workspace.configurators;

import com.liferay.gradle.plugins.LiferayBasePlugin;
import com.liferay.gradle.plugins.workspace.ProjectConfigurator;
import com.liferay.gradle.plugins.workspace.WorkspaceExtension;
import com.liferay.gradle.plugins.workspace.WorkspacePlugin;
import com.liferay.gradle.plugins.workspace.internal.util.GradleUtil;
import com.liferay.gradle.util.Validator;

import java.io.File;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import org.gradle.api.GradleException;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.initialization.Settings;
import org.gradle.api.tasks.Copy;

/**
 * @author Andrea Di Giorgi
 */
public abstract class BaseProjectConfigurator implements ProjectConfigurator {

	public BaseProjectConfigurator(Settings settings) {
		String defaultRootDirNames = GradleUtil.getProperty(
			settings, getDefaultRootDirPropertyName(), (String)null);

		if (Validator.isNotNull(defaultRootDirNames)) {
			_defaultRootDirs = new HashSet<>();

			for (String dirName : defaultRootDirNames.split("\\s*,\\s*")) {
				File dir = new File(settings.getRootDir(), dirName);

				_defaultRootDirs.add(dir);
			}
		}
		else {
			File dir = new File(settings.getRootDir(), getDefaultRootDirName());

			_defaultRootDirs = Collections.singleton(dir);
		}
	}

	@Override
	public void configureRootProject(
		Project project, WorkspaceExtension workspaceExtension) {
	}

	@Override
	public Iterable<File> getDefaultRootDirs() {
		return _defaultRootDirs;
	}

	@Override
	public Iterable<File> getProjectDirs(File rootDir) {
		try {
			if (!rootDir.exists()) {
				return Collections.emptySet();
			}

			return doGetProjectDirs(rootDir);
		}
		catch (Exception exception) {
			throw new GradleException(
				"Unable to get project directories from " + rootDir, exception);
		}
	}

	protected Copy addTaskDockerDeploy(
		Project project, Object sourcePath,
		WorkspaceExtension workspaceExtension) {

		Copy copy = GradleUtil.addTask(
			project, RootProjectConfigurator.DOCKER_DEPLOY_TASK_NAME,
			Copy.class);

		copy.from(sourcePath);

		final File dockerDir = workspaceExtension.getDockerDir();

		copy.into(
			new Callable<File>() {

				@Override
				public File call() throws Exception {
					return new File(dockerDir, "deploy");
				}

			});

		copy.setDescription(
			"Assembles the project and deploys it to the Liferay Docker " +
				"container.");

		copy.setGroup(RootProjectConfigurator.DOCKER_GROUP);

		Task deployTask = GradleUtil.getTask(
			project, LiferayBasePlugin.DEPLOY_TASK_NAME);

		deployTask.finalizedBy(copy);

		Task buildDockerImageTask = GradleUtil.getTask(
			project.getRootProject(),
			RootProjectConfigurator.BUILD_DOCKER_IMAGE_TASK_NAME);

		buildDockerImageTask.dependsOn(deployTask);

		return copy;
	}

	protected abstract Iterable<File> doGetProjectDirs(File rootDir)
		throws Exception;

	protected String getDefaultRootDirName() {
		return getName();
	}

	protected String getDefaultRootDirPropertyName() {
		return WorkspacePlugin.PROPERTY_PREFIX + getName() + ".dir";
	}

	private final Set<File> _defaultRootDirs;

}