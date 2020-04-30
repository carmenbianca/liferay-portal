/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.gradle.plugins.node.internal.util;

import java.io.File;

/**
 * @author Andrea Di Giorgi
 */
public class NodePluginUtil {

	public static File getBinDir(File nodeDir) {
		File binDir = new File(nodeDir, "bin");

		if (!binDir.exists()) {
			binDir = nodeDir;
		}

		return binDir;
	}

	public static File getNpmDir(File nodeDir) {
		File nodeModulesDir = new File(nodeDir, "node_modules");

		if (!nodeModulesDir.exists()) {
			nodeModulesDir = new File(nodeDir, "lib/node_modules");
		}

		return new File(nodeModulesDir, "npm");
	}

	public static File getYarnScriptFile(File projectDir) {
		File dir = projectDir;

		while (true) {
			File[] files = FileUtil.getFiles(dir, "yarn-", ".js");

			if ((files != null) && (files.length > 0)) {
				return files[0];
			}

			dir = dir.getParentFile();

			if (dir == null) {
				return null;
			}
		}
	}

}