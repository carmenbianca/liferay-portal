/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

/**
 * @author Leonardo Barros
 */
public class SetEnabledFunction extends SetPropertyFunction<Boolean> {

	public static final String NAME = "setEnabled";

	@Override
	public Boolean apply(String field, Boolean value) {
		return super.apply(field, !value);
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	protected String getPropertyName() {
		return "readOnly";
	}

}