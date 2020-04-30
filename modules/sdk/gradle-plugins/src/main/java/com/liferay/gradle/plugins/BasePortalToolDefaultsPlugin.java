/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins;

import com.liferay.gradle.plugins.internal.util.GradleUtil;
import com.liferay.gradle.plugins.util.PortalTools;
import com.liferay.gradle.util.Validator;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public abstract class BasePortalToolDefaultsPlugin
	<T extends Plugin<? extends Project>>
		extends BaseDefaultsPlugin<T> {

	protected void addPortalToolDependencies(Project project) {
		addPortalToolDependencies(
			project, getPortalToolConfigurationName(), getPortalToolName());
	}

	protected void addPortalToolDependencies(
		Project project, String configurationName, String portalToolName) {

		String portalToolVersion = PortalTools.getVersion(
			project, portalToolName);

		if (Validator.isNotNull(portalToolVersion)) {
			GradleUtil.addDependency(
				project, configurationName, getPortalToolGroup(),
				portalToolName, portalToolVersion);
		}
	}

	@Override
	protected void configureDefaults(Project project, T plugin) {
		addPortalToolDependencies(project);
	}

	protected abstract String getPortalToolConfigurationName();

	protected String getPortalToolGroup() {
		return PortalTools.GROUP;
	}

	protected abstract String getPortalToolName();

}