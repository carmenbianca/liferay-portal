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
public class MinFunction
	implements DDMExpressionFunction.Function1<BigDecimal[], BigDecimal> {

	public static final String NAME = "MIN";

	@Override
	public BigDecimal apply(BigDecimal[] values) {
		return Stream.of(
			values
		).collect(
			Collectors.minBy((num1, num2) -> num1.compareTo(num2))
		).orElse(
			BigDecimal.ZERO
		);
	}

	@Override
	public String getName() {
		return NAME;
	}

}