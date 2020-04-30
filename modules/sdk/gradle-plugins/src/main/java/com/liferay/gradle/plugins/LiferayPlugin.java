/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins;

import com.liferay.gradle.plugins.internal.util.FileUtil;
import com.liferay.gradle.plugins.internal.util.GradleUtil;

import java.io.File;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.UncheckedIOException;
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.plugins.JavaPluginExtension;

/**
 * @author Andrea Di Giorgi
 */
public class LiferayPlugin implements Plugin<Project> {

	public static final String PLUGIN_NAME = "liferay";

	@Override
	public void apply(Project project) {
		Class<? extends Plugin<Project>> clazz;

		if (_isAnt(project)) {
			clazz = getAntPluginClass();
		}
		else if (_isOSGi(project)) {
			clazz = getOSGiPluginClass();
		}
		else if (_isTheme(project)) {
			clazz = getThemePluginClass();
		}
		else {
			clazz = getBasePluginClass();
		}

		GradleUtil.applyPlugin(project, clazz);

		GradleUtil.withPlugin(
			project, JavaPlugin.class,
			new Action<JavaPlugin>() {

				@Override
				public void execute(JavaPlugin javaPlugin) {
					_configureJavaExtension(project);
				}

			});
	}

	protected Class<? extends Plugin<Project>> getAntPluginClass() {
		return LiferayAntPlugin.class;
	}

	protected Class<? extends Plugin<Project>> getBasePluginClass() {
		return LiferayBasePlugin.class;
	}

	protected Class<? extends Plugin<Project>> getOSGiPluginClass() {
		return LiferayOSGiPlugin.class;
	}

	protected Class<? extends Plugin<Project>> getThemePluginClass() {
		return LiferayThemePlugin.class;
	}

	private void _configureJavaExtension(Project project) {
		JavaPluginExtension javaPluginExtension = GradleUtil.getExtension(
			project, JavaPluginExtension.class);

		javaPluginExtension.disableAutoTargetJvm();
	}

	private boolean _isAnt(Project project) {
		if (FileUtil.exists(project, "build.xml")) {
			return true;
		}

		return false;
	}

	private boolean _isOSGi(Project project) {
		if (FileUtil.exists(project, "bnd.bnd")) {
			return true;
		}

		return false;
	}

	private boolean _isTheme(Project project) {
		File gulpFile = project.file("gulpfile.js");

		if (!gulpFile.exists()) {
			return false;
		}

		String gulpFileContent;

		try {
			gulpFileContent = new String(
				Files.readAllBytes(gulpFile.toPath()), StandardCharsets.UTF_8);
		}
		catch (IOException ioException) {
			throw new UncheckedIOException(ioException);
		}

		if (gulpFileContent.contains("require('liferay-theme-tasks')")) {
			return true;
		}

		return false;
	}

}