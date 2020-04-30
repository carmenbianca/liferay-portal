/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Leonardo Barros
 */
public class EqualsFunctionTest {

	@Test
	public void testApplyFalse1() {
		EqualsFunction equalsFunction = new EqualsFunction();

		Assert.assertFalse(equalsFunction.apply("FORMS", "forms"));
	}

	@Test
	public void testApplyFalse2() {
		EqualsFunction equalsFunction = new EqualsFunction();

		Assert.assertFalse(equalsFunction.apply(null, "forms"));
	}

	@Test
	public void testApplyFalse3() {
		EqualsFunction equalsFunction = new EqualsFunction();

		Assert.assertFalse(equalsFunction.apply("1", new BigDecimal(1)));
	}

	@Test
	public void testApplyTrue() {
		EqualsFunction equalsFunction = new EqualsFunction();

		Assert.assertTrue(equalsFunction.apply("forms", "forms"));
	}

}