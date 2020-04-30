/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Leonardo Barros
 */
public class IsURLFunctionTest {

	@Test
	public void testInvalidURL() {
		IsURLFunction isURLFunction = new IsURLFunction();

		Boolean result = isURLFunction.apply("invalid URL");

		Assert.assertFalse(result);
	}

	@Test
	public void testNullParameter() {
		IsURLFunction isURLFunction = new IsURLFunction();

		Boolean result = isURLFunction.apply(null);

		Assert.assertFalse(result);
	}

	@Test
	public void testValidURL() {
		IsURLFunction isURLFunction = new IsURLFunction();

		Boolean result = isURLFunction.apply("http://www.liferay.com");

		Assert.assertTrue(result);
	}

}