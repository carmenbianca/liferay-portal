/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author Karen Dang
 */
public class XMLSourceProcessorTest extends BaseSourceProcessorTestCase {

	@Test
	public void testIncorrectEmptyLines() throws Exception {
		test("IncorrectEmptyLines1.testxml");
		test("IncorrectEmptyLines2.testxml");
	}

	@Test
	public void testIncorrectTabs() throws Exception {
		test("IncorrectTabs1.testaction");
		test("IncorrectTabs2.testaction");
		test("IncorrectTabs3.testaction");
	}

	@Test
	public void testIncorrectXMLStyling() throws Exception {
		test("IncorrectXMLStyling.testxml");
	}

}