/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.upload;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * @author Manuel de la Peña
 */
public class LiferayFileItemFactoryTest {

	@Test
	public void testConstructor() throws Exception {
		LiferayFileItemFactory liferayFileItemFactory =
			new LiferayFileItemFactory(temporaryFolder.getRoot());

		Assert.assertNotNull(liferayFileItemFactory);
	}

	@Test
	public void testCreateItem() throws Exception {
		LiferayFileItemFactory liferayFileItemFactory =
			new LiferayFileItemFactory(temporaryFolder.getRoot());

		FileItem fileItem = liferayFileItemFactory.createItem(
			"fieldName", "contentType", false, "fileName");

		Assert.assertNotNull(fileItem);
	}

	@Test
	public void testCreateItemWithInvalidTempDir() throws Exception {
		LiferayFileItemFactory liferayFileItemFactory =
			new LiferayFileItemFactory(new File("file://foo"));

		FileItem fileItem = liferayFileItemFactory.createItem(
			"fieldName", "contentType", false, "fileName");

		Assert.assertNotNull(fileItem);
	}

	@Test
	public void testCreateItemWithNullTempDir() throws Exception {
		LiferayFileItemFactory liferayFileItemFactory =
			new LiferayFileItemFactory(null);

		FileItem fileItem = liferayFileItemFactory.createItem(
			"fieldName", "contentType", false, "fileName");

		Assert.assertNotNull(fileItem);
	}

	@Test
	public void testCreateItemWithNullValues() throws Exception {
		LiferayFileItemFactory liferayFileItemFactory =
			new LiferayFileItemFactory(temporaryFolder.getRoot());

		FileItem fileItem = liferayFileItemFactory.createItem(
			null, null, false, null);

		Assert.assertNotNull(fileItem);
	}

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

}