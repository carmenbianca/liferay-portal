/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.defaults;

import com.liferay.gradle.plugins.LiferayYarnPlugin;
import com.liferay.gradle.plugins.defaults.internal.LiferayCIPatcherPlugin;
import com.liferay.gradle.plugins.defaults.internal.LiferayCIPlugin;
import com.liferay.gradle.plugins.defaults.internal.NodeDefaultsPlugin;
import com.liferay.gradle.plugins.defaults.internal.util.GradleUtil;
import com.liferay.gradle.util.Validator;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Peter Shin
 */
public class LiferayYarnDefaultsPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		GradleUtil.applyPlugin(project, LiferayYarnPlugin.class);

		NodeDefaultsPlugin.INSTANCE.apply(project);

		if (_isRunningInCIEnvironment()) {
			LiferayCIPlugin.INSTANCE.apply(project);
		}

		if (_isRunningInCIPatcherEnvironment()) {
			LiferayCIPatcherPlugin.INSTANCE.apply(project);
		}
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