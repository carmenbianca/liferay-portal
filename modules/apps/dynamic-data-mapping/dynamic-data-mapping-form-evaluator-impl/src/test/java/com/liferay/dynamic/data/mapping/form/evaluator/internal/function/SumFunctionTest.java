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
public class SumFunctionTest {

	@Test
	public void testApply() {
		SumFunction sumFunction = new SumFunction();

		BigDecimal result = sumFunction.apply(
			new BigDecimal[] {
				new BigDecimal(1), new BigDecimal(2), new BigDecimal(3)
			});

		Assert.assertEquals(new BigDecimal(6), result);
	}

	@Test
	public void testEmptyArray() {
		SumFunction sumFunction = new SumFunction();

		BigDecimal result = sumFunction.apply(new BigDecimal[0]);

		Assert.assertEquals(BigDecimal.ZERO, result);
	}

}