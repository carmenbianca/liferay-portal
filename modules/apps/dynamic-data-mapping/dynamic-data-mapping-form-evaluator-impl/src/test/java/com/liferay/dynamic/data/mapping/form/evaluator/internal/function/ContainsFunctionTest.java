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
public class ContainsFunctionTest {

	@Test
	public void testApplyFalse() {
		ContainsFunction containsFunction = new ContainsFunction();

		Boolean result = containsFunction.apply("liferay", "forms");

		Assert.assertFalse(result);
	}

	@Test
	public void testApplyTrue() {
		ContainsFunction containsFunction = new ContainsFunction();

		Boolean result = containsFunction.apply("liferayFORMS", "forms");

		Assert.assertTrue(result);
	}

	@Test
	public void testApplyWithNull1() {
		ContainsFunction containsFunction = new ContainsFunction();

		Boolean result = containsFunction.apply(null, "forms");

		Assert.assertFalse(result);
	}

	@Test
	public void testApplyWithNull2() {
		ContainsFunction containsFunction = new ContainsFunction();

		Boolean result = containsFunction.apply("liferay", null);

		Assert.assertFalse(result);
	}

}