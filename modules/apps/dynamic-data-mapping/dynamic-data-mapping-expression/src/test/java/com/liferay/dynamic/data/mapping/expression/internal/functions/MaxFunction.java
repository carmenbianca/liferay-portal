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
public class MaxFunction
	implements DDMExpressionFunction.Function1<BigDecimal[], BigDecimal> {

	@Override
	public BigDecimal apply(BigDecimal[] numbers) {
		Stream<BigDecimal> stream = Arrays.stream(numbers);

		return stream.max(
			BigDecimal::compareTo
		).get();
	}

	@Override
	public String getName() {
		return "max";
	}

}