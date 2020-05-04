/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.lpkg.deployer.container;

import com.liferay.portal.lpkg.deployer.test.util.LPKGTestUtil;

import java.io.OutputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Matthew Tambara
 */
public class LPKGContainerTest {

	@Test
	public void testLPKGContainerDeploy() throws Exception {
		String liferayHome = System.getProperty("liferay.home");

		Assert.assertNotNull(
			"Missing system property \"liferay.home\"", liferayHome);

		Path path = Paths.get(
			liferayHome, "osgi/marketplace/Liferay Inner Container Test.lpkg");

		Files.createFile(path);

		LPKGTestUtil.createLPKG(path, _SYMBOLIC_NAME, false);

		Path containerPath = Paths.get(
			liferayHome, "osgi/marketplace/Liferay Container Test.lpkg");

		Files.createFile(containerPath);

		try (OutputStream outputStream = Files.newOutputStream(containerPath);
			ZipOutputStream zipOutputStream = new ZipOutputStream(
				outputStream)) {

			zipOutputStream.putNextEntry(
				new ZipEntry("Liferay Inner Container Test.lpkg"));

			zipOutputStream.write(Files.readAllBytes(path));

			zipOutputStream.closeEntry();
		}

		Files.delete(path);
	}

	private static final String _SYMBOLIC_NAME = "lpkg.inner.container.test";

}