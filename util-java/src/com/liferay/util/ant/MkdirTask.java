/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util.ant;

import java.io.File;

import org.apache.tools.ant.taskdefs.Mkdir;

/**
 * @author Brian Wing Shun Chan
 */
public class MkdirTask {

	public static void mkdir(File dir) {
		Mkdir mkdir = new Mkdir();

		mkdir.setProject(AntUtil.getProject());
		mkdir.setDir(dir);

		mkdir.execute();
	}

	public static void mkdir(String dir) {
		mkdir(new File(dir));
	}

}