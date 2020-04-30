/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner;

import com.liferay.poshi.runner.selenium.SeleniumUtil;
import com.liferay.poshi.runner.util.PropsUtil;
import com.liferay.poshi.runner.util.Validator;

import java.io.File;

import junit.framework.TestCase;

import org.apache.commons.lang3.ArrayUtils;

import org.junit.After;

/**
 * @author Kenji Heigel
 */
public abstract class PoshiRunnerTestCase extends TestCase {

	public void runPoshiTest(String testName) throws Exception {
		PoshiRunner poshiRunner = new PoshiRunner("LocalFile." + testName);

		poshiRunner.setUp();

		poshiRunner.test();
	}

	public void setUpPoshiRunner(String testBaseDirName) throws Exception {
		File testBaseDir = new File(testBaseDirName);

		if (!testBaseDir.exists()) {
			throw new RuntimeException(
				"Test directory does not exist: " + testBaseDirName);
		}

		if (Validator.isNotNull(System.getenv("JENKINS_HOME"))) {
			PropsUtil.set(
				"browser.firefox.bin.file", "/opt/firefox-52.0.2esr/firefox");
		}

		String[] poshiFileNames = ArrayUtils.addAll(
			PoshiRunnerContext.POSHI_SUPPORT_FILE_INCLUDES,
			PoshiRunnerContext.POSHI_TEST_FILE_INCLUDES);

		PoshiRunnerContext.readFiles(poshiFileNames, testBaseDirName);

		PoshiRunnerValidation.validate();
	}

	@After
	public void tearDown() {
		SeleniumUtil.stopSelenium();
	}

}