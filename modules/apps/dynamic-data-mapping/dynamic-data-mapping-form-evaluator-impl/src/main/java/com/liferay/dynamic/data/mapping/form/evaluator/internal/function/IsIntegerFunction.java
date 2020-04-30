/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunction;

import org.apache.commons.lang.math.NumberUtils;

/**
 * @author Leonardo Barros
 */
public class IsIntegerFunction
	implements DDMExpressionFunction.Function1<Object, Boolean> {

	public static final String NAME = "isInteger";

	@Override
	public Boolean apply(Object parameter) {
		Integer value = NumberUtils.toInt(
			parameter.toString(), Integer.MIN_VALUE);

		return value != Integer.MIN_VALUE;
	}

	@Override
	public String getName() {
		return NAME;
	}

}