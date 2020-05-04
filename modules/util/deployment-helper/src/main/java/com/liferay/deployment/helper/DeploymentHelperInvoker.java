/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.deployment.helper;

import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;

/**
 * @author Andrea Di Giorgi
 */
public class DeploymentHelperInvoker {

	public static DeploymentHelper invoke(
			File baseDir, DeploymentHelperArgs deploymentHelperArgs)
		throws Exception {

		return new DeploymentHelper(
			_getAbsolutePaths(
				baseDir, deploymentHelperArgs.getDeploymentFileNames()),
			_getAbsolutePath(baseDir, deploymentHelperArgs.getDeploymentPath()),
			_getAbsolutePath(
				baseDir, deploymentHelperArgs.getOutputFileName()));
	}

	private static String _getAbsolutePath(File baseDir, String fileName) {
		File file = new File(baseDir, fileName);

		fileName = file.getAbsolutePath();

		return StringUtil.replace(fileName, '\\', '/');
	}

	private static String _getAbsolutePaths(File baseDir, String fileNames) {
		StringBuilder sb = new StringBuilder();

		for (String fileName : fileNames.split(",")) {
			sb.append(_getAbsolutePath(baseDir, fileName));
			sb.append(',');
		}

		sb.setLength(sb.length() - 1);

		return sb.toString();
	}

}