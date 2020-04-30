/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.tld.formatter;

import java.io.File;

/**
 * @author Andrea Di Giorgi
 */
public class TLDFormatterInvoker {

	public static TLDFormatter invoke(
			File baseDir, TLDFormatterArgs tldFormatterArgs)
		throws Exception {

		return new TLDFormatter(
			_getAbsolutePath(baseDir, tldFormatterArgs.getBaseDirName()),
			tldFormatterArgs.isPlugin());
	}

	private static String _getAbsolutePath(File baseDir, String fileName) {
		File file = new File(baseDir, fileName);

		return file.getAbsolutePath();
	}

}