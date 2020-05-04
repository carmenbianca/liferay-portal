/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.soy.builder.maven;

import com.liferay.maven.executor.MavenExecutor;
import com.liferay.portal.tools.soy.builder.commands.ReplaceSoyTranslationCommandTest;
import com.liferay.portal.tools.soy.builder.util.FileTestUtil;

import java.io.File;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.junit.Assert;
import org.junit.ClassRule;

/**
 * @author Andrea Di Giorgi
 */
public class ReplaceSoyTranslationMojoTest
	extends ReplaceSoyTranslationCommandTest {

	@ClassRule
	public static final MavenExecutor mavenExecutor = new MavenExecutor();

	public ReplaceSoyTranslationMojoTest(String testDirName) {
		super(testDirName);
	}

	@Override
	protected void testSoy(File dir) throws Exception {
		File projectDir = temporaryFolder.newFolder("maven");

		_preparePomXml(projectDir, dir);

		MavenExecutor.Result result = mavenExecutor.execute(
			projectDir, "soy-builder:replace-translation");

		Assert.assertEquals(result.output, 0, result.exitCode);
	}

	private static void _preparePomXml(File projectDir, File dir)
		throws IOException {

		String content = FileTestUtil.read(
			ReplaceSoyTranslationMojoTest.class.getClassLoader(),
			"com/liferay/portal/tools/soy/builder/maven/dependencies" +
				"/pom_xml.tmpl");

		content = content.replace(
			"[$SOY_BUILDER_VERSION$]", _SOY_BUILDER_VERSION);

		content = content.replace("[$SOY_BUILDER_DIR$]", dir.getAbsolutePath());

		File pomXmlFile = new File(projectDir, "pom.xml");

		Files.write(
			pomXmlFile.toPath(), content.getBytes(StandardCharsets.UTF_8));
	}

	private static final String _SOY_BUILDER_VERSION = System.getProperty(
		"soy.builder.version");

}