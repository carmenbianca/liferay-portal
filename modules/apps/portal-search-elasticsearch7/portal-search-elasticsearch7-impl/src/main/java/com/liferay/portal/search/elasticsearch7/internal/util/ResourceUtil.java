/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.util;

import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

/**
 * @author Michael C. Han
 */
public class ResourceUtil {

	public static String getResourceAsString(
		Class<?> clazz, String resourceName) {

		try (InputStream inputStream = clazz.getResourceAsStream(
				resourceName)) {

			return StringUtil.read(inputStream);
		}
		catch (IOException ioException) {
			throw new RuntimeException(
				"Unable to load resource: " + resourceName, ioException);
		}
	}

	public static File getResourceAsTempFile(Class<?> clazz, String name)
		throws IOException {

		int index = name.lastIndexOf(CharPool.PERIOD);

		File file = File.createTempFile(
			name.substring(0, index), name.substring(index));

		file.deleteOnExit();

		try (InputStream inputStream = clazz.getResourceAsStream(name)) {
			FileUtils.copyInputStreamToFile(inputStream, file);
		}

		return file;
	}

}