/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lpkg.deployer.controller;

import com.liferay.portal.lpkg.deployer.test.util.LPKGTestUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Matthew Tambara
 */
public class LPKGControllerTest {

	@Test
	public void testLPKGControllerDeploy() throws Exception {
		String liferayHome = System.getProperty("liferay.home");

		Assert.assertNotNull(
			"Missing system property \"liferay.home\"", liferayHome);

		Path path = Paths.get(
			liferayHome, "osgi/marketplace/Liferay Controller Test.lpkg");

		Files.createFile(path);

		LPKGTestUtil.createLPKG(path, _SYMBOLIC_NAME, true);
	}

	private static final String _SYMBOLIC_NAME = "lpkg.controller.test";

}