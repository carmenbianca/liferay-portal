/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

/**
 * @author Jeyvison Nascimento
 */
public class SetValidationFieldNameFunction
	extends SetPropertyFunction<String> {

	public static final String NAME = "setValidationFieldName";

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	protected String getPropertyName() {
		return "validationFieldName";
	}

}