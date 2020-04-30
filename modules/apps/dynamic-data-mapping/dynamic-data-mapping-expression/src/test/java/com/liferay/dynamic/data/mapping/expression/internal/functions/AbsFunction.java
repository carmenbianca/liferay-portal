/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression.internal.functions;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunction;

import java.math.BigDecimal;

/**
 * @author Rafael Praxedes
 */
public class AbsFunction
	implements DDMExpressionFunction.Function1<BigDecimal, BigDecimal> {

	@Override
	public BigDecimal apply(BigDecimal n) {
		return n.abs();
	}

	@Override
	public String getName() {
		return "abs";
	}

}