/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.defaults;

import com.liferay.gradle.plugins.LiferayPlugin;
import com.liferay.gradle.plugins.defaults.internal.JavaDefaultsPlugin;
import com.liferay.gradle.plugins.defaults.internal.LicenseReportDefaultsPlugin;
import com.liferay.gradle.plugins.defaults.internal.LiferayBaseDefaultsPlugin;
import com.liferay.gradle.plugins.defaults.internal.LiferayCIPatcherPlugin;
import com.liferay.gradle.plugins.defaults.internal.LiferayCIPlugin;
import com.liferay.gradle.plugins.defaults.internal.LiferayProfileDXPPlugin;
import com.liferay.gradle.plugins.defaults.internal.LiferayRelengPlugin;
import com.liferay.gradle.plugins.defaults.internal.MavenDefaultsPlugin;
import com.liferay.gradle.plugins.defaults.internal.NodeDefaultsPlugin;
import com.liferay.gradle.util.Validator;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public class LiferayDefaultsPlugin extends LiferayPlugin {

	@Override
	public void apply(Project project) {
		super.apply(project);

		if (Boolean.getBoolean("license.report.enabled")) {
			LicenseReportDefaultsPlugin.INSTANCE.apply(project);
		}

		JavaDefaultsPlugin.INSTANCE.apply(project);
		LiferayBaseDefaultsPlugin.INSTANCE.apply(project);
		LiferayRelengPlugin.INSTANCE.apply(project);
		MavenDefaultsPlugin.INSTANCE.apply(project);
		NodeDefaultsPlugin.INSTANCE.apply(project);

		String projectPath = project.getPath();

		if (projectPath.startsWith(":dxp:") && !_isRunningInCIEnvironment()) {
			LiferayProfileDXPPlugin.INSTANCE.apply(project);
		}

		if (_isRunningInCIEnvironment()) {
			LiferayCIPlugin.INSTANCE.apply(project);
		}

		if (_isRunningInCIPatcherEnvironment()) {
			LiferayCIPatcherPlugin.INSTANCE.apply(project);
		}
	}

	@Override
	protected Class<? extends Plugin<Project>> getAntPluginClass() {
		return LiferayAntDefaultsPlugin.class;
	}

	@Override
	protected Class<? extends Plugin<Project>> getOSGiPluginClass() {
		return LiferayOSGiDefaultsPlugin.class;
	}

	@Override
	protected Class<? extends Plugin<Project>> getThemePluginClass() {
		return LiferayThemeDefaultsPlugin.class;
	}

	private boolean _isRunningInCIEnvironment() {
		if (Validator.isNotNull(System.getenv("JENKINS_HOME"))) {
			return true;
		}

		return false;
	}

	private boolean _isRunningInCIPatcherEnvironment() {
		if (Validator.isNotNull(
				System.getenv("FIX_PACKS_RELEASE_ENVIRONMENT"))) {

			return true;
		}

		return false;
	}

}