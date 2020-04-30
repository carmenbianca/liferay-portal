/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.source.formatter;

import org.junit.Test;

/**
 * @author Hugo Huijser
 */
public class JavaParserTest extends BaseSourceProcessorTestCase {

	@Test
	public void testJavaAnnotation() throws Exception {
		test("JavaAnnotation.testjava");
	}

	@Test
	public void testJavaArray() throws Exception {
		test("JavaArray.testjava");
	}

}