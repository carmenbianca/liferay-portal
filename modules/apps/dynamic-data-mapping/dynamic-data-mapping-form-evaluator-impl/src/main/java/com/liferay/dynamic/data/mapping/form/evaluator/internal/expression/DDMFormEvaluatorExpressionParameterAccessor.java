/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal.expression;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionParameterAccessor;
import com.liferay.dynamic.data.mapping.form.evaluator.DDMFormEvaluatorEvaluateRequest;

import java.util.Locale;

/**
 * @author Rafael Praxedes
 */
public class DDMFormEvaluatorExpressionParameterAccessor
	implements DDMExpressionParameterAccessor {

	public DDMFormEvaluatorExpressionParameterAccessor(
		DDMFormEvaluatorEvaluateRequest ddmFormEvaluatorEvaluateRequest) {

		_ddmFormEvaluatorEvaluateRequest = ddmFormEvaluatorEvaluateRequest;
	}

	@Override
	public long getCompanyId() {
		return _ddmFormEvaluatorEvaluateRequest.getCompanyId();
	}

	@Override
	public long getGroupId() {
		return _ddmFormEvaluatorEvaluateRequest.getGroupId();
	}

	@Override
	public Locale getLocale() {
		return _ddmFormEvaluatorEvaluateRequest.getLocale();
	}

	@Override
	public long getUserId() {
		return _ddmFormEvaluatorEvaluateRequest.getUserId();
	}

	private final DDMFormEvaluatorEvaluateRequest
		_ddmFormEvaluatorEvaluateRequest;

}