/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.io.File;

import java.util.Comparator;

/**
 * @author Brian Wing Shun Chan
 */
public class FileComparator implements Comparator<File> {

	@Override
	public int compare(File file1, File file2) {
		String name1 = file1.getName();
		String name2 = file2.getName();

		return name1.compareTo(name2);
	}

}