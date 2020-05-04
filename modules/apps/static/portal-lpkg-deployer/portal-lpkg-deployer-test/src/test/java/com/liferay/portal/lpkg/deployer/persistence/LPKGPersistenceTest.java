/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lpkg.deployer.persistence;

import com.liferay.portal.lpkg.deployer.test.util.LPKGTestUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Matthew Tambara
 */
public class LPKGPersistenceTest {

	@Test
	public void testLPKGPersistenceDeploy() throws Exception {
		String liferayHome = System.getProperty("liferay.home");

		Assert.assertNotNull(
			"Missing system property \"liferay.home\"", liferayHome);

		Path path = Paths.get(
			liferayHome, "osgi/marketplace/Liferay Persistence Test.lpkg");

		Files.createFile(path);

		LPKGTestUtil.createLPKG(path, _SYMBOLIC_NAME, false);
	}

	private static final String _SYMBOLIC_NAME = "lpkg.persistence.test";

}