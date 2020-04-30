/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.data.partitioning.sql.builder.internal.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

/**
 * @author Manuel de la Peña
 */
public class PropsReader {

	public static Properties read(String fileName) throws IOException {
		try (InputStream inputStream = new FileInputStream(fileName)) {
			Properties properties = new Properties();

			properties.load(inputStream);

			return properties;
		}
	}

}