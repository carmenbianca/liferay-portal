/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.util;

import com.liferay.poshi.runner.PoshiRunnerTestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Yi-Chen Tsai
 */
public class HttpRequestUtilTest extends PoshiRunnerTestCase {

	@Before
	public void setUp() throws Exception {
		setUpPoshiRunner(_TEST_BASE_DIR_NAME);
	}

	@Test
	public void testAssertStatusCode() throws Exception {
		runPoshiTest("HttpRequestTest#testAssertStatusCode");
	}

	private static final String _TEST_BASE_DIR_NAME =
		"src/test/resources/com/liferay/poshi/runner/dependencies/util/";

}