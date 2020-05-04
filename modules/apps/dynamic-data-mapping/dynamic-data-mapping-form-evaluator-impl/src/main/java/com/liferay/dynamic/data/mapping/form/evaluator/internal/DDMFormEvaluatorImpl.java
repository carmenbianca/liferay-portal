/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.evaluator.internal;

import com.liferay.dynamic.data.mapping.expression.DDMExpressionFactory;
import com.liferay.dynamic.data.mapping.form.evaluator.DDMFormEvaluator;
import com.liferay.dynamic.data.mapping.form.evaluator.DDMFormEvaluatorEvaluateRequest;
import com.liferay.dynamic.data.mapping.form.evaluator.DDMFormEvaluatorEvaluateResponse;
import com.liferay.dynamic.data.mapping.form.evaluator.DDMFormEvaluatorFieldContextKey;
import com.liferay.dynamic.data.mapping.form.evaluator.DDMFormFieldEvaluationResult;
import com.liferay.dynamic.data.mapping.form.evaluator.internal.helper.DDMFormEvaluatorHelper;
import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTypeServicesTracker;
import com.liferay.petra.string.StringBundler;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pablo Carvalho
 * @author Leonardo Barros
 */
@Component(immediate = true, service = DDMFormEvaluator.class)
public class DDMFormEvaluatorImpl implements DDMFormEvaluator {

	@Override
	public DDMFormEvaluatorEvaluateResponse evaluate(
		DDMFormEvaluatorEvaluateRequest ddmFormEvaluatorEvaluateRequest) {

		DDMFormEvaluatorHelper formEvaluatorHelper = new DDMFormEvaluatorHelper(
			ddmFormEvaluatorEvaluateRequest, ddmExpressionFactory,
			ddmFormFieldTypeServicesTracker);

		return formEvaluatorHelper.evaluate();
	}

	protected Map<String, DDMFormFieldEvaluationResult>
		createDDMFormFieldEvaluationResultsMap(
			Map<DDMFormEvaluatorFieldContextKey, Map<String, Object>>
				ddmFormFieldsPropertyChange) {

		Map<String, DDMFormFieldEvaluationResult> map = new HashMap<>();

		for (Map.Entry<DDMFormEvaluatorFieldContextKey, Map<String, Object>>
				entry : ddmFormFieldsPropertyChange.entrySet()) {

			DDMFormEvaluatorFieldContextKey ddmFormEvaluatorFieldContextKey =
				entry.getKey();

			String key = StringBundler.concat(
				ddmFormEvaluatorFieldContextKey.getName(), "_INSTANCE_",
				ddmFormEvaluatorFieldContextKey.getInstanceId());

			DDMFormFieldEvaluationResult ddmFormFieldEvaluationResult =
				new DDMFormFieldEvaluationResult(
					ddmFormEvaluatorFieldContextKey.getName(),
					ddmFormEvaluatorFieldContextKey.getInstanceId());

			Map<String, Object> value = entry.getValue();

			for (Map.Entry<String, Object> property : value.entrySet()) {
				ddmFormFieldEvaluationResult.setProperty(
					property.getKey(), property.getValue());
			}

			map.put(key, ddmFormFieldEvaluationResult);
		}

		return map;
	}

	@Reference
	protected DDMExpressionFactory ddmExpressionFactory;

	@Reference
	protected DDMFormFieldTypeServicesTracker ddmFormFieldTypeServicesTracker;

}