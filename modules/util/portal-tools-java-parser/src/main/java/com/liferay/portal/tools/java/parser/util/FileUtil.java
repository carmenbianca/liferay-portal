/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.java.parser.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author Hugo Huijser
 */
public class FileUtil {

	public static String read(File file) throws IOException {
		try {
			String s = FileUtils.readFileToString(file, StringPool.UTF8);

			return StringUtil.replace(
				s, StringPool.RETURN_NEW_LINE, StringPool.NEW_LINE);
		}
		catch (FileNotFoundException fileNotFoundException) {
			return null;
		}
	}

	public static void write(File file, String s) throws IOException {
		FileUtils.writeStringToFile(file, s, StringPool.UTF8);
	}

}