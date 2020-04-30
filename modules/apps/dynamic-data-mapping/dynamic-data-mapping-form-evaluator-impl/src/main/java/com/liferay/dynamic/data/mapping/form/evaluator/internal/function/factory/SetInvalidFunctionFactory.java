/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function.factory;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunction;
import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunctionFactory;
import com.liferay.dynamic.data.mapping.form.evaluator.internal.function.SetInvalidFunction;

import org.osgi.service.component.annotations.Component;

/**
 * @author Matthew Tambara
 */
@Component(
	property = "name=" + SetInvalidFunction.NAME,
	service = DDMExpressionFunctionFactory.class
)
public class SetInvalidFunctionFactory implements DDMExpressionFunctionFactory {

	@Override
	public DDMExpressionFunction create() {
		return new SetInvalidFunction();
	}

}