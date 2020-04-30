/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author Alan Huang
 */
public class PoshiSourceProcessorTest extends BaseSourceProcessorTestCase {

	@Test
	public void testDuplicatedParameters() throws Exception {
		test(
			"PoshiDuplicatedParameters.testmacro",
			"Duplicate parameter 'userScreenName'", 5);
	}

	@Test
	public void testIncorrectAnnotationsOrder() throws Exception {
		test("IncorrectAnnotationsOrder.testmacro");
	}

	@Test
	public void testIncorrectCommandsOrder() throws Exception {
		test("IncorrectCommandsOrder.testfunction");
		test("IncorrectCommandsOrder.testmacro");
		test("IncorrectCommandsOrder.testtestcase");
	}

	@Test
	public void testIncorrectComments() throws Exception {
		test("IncorrectComments.testmacro");
	}

	@Test
	public void testIncorrectEmptyLines() throws Exception {
		test("testIncorrectEmptyLines.testmacro");
	}

	@Test
	public void testIncorrectLineBreak() throws Exception {
		test(
			"IncorrectLineBreak.testmacro",
			new String[] {
				"There should be a line break after ';'",
				"There should be a line break after ';'",
				"There should be a line break after ';'",
				"There should be a line break after ';'"
			},
			new Integer[] {3, 4, 18, 19});
	}

	@Test
	public void testIncorrectParameterOrder() throws Exception {
		test("PoshiIncorrectParameterOrder.testmacro");
	}

	@Test
	public void testIncorrectWhitespace() throws Exception {
		test("IncorrectWhitespace.testmacro");
		test("IncorrectWhitespaceInControlFlowStatements.testmacro");
	}

	@Test
	public void testMissingEmptyLines() throws Exception {
		test("MissingEmptyLines.testmacro");
	}

}