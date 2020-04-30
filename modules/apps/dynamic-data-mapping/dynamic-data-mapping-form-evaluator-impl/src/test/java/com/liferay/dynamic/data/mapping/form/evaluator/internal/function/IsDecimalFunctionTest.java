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
public class IsDecimalFunctionTest {

	@Test
	public void testApplyFalse() {
		IsDecimalFunction isDecimalFunction = new IsDecimalFunction();

		Boolean result = isDecimalFunction.apply("NUMBER");

		Assert.assertFalse(result);
	}

	@Test
	public void testApplyTrue1() {
		IsDecimalFunction isDecimalFunction = new IsDecimalFunction();

		Boolean result = isDecimalFunction.apply("1.2");

		Assert.assertTrue(result);
	}

	@Test
	public void testApplyTrue2() {
		IsDecimalFunction isDecimalFunction = new IsDecimalFunction();

		Boolean result = isDecimalFunction.apply("3");

		Assert.assertTrue(result);
	}

}