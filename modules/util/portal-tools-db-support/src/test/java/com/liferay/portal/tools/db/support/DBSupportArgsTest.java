/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.db.support;

import java.io.File;

import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Andrea Di Giorgi
 */
public class DBSupportArgsTest {

	@Test
	public void testGet() throws Exception {
		DBSupportArgs dbSupportArgs = new DBSupportArgs();

		dbSupportArgs.setPassword(_CUSTOM_PASSWORD);
		dbSupportArgs.setUrl(_CUSTOM_URL);
		dbSupportArgs.setUserName(_CUSTOM_USER_NAME);

		Assert.assertEquals(_CUSTOM_PASSWORD, dbSupportArgs.getPassword());
		Assert.assertEquals(_CUSTOM_URL, dbSupportArgs.getUrl());
		Assert.assertEquals(_CUSTOM_USER_NAME, dbSupportArgs.getUserName());

		dbSupportArgs.setPropertiesFile(_getFile("portal-ext-one.properties"));

		Assert.assertEquals("password", dbSupportArgs.getPassword());
		Assert.assertEquals("url", dbSupportArgs.getUrl());
		Assert.assertEquals("user_name", dbSupportArgs.getUserName());

		dbSupportArgs.setPropertiesFile(_getFile("portal-ext-two.properties"));

		Assert.assertEquals(_CUSTOM_PASSWORD, dbSupportArgs.getPassword());
		Assert.assertEquals("url", dbSupportArgs.getUrl());
		Assert.assertEquals(_CUSTOM_USER_NAME, dbSupportArgs.getUserName());

		dbSupportArgs.setPropertiesFile(null);

		Assert.assertEquals(_CUSTOM_PASSWORD, dbSupportArgs.getPassword());
		Assert.assertEquals(_CUSTOM_URL, dbSupportArgs.getUrl());
		Assert.assertEquals(_CUSTOM_USER_NAME, dbSupportArgs.getUserName());
	}

	private static File _getFile(String fileName) throws URISyntaxException {
		URL url = DBSupportArgsTest.class.getResource(
			"dependencies/" + fileName);

		File file = new File(url.toURI());

		Assert.assertTrue(file.isFile());

		return file;
	}

	private static final String _CUSTOM_PASSWORD = "custom_password";

	private static final String _CUSTOM_URL = "custom_url";

	private static final String _CUSTOM_USER_NAME = "custom_user_name";

}