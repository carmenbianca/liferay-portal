/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.upgrade.table.builder;

import java.io.File;

/**
 * @author Andrea Di Giorgi
 */
public class UpgradeTableBuilderInvoker {

	public static UpgradeTableBuilder invoke(
			File baseDir, UpgradeTableBuilderArgs upgradeTableBuilderArgs)
		throws Exception {

		return new UpgradeTableBuilder(
			_getAbsolutePath(baseDir, upgradeTableBuilderArgs.getBaseDirName()),
			upgradeTableBuilderArgs.isOsgiModule(),
			upgradeTableBuilderArgs.getReleaseInfoVersion(),
			_getAbsolutePath(
				baseDir, upgradeTableBuilderArgs.getUpgradeTableDirName()));
	}

	private static String _getAbsolutePath(File baseDir, String fileName) {
		if ((fileName == null) || fileName.isEmpty()) {
			return null;
		}

		File file = new File(baseDir, fileName);

		return file.getAbsolutePath();
	}

}