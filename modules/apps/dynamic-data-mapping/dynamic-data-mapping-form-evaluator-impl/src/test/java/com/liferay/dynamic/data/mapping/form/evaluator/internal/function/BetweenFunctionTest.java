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
public class BetweenFunctionTest {

	@Test
	public void testApplyFalse1() {
		BetweenFunction betweenFunction = new BetweenFunction();

		boolean result = betweenFunction.apply(
			BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ONE);

		Assert.assertFalse(result);
	}

	@Test
	public void testApplyFalse2() {
		BetweenFunction betweenFunction = new BetweenFunction();

		boolean result = betweenFunction.apply(
			BigDecimal.ONE, new BigDecimal(2), BigDecimal.TEN);

		Assert.assertFalse(result);
	}

	@Test
	public void testApplyTrue() {
		BetweenFunction betweenFunction = new BetweenFunction();

		boolean result = betweenFunction.apply(
			BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN);

		Assert.assertTrue(result);
	}

}