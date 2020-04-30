/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author Alan Huang
 */
public class JSONSourceProcessorTest extends BaseSourceProcessorTestCase {

	@Test
	public void testCheckMissingScripts() throws Exception {
		/*
		test(
			"CheckMissingScripts1/package.testjson",
			new String[] {
				"When using 'liferay-npm-scripts', a script for 'csf' is " +
					"required",
				"When using 'liferay-npm-scripts', a script for 'format' is " +
					"required"
			});

		test(
			"CheckMissingScripts2/package.testjson",
			new String[] {
				"When using 'liferay-npm-scripts', a script for 'csf' is " +
					"required",
				"When using 'liferay-npm-scripts', a script for 'format' is " +
					"required"
			});

		test(
			"CheckMissingScripts3/package.testjson",
			new String[] {
				"When using 'liferay-npm-scripts', a script for 'csf' is " +
					"required",
				"When using 'liferay-npm-scripts', a script for 'format' is " +
					"required"
			});

		test(
			"CheckMissingScripts4/package.testjson",
			new String[] {
				"When using 'liferay-npm-scripts', a script for 'format' is " +
					"required"
			});
		*/
	}

	@Test
	public void testIncorrectEmptyLines() throws Exception {
		test("IncorrectEmptyLines.testjson");
	}

	@Test
	public void testJSONDeprecatedPackagesCheck() throws Exception {
		test(
			"JSONDeprecatedPackages/package.testjson",
			new String[] {
				"Do not use deprecated package " +
					"'liferay-module-config-generator'",
				"Do not use deprecated package 'metal-cli'"
			},
			new Integer[] {4, 5});
	}

}