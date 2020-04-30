/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.upgrade.util;

import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedWriter;
import com.liferay.portal.kernel.util.FileUtil;

import java.io.FileWriter;

import java.util.Iterator;

/**
 * @author Brian Wing Shun Chan
 */
public class ValueMapperUtil {

	public static void persist(
			ValueMapper valueMapper, String tmpDir, String fileName)
		throws Exception {

		FileUtil.mkdirs(tmpDir);

		try (UnsyncBufferedWriter unsyncBufferedWriter =
				new UnsyncBufferedWriter(
					new FileWriter(
						StringBundler.concat(tmpDir, "/", fileName, ".txt")))) {

			Iterator<Object> itr = valueMapper.iterator();

			while (itr.hasNext()) {
				Object oldValue = itr.next();

				Object newValue = valueMapper.getNewValue(oldValue);

				unsyncBufferedWriter.write(
					oldValue + StringPool.EQUAL + newValue);

				if (itr.hasNext()) {
					unsyncBufferedWriter.write(StringPool.NEW_LINE);
				}
			}
		}
	}

}