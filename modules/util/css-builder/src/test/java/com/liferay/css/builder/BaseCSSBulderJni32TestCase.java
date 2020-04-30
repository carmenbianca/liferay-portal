/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.css.builder;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Eduardo García
 * @author David Truong
 * @author Andrea Di Giorgi
 */
public abstract class BaseCSSBulderJni32TestCase
	extends BaseCSSBuilderTestCase {

	@Test
	public void testCSSBuilderWithJni32() throws Exception {
		String output = testCSSBuilder(importDirPath, "jni32");

		Assert.assertTrue(
			output, output.contains("Using native 32-bit Sass compiler"));
	}

	@Test
	public void testCSSBuilderWithJni32AndPortalCommonJar() throws Exception {
		String output = testCSSBuilder(importJarPath, "jni32");

		Assert.assertTrue(
			output, output.contains("Using native 32-bit Sass compiler"));
	}

}