/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.function;

/**
 * @author Rafael Praxedes
 */
public class CalculateFunction extends SetPropertyFunction<String> {

	public static final String NAME = "calculate";

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	protected String getPropertyName() {
		return "value";
	}

}