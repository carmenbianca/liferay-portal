/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.modules.util;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;

/**
 * @author Andrea Di Giorgi
 */
public class GradleDependency {

	public GradleDependency(
		String dependency, String configuration, String moduleGroup,
		String moduleName, String moduleVersion, boolean projectDependency) {

		_dependency = dependency;
		_configuration = configuration;
		_moduleGroup = moduleGroup;
		_moduleName = moduleName;

		if (moduleVersion.equals(_VERSION_DEFAULT)) {
			StringBundler sb = new StringBundler(5);

			sb.append(Integer.MAX_VALUE);
			sb.append(StringPool.PERIOD);
			sb.append(Integer.MAX_VALUE);
			sb.append(StringPool.PERIOD);
			sb.append(Integer.MAX_VALUE);

			_moduleVersion = sb.toString();

			_projectDependency = true;
		}
		else {
			_moduleVersion = moduleVersion;
			_projectDependency = projectDependency;
		}
	}

	public String getConfiguration() {
		return _configuration;
	}

	public String getModuleGroup() {
		return _moduleGroup;
	}

	public String getModuleName() {
		return _moduleName;
	}

	public String getModuleVersion() {
		return _moduleVersion;
	}

	public boolean isProjectDependency() {
		return _projectDependency;
	}

	@Override
	public String toString() {
		return _dependency;
	}

	private static final String _VERSION_DEFAULT = "default";

	private final String _configuration;
	private final String _dependency;
	private final String _moduleGroup;
	private final String _moduleName;
	private final String _moduleVersion;
	private final boolean _projectDependency;

}