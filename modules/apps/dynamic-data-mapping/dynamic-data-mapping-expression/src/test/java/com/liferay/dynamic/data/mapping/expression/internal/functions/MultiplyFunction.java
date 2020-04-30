/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression.internal.functions;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunction;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Rafael Praxedes
 */
public class MultiplyFunction
	implements DDMExpressionFunction.Function1<BigDecimal[], BigDecimal> {

	@Override
	public BigDecimal apply(BigDecimal[] numbers) {
		Stream<BigDecimal> stream = Arrays.stream(numbers);

		return stream.reduce(BigDecimal.ONE, (n1, n2) -> n1.multiply(n2));
	}

	@Override
	public String getName() {
		return "multiply";
	}

}