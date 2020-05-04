/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lpkg.deployer.persistence;

import com.liferay.portal.lpkg.deployer.test.util.LPKGTestUtil;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import org.osgi.framework.Version;

/**
 * @author Matthew Tambara
 */
public class LPKGPersistenceUpgradeTest {

	@Test
	public void testLPKGPersistenceUpgrade() throws Exception {
		String liferayHome = System.getProperty("liferay.home");

		Assert.assertNotNull(
			"Missing system property \"liferay.home\"", liferayHome);

		Path path = Paths.get(
			liferayHome, "osgi/marketplace/Liferay Persistence Test.lpkg");

		Files.delete(path);

		Files.createFile(path);

		Version version = new Version(2, 0, 0);

		LPKGTestUtil.createLPKG(path, _SYMBOLIC_NAME, false, version, version);
	}

	private static final String _SYMBOLIC_NAME = "lpkg.persistence.test";

}