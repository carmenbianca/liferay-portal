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
public class IsEmptyFunctionTest {

	@Test
	public void testArray() {
		IsEmptyFunction isEmptyFunction = new IsEmptyFunction();

		Boolean result = isEmptyFunction.apply(
			new String[] {"  ", "not empty "});

		Assert.assertFalse(result);
	}

	@Test
	public void testEmptyParameter() {
		IsEmptyFunction isEmptyFunction = new IsEmptyFunction();

		Boolean result = isEmptyFunction.apply(" ");

		Assert.assertTrue(result);
	}

	@Test
	public void testNullParameter() {
		IsEmptyFunction isEmptyFunction = new IsEmptyFunction();

		Boolean result = isEmptyFunction.apply(null);

		Assert.assertTrue(result);
	}

}