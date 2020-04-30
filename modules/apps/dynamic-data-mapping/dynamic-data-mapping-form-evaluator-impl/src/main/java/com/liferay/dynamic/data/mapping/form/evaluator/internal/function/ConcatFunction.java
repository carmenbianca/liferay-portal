/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFunction;
import com.liferay.portal.kernel.util.Validator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Leonardo Barros
 */
public class ConcatFunction
	implements DDMExpressionFunction.Function1<Object[], String> {

	public static final String NAME = "concat";

	@Override
	public String apply(Object[] values) {
		return Stream.of(
			values
		).filter(
			Validator::isNotNull
		).map(
			Object::toString
		).collect(
			Collectors.joining()
		);
	}

	@Override
	public String getName() {
		return NAME;
	}

}