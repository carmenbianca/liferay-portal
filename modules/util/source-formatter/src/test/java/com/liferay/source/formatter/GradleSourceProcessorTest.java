/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author Alan Huang
 */
public class GradleSourceProcessorTest extends BaseSourceProcessorTestCase {

	@Test
	public void testSortMapKeys() throws Exception {
		test("SortMapKeys1.testgradle");
		test("SortMapKeys2.testgradle");
		test("SortMapKeys3.testgradle");
		test("SortMapKeys4.testgradle");
		test("SortMapKeys5.testgradle");
	}

	@Test
	public void testStylingCheck() throws Exception {
		test("StylingCheck.testgradle");
	}

}