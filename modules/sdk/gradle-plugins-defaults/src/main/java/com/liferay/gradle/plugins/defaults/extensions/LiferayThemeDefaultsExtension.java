/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.defaults.extensions;

import org.gradle.api.Project;

/**
 * @author Andrea Di Giorgi
 */
public class LiferayThemeDefaultsExtension {

	public LiferayThemeDefaultsExtension(Project project) {
	}

	public boolean isUseLocalDependencies() {
		return _useLocalDependencies;
	}

	public void setUseLocalDependencies(boolean useLocalDependencies) {
		_useLocalDependencies = useLocalDependencies;
	}

	private boolean _useLocalDependencies = true;

}