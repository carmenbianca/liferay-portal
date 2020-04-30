/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner;

import com.liferay.poshi.runner.util.FileUtil;

import java.io.File;

import junit.framework.TestCase;

import org.apache.commons.lang3.ArrayUtils;

import org.dom4j.Element;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Karen Dang
 * @author Michael Hashimoto
 */
public class PoshiRunnerContextTest extends TestCase {

	@Before
	@Override
	public void setUp() throws Exception {
		String[] poshiFileNames = ArrayUtils.addAll(
			PoshiRunnerContext.POSHI_SUPPORT_FILE_INCLUDES,
			PoshiRunnerContext.POSHI_TEST_FILE_INCLUDES);

		String poshiFileDir =
			"src/test/resources/com/liferay/poshi/runner/dependencies/test";

		PoshiRunnerContext.readFiles(poshiFileNames, poshiFileDir);
	}

	@After
	@Override
	public void tearDown() throws Exception {
		PoshiRunnerContext.clear();
	}

	@Test
	public void testGetFilePath() throws Exception {
		String actualFilePath = PoshiRunnerContext.getFilePathFromFileName(
			"Action2.action", PoshiRunnerContext.getDefaultNamespace());

		String baseDirName = FileUtil.getCanonicalPath(
			"src/test/resources/com/liferay/poshi/runner/");

		File file = new File(baseDirName, "/dependencies/test/Action2.action");

		String expectedFilePath = file.getCanonicalPath();

		Assert.assertEquals(
			"getFilePath is failing", expectedFilePath, actualFilePath);
	}

	@Test
	public void testGetFunctionCommandElement() throws Exception {
		Element element = PoshiRunnerContext.getFunctionCommandElement(
			"Click#clickAt", PoshiRunnerContext.getDefaultNamespace());

		Assert.assertEquals(
			"getFunctionCommandElement is failing", "clickAt",
			element.attributeValue("name"));
	}

	@Test
	public void testGetFunctionLocatorCount() throws Exception {
		int locatorCount = PoshiRunnerContext.getFunctionLocatorCount(
			"Click", PoshiRunnerContext.getDefaultNamespace());

		Assert.assertEquals(
			"getFunctionLocatorCount is failing", 1, locatorCount);
	}

	@Test
	public void testGetFunctionRootElement() {
		Element element = PoshiRunnerContext.getFunctionRootElement(
			"Click", PoshiRunnerContext.getDefaultNamespace());

		Assert.assertEquals(
			"getFunctionRootElement is failing", "definition",
			element.getName());
	}

	@Test
	public void testGetMacroCommandElement() {
		Element element = PoshiRunnerContext.getMacroCommandElement(
			"Macro#test", PoshiRunnerContext.getDefaultNamespace());

		Assert.assertEquals(
			"getMacroCommandElement is failing", "test",
			element.attributeValue("name"));
	}

	@Test
	public void testGetPathLocator() throws Exception {
		String locator = PoshiRunnerContext.getPathLocator(
			"Action1#TEST_TITLE", PoshiRunnerContext.getDefaultNamespace());

		Assert.assertEquals(
			"getPathLocator is failing", "//input[@class='Title']", locator);

		locator = PoshiRunnerContext.getPathLocator(
			"Action1#TEST_CONTENT", PoshiRunnerContext.getDefaultNamespace());

		Assert.assertEquals(
			"getPathLocator is failing", "//input[@class='Content']", locator);
	}

	@Test
	public void testGetSeleniumParameterCount() {
		int count = PoshiRunnerContext.getSeleniumParameterCount("clickAt");

		Assert.assertEquals("getSeleniumParameterCount is failing", 2, count);

		count = PoshiRunnerContext.getSeleniumParameterCount("click");

		Assert.assertEquals("getSeleniumParameterCount is failing", 1, count);
	}

	@Test
	public void testGetTestCaseCommandElement() {
		Element element = PoshiRunnerContext.getTestCaseCommandElement(
			"Test#test", PoshiRunnerContext.getDefaultNamespace());

		Assert.assertEquals(
			"getTestCaseCommandElement is failing", "test",
			element.attributeValue("name"));
	}

	@Test
	public void testGetTestCaseRootElement() {
		Element element = PoshiRunnerContext.getTestCaseRootElement(
			"Test", PoshiRunnerContext.getDefaultNamespace());

		Assert.assertEquals(
			"getTestCaseRootElement is failing", "definition",
			element.getName());
	}

}