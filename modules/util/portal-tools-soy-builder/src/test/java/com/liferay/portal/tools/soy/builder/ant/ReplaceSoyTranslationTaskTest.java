/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.soy.builder.ant;

import com.liferay.portal.tools.soy.builder.commands.ReplaceSoyTranslationCommandTest;

import java.io.File;

import java.net.URL;

import org.apache.tools.ant.BuildFileRule;
import org.apache.tools.ant.Project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;

/**
 * @author Andrea Di Giorgi
 */
public class ReplaceSoyTranslationTaskTest
	extends ReplaceSoyTranslationCommandTest {

	public ReplaceSoyTranslationTaskTest(String testDirName) {
		super(testDirName);
	}

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		URL url = ReplaceSoyTranslationTaskTest.class.getResource(
			"dependencies/replace_soy_translation/build.xml");

		File buildXmlFile = new File(url.toURI());

		Assert.assertTrue(buildXmlFile.isFile());

		buildFileRule.configureProject(buildXmlFile.getAbsolutePath());
	}

	@Rule
	public final BuildFileRule buildFileRule = new BuildFileRule();

	@Override
	protected void testSoy(File dir) throws Exception {
		Project project = buildFileRule.getProject();

		project.setProperty(
			"replace.soy.translation.dir", dir.getAbsolutePath());

		project.executeTarget("replace-soy-translation");
	}

}