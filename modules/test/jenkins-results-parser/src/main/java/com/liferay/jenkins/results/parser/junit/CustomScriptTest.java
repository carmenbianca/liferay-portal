/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.junit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Yi-Chen Tsai
 */
@RunWith(Parameterized.class)
public class CustomScriptTest {

	@Parameterized.Parameters(name = "{0}")
	public static Collection<Object[]> getTestNames() {
		return Arrays.asList(new Object[][] {{System.getProperty("testName")}});
	}

	public CustomScriptTest(String testName) {
	}

	@Test
	public void test() {
		String expectedResult = System.getProperty("expected");
		String actualResult = System.getProperty("actual");

		Assert.assertEquals(expectedResult, actualResult);
	}

}