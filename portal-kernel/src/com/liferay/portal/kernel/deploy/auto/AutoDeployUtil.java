/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.deploy.auto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivica Cardic
 * @author Brian Wing Shun Chan
 * @author Raymond Augé
 */
public class AutoDeployUtil {

	public static AutoDeployDir getDir(String name) {
		return getInstance()._getDir(name);
	}

	public static AutoDeployUtil getInstance() {
		return _autoDeployUtil;
	}

	public static void registerDir(AutoDeployDir autoDeployDir) {
		getInstance()._registerDir(autoDeployDir);
	}

	public static void unregisterDir(String name) {
		getInstance()._unregisterDir(name);
	}

	private AutoDeployUtil() {
		_autoDeployDirs = new HashMap<>();
	}

	private AutoDeployDir _getDir(String name) {
		return _autoDeployDirs.get(name);
	}

	private void _registerDir(AutoDeployDir autoDeployDir) {
		_autoDeployDirs.put(autoDeployDir.getName(), autoDeployDir);

		autoDeployDir.start();
	}

	private void _unregisterDir(String name) {
		AutoDeployDir autoDeployDir = _autoDeployDirs.remove(name);

		if (autoDeployDir != null) {
			autoDeployDir.stop();
		}
	}

	private static final AutoDeployUtil _autoDeployUtil = new AutoDeployUtil();

	private final Map<String, AutoDeployDir> _autoDeployDirs;

}