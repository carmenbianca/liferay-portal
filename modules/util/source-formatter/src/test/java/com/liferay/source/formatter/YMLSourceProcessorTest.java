/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author Alan Huang
 */
public class YMLSourceProcessorTest extends BaseSourceProcessorTestCase {

	@Test
	public void testExceedMaxLineLength() throws Exception {
		test("ExceedMaxLineLength.testyaml", "> 120", 22);
	}

	@Test
	public void testIncorrectEmptyLines() throws Exception {
		test("IncorrectEmptyLines.testyaml");
	}

	@Test
	public void testIncorrectWhitespaceOnHelmYaml() throws Exception {
		test("IncorrectWhitespaceOnHelmYaml.testyaml");
	}

	@Test
	public void testReviewTags() throws Exception {
		test("ReviewTags.testyaml");
	}

	@Test
	public void testSortDefinitionsAndWhitespaceCheck() throws Exception {
		test("SortDefinitionsAndWhitespace.testyaml");
	}

	@Test
	public void testSortDefinitionsOnHelmYaml() throws Exception {
		test("SortDefinitionsOnHelmYaml.testyaml");
	}

	@Test
	public void testSortSpecificDefinitions() throws Exception {
		test("SortSpecificDefinitions.testyaml");
	}

	@Test
	public void testStyleBlock() throws Exception {
		test("StyleBlock.testyaml");
	}

	@Test
	public void testStylingCheck() throws Exception {
		test("StylingCheck.testyaml");
	}

}