/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunction;

import java.math.BigDecimal;

/**
 * @author Leonardo Barros
 */
public class IsDecimalFunction
	implements DDMExpressionFunction.Function1<Object, Boolean> {

	public static final String NAME = "isDecimal";

	@Override
	public Boolean apply(Object value) {
		try {
			new BigDecimal(value.toString());

			return true;
		}
		catch (NumberFormatException numberFormatException) {
			return false;
		}
	}

	@Override
	public String getName() {
		return NAME;
	}

}