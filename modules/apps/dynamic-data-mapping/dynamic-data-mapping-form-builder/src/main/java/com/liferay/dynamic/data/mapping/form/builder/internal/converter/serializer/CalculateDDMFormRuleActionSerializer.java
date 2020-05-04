/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.builder.internal.converter.serializer;

import com.liferay.dynamic.data.mapping.form.builder.internal.converter.model.action.CalculateDDMFormRuleAction;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleActionSerializer;
import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleSerializerContext;
import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Leonardo Barros
 */
public class CalculateDDMFormRuleActionSerializer
	implements SPIDDMFormRuleActionSerializer {

	public CalculateDDMFormRuleActionSerializer(
		CalculateDDMFormRuleAction calculateDDMFormRuleAction) {

		_calculateDDMFormRuleAction = calculateDDMFormRuleAction;
	}

	@Override
	public String serialize(
		SPIDDMFormRuleSerializerContext spiDDMFormRuleSerializerContext) {

		DDMForm ddmForm = spiDDMFormRuleSerializerContext.getAttribute("form");

		Map<String, DDMFormField> ddmFormFieldsMap =
			ddmForm.getDDMFormFieldsMap(true);

		String expression = removeBrackets(
			_calculateDDMFormRuleAction.getExpression());

		Set<String> keySet = ddmFormFieldsMap.keySet();

		Stream<String> ddmFormFieldStream = keySet.stream();

		Set<String> ddmFormFieldNames = ddmFormFieldStream.filter(
			ddmFormField -> expression.contains(ddmFormField)
		).collect(
			Collectors.toSet()
		);

		String newExpression = buildExpression(expression, ddmFormFieldNames);

		return String.format(
			_FUNCTION_CALL_BINARY_EXPRESSION_FORMAT, "calculate",
			_calculateDDMFormRuleAction.getTarget(), newExpression);
	}

	protected String buildExpression(
		String expression, Set<String> ddmFormFieldNames) {

		int start = Integer.MAX_VALUE;
		int end = Integer.MIN_VALUE;

		StringBuilder newExpressionSB = new StringBuilder();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < expression.length(); i++) {
			char token = expression.charAt(i);

			sb.append(token);

			String compareStr = sb.toString();

			boolean match = matchAnyField(compareStr, ddmFormFieldNames);

			if (match) {
				newExpressionSB.append(token);

				if (start == Integer.MAX_VALUE) {
					start = i;
				}

				if (i == (expression.length() - 1)) {
					end = expression.length();
				}
			}
			else {
				if (i > start) {
					replace(expression, newExpressionSB, start, i);
				}

				newExpressionSB.append(token);

				sb = new StringBuilder();

				start = Integer.MAX_VALUE;
				end = Integer.MIN_VALUE;
			}
		}

		if (end > start) {
			replace(expression, newExpressionSB, start, end);
		}

		return newExpressionSB.toString();
	}

	protected boolean matchAnyField(
		String compareStr, Set<String> ddmFormFields) {

		for (String ddmFormField : ddmFormFields) {
			if (ddmFormField.startsWith(compareStr)) {
				return true;
			}
		}

		return false;
	}

	protected String removeBrackets(String expression) {
		return StringUtil.removeChars(
			expression, CharPool.OPEN_BRACKET, CharPool.CLOSE_BRACKET);
	}

	protected void replace(
		String expression, StringBuilder newExpressionSB, int start, int end) {

		String fieldName = expression.substring(start, end);

		String fieldNameReplacement = String.format(
			_FUNCTION_CALL_UNARY_EXPRESSION_FORMAT, "getValue", fieldName);

		int currentLength = newExpressionSB.length();

		newExpressionSB.replace(
			currentLength - fieldName.length(), currentLength,
			fieldNameReplacement);
	}

	private static final String _FUNCTION_CALL_BINARY_EXPRESSION_FORMAT =
		"%s('%s', %s)";

	private static final String _FUNCTION_CALL_UNARY_EXPRESSION_FORMAT =
		"%s('%s')";

	private final CalculateDDMFormRuleAction _calculateDDMFormRuleAction;

}