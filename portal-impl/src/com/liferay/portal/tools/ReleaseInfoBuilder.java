/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.FileImpl;

import java.io.File;

import java.text.DateFormat;

import java.util.Date;
import java.util.Properties;

/**
 * @author Brian Wing Shun Chan
 */
public class ReleaseInfoBuilder {

	public static void main(String[] args) {
		new ReleaseInfoBuilder();
	}

	public ReleaseInfoBuilder() {
		try {

			// Get version

			Properties releaseProps = _fileImpl.toProperties(
				"../release.properties");

			String version = releaseProps.getProperty("lp.version");

			File file = new File(
				"../portal-kernel/src/com/liferay/portal/kernel/util" +
					"/ReleaseInfo.java");

			String content = _fileImpl.read(file);

			int x = content.indexOf("String _VERSION = \"");

			x = content.indexOf("\"", x) + 1;

			int y = content.indexOf("\"", x);

			content = content.substring(0, x) + version + content.substring(y);

			// Get build

			x = content.indexOf("String _BUILD = \"");
			x = content.indexOf("\"", x) + 1;

			y = content.indexOf("\"", x);

			int build = GetterUtil.getInteger(content.substring(x, y)) + 1;

			content = content.substring(0, x) + build + content.substring(y);

			// Get date

			DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);

			String date = dateFormat.format(new Date());

			x = content.indexOf("String _DATE = \"");
			x = content.indexOf("\"", x) + 1;

			y = content.indexOf("\"", x);

			content = content.substring(0, x) + date + content.substring(y);

			// Update ReleaseInfo.java

			_fileImpl.write(file, content);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private static final FileImpl _fileImpl = FileImpl.getInstance();

}