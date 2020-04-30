/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author Alan Huang
 */
public class HTMLSourceProcessorTest extends BaseSourceProcessorTestCase {

	@Test
	public void testFormatSelfClosingTags() throws Exception {
		test("FormatSelfClosingTags.testhtml");
	}

	@Test
	public void testIncorrectEmptyLines() throws Exception {
		test("IncorrectEmptyLines.testhtml");
	}

}