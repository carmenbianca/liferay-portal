/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author André de Oliveira
 */
public class JSPSourceProcessorTest extends BaseSourceProcessorTestCase {

	@Test
	public void testFormatBooleanScriptlet() throws Exception {
		test("FormatBooleanScriptlet.testjsp");
	}

	@Test
	public void testFormatImportsAndTaglibs() throws Exception {
		test("FormatImportsAndTaglibs.testjsp");
	}

	@Test
	public void testFormatSelfClosingTags() throws Exception {
		test("FormatSelfClosingTags.testjsp");
	}

	@Test
	public void testFormatTaglibs() throws Exception {
		test("FormatTaglibs.testjsp");
	}

	@Test
	public void testFormatTagLineBreaks() throws Exception {
		test("FormatTagLineBreaks.testjsp");
	}

	@Test
	public void testIncorrectEmptyLine() throws Exception {
		test("IncorrectEmptyLine.testjsp");
	}

	@Test
	public void testIncorrectIndentation() throws Exception {
		test("IncorrectIndentation.testjsp");
	}

	@Test
	public void testMisplacedImport() throws Exception {
		test("MisplacedImport.testjsp", "Move imports to init.jsp");
	}

	@Test
	public void testMissingTaglibs() throws Exception {
		test(
			"MissingTaglibs.testjsp",
			new String[] {
				"Missing taglib for tag with prefix 'aui'",
				"Missing taglib for tag with prefix 'liferay-portlet'",
				"Missing taglib for tag with prefix 'liferay-ui'"
			});
	}

	@Test
	public void testSortTagAttributes() throws Exception {
		test("SortTagAttributes.testjsp");
	}

}