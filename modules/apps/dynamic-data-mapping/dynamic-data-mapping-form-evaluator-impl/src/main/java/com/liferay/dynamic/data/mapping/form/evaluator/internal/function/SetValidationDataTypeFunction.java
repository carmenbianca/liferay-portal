/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

/**
 * @author Leonardo Barros
 */
public class SetValidationDataTypeFunction extends SetPropertyFunction<String> {

	public static final String NAME = "setValidationDataType";

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	protected String getPropertyName() {
		return "validationDataType";
	}

}