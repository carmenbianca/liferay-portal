/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.rest.builder;

import java.io.File;

import java.net.URL;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sarai Díaz
 */
public class RESTBuilderTest {

	@Test
	public void testCreateRESTBuilder() throws Exception {
		String dependenciesPath = _getDependenciesPath();

		RESTBuilder restBuilder = new RESTBuilder(
			new File(dependenciesPath, "copyright.txt"),
			new File(dependenciesPath));

		restBuilder.build();

		String filesPath = _getFilesPath();

		File applicationFile = new File(
			filesPath + "/sample-impl/src/main/java/com/example/sample" +
				"/internal/jaxrs/application/SampleApplication.java");

		Assert.assertTrue(applicationFile.exists());

		File baseResourceImplFile = new File(
			filesPath + "/sample-impl/src/main/java/com/example/sample" +
				"/internal/resource/v1_0_0/BaseFolderResourceImpl.java");

		Assert.assertTrue(baseResourceImplFile.exists());

		File folderResourceImplFile = new File(
			filesPath + "/sample-impl/src/main/java/com/example/sample" +
				"/internal/resource/v1_0_0/FolderResourceImpl.java");

		Assert.assertTrue(folderResourceImplFile.exists());

		File propertiesFile = new File(
			filesPath + "/sample-impl/src/main/resources/OSGI-INF/liferay" +
				"/rest/v1_0_0/folder.properties");

		Assert.assertTrue(propertiesFile.exists());

		File dtoFolderFile = new File(
			filesPath + "/sample-api/src/main/java/com/example/sample/dto" +
				"/v1_0_0/Folder.java");

		Assert.assertTrue(dtoFolderFile.exists());

		File resourceFolderFile = new File(
			filesPath + "/sample-api/src/main/java/com/example/sample" +
				"/resource/v1_0_0/FolderResource.java");

		Assert.assertTrue(resourceFolderFile.exists());

		File sampleApi = new File(filesPath + "/sample-api");

		FileUtils.deleteDirectory(sampleApi);

		Assert.assertFalse(sampleApi.exists());

		File sampleImpl = new File(filesPath + "/sample-impl");

		FileUtils.deleteDirectory(sampleImpl);

		Assert.assertFalse(sampleImpl.exists());
	}

	private String _getDependenciesPath() {
		URL resource = getClass().getResource("");

		String path = resource.getPath();

		return path + "dependencies/";
	}

	private String _getFilesPath() {
		Path path = Paths.get("");

		Path absolutePath = path.toAbsolutePath();

		Path parentPath = absolutePath.getParent();

		return parentPath.toString();
	}

}