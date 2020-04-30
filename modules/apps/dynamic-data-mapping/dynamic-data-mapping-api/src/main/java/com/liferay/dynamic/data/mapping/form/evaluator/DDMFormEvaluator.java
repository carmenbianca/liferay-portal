/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Pablo Carvalho
 * @author Leonardo Barros
 */
@ProviderType
public interface DDMFormEvaluator {

	public DDMFormEvaluatorEvaluateResponse evaluate(
		DDMFormEvaluatorEvaluateRequest ddmFormEvaluatorEvaluateRequest);

}