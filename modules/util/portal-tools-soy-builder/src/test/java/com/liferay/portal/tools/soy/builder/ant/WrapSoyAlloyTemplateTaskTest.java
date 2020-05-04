/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.tools.soy.builder.ant;

import com.liferay.portal.tools.soy.builder.commands.WrapSoyAlloyTemplateCommandTest;

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
public class WrapSoyAlloyTemplateTaskTest
	extends WrapSoyAlloyTemplateCommandTest {

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();

		URL url = WrapSoyAlloyTemplateTaskTest.class.getResource(
			"dependencies/wrap_soy_alloy_template/build.xml");

		File buildXmlFile = new File(url.toURI());

		Assert.assertTrue(buildXmlFile.isFile());

		buildFileRule.configureProject(buildXmlFile.getAbsolutePath());
	}

	@Rule
	public final BuildFileRule buildFileRule = new BuildFileRule();

	@Override
	protected void wrapAlloyTemplate(
			File dir, String moduleName, String namespace)
		throws Exception {

		Project project = buildFileRule.getProject();

		project.setProperty(
			"wrap.soy.alloy.template.dir", dir.getAbsolutePath());
		project.setProperty("wrap.soy.alloy.module.name", moduleName);
		project.setProperty("wrap.soy.alloy.namespace", namespace);

		project.executeTarget("wrap-soy-alloy-template");
	}

}