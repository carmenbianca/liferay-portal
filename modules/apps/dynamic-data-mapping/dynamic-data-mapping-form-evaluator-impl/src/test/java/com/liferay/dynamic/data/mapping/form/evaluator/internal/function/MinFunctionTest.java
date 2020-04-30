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
public class MinFunctionTest {

	@Test
	public void testEmptyArray() {
		MinFunction minFunction = new MinFunction();

		BigDecimal result = minFunction.apply(new BigDecimal[0]);

		Assert.assertEquals(BigDecimal.ZERO, result);
	}

	@Test
	public void testMax() {
		MinFunction minFunction = new MinFunction();

		BigDecimal result = minFunction.apply(
			new BigDecimal[] {
				new BigDecimal(1), new BigDecimal(10), new BigDecimal(3),
				new BigDecimal(19), new BigDecimal(17)
			});

		Assert.assertEquals(BigDecimal.ONE, result);
	}

}