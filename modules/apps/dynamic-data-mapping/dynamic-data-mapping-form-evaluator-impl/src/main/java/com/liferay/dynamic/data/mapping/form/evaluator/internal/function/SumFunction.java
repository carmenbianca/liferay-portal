/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunction;

import java.math.BigDecimal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Leonardo Barros
 */
public class SumFunction
	implements DDMExpressionFunction.Function1<BigDecimal[], BigDecimal> {

	public static final String NAME = "sum";

	@Override
	public BigDecimal apply(BigDecimal[] values) {
		return Stream.of(
			values
		).collect(
			Collectors.reducing(BigDecimal.ZERO, (num1, num2) -> num1.add(num2))
		);
	}

	@Override
	public String getName() {
		return NAME;
	}

}