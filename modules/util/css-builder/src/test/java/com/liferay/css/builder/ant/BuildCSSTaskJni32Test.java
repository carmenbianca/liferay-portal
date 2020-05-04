/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.css.builder.ant;

import com.liferay.css.builder.BaseCSSBulderJni32TestCase;

import java.io.File;

import java.net.URL;

import java.nio.file.Path;

import org.apache.tools.ant.BuildFileRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;

/**
 * @author Andrea Di Giorgi
 */
public class BuildCSSTaskJni32Test extends BaseCSSBulderJni32TestCase {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		URL url = BuildCSSTaskJni32Test.class.getResource(
			"dependencies/build.xml");

		File buildXmlFile = new File(url.toURI());

		Assert.assertTrue(buildXmlFile.isFile());

		buildFileRule.configureProject(buildXmlFile.getAbsolutePath());
	}

	@Rule
	public final BuildFileRule buildFileRule = new BuildFileRule();

	@Override
	protected String executeCSSBuilder(
			Path baseDirPath, String dirName, String[] excludes,
			boolean generateSourceMap, Path importDirPath, String outputDirName,
			int precision, String[] rtlExcludedPathRegexps,
			String sassCompilerClassName)
		throws Exception {

		return BuildCSSTaskTestUtil.executeCSSBuilder(
			buildFileRule, baseDirPath, dirName, excludes, generateSourceMap,
			importDirPath, outputDirName, precision, rtlExcludedPathRegexps,
			sassCompilerClassName);
	}

}