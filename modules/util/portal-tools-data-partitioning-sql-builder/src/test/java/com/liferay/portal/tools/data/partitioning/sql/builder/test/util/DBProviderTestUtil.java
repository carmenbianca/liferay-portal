/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.data.partitioning.sql.builder.test.util;

import com.liferay.portal.tools.data.partitioning.sql.builder.internal.util.PropsReader;

import java.io.IOException;

import java.net.URL;

import java.util.Properties;

import org.junit.Assume;

/**
 * @author Manuel de la Peña
 */
public class DBProviderTestUtil {

	public static Properties readProperties(String propertiesFileName)
		throws IOException {

		URL url = DBProviderTestUtil.class.getResource(
			"/" + propertiesFileName + ".properties");

		Assume.assumeNotNull(url);

		return PropsReader.read(url.getFile());
	}

}