/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function.factory;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunction;
import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunctionFactory;
import com.liferay.dynamic.data.mapping.form.evaluator.internal.function.ConcatFunction;

import org.osgi.service.component.annotations.Component;

/**
 * @author Matthew Tambara
 */
@Component(
	property = "name=" + ConcatFunction.NAME,
	service = DDMExpressionFunctionFactory.class
)
public class ConcatFunctionFactory implements DDMExpressionFunctionFactory {

	@Override
	public DDMExpressionFunction create() {
		return _CONCAT_FUNCTION;
	}

	private static final ConcatFunction _CONCAT_FUNCTION = new ConcatFunction();

}