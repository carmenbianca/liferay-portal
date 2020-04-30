/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins;

import com.liferay.gradle.plugins.internal.util.GradleUtil;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public abstract class BaseDefaultsPlugin<T extends Plugin<? extends Project>>
	implements Plugin<Project> {

	@Override
	public void apply(final Project project) {
		GradleUtil.withPlugin(
			project, getPluginClass(),
			new Action<T>() {

				@Override
				public void execute(T plugin) {
					configureDefaults(project, plugin);
				}

			});
	}

	protected abstract void configureDefaults(Project project, T plugin);

	protected abstract Class<T> getPluginClass();

}