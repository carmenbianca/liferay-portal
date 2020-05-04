/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.builder.internal.converter.serializer;

import com.liferay.dynamic.data.mapping.form.builder.internal.converter.model.action.AutoFillDDMFormRuleAction;
import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleActionSerializer;
import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleSerializerContext;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.Map;

/**
 * @author Leonardo Barros
 */
public class AutoFillDDMFormRuleActionSerializer
	implements SPIDDMFormRuleActionSerializer {

	public AutoFillDDMFormRuleActionSerializer(
		AutoFillDDMFormRuleAction autoFillDDMFormRuleAction) {

		_autoFillDDMFormRuleAction = autoFillDDMFormRuleAction;
	}

	@Override
	public String serialize(
		SPIDDMFormRuleSerializerContext spiDDMFormRuleSerializerContext) {

		return String.format(
			_FUNCTION_CALL_TERNARY_EXPRESSION_FORMAT, "call",
			StringUtil.quote(
				_autoFillDDMFormRuleAction.getDDMDataProviderInstanceUUID()),
			convertAutoFillInputParameters(
				_autoFillDDMFormRuleAction.getInputParametersMapper()),
			convertAutoFillOutputParameters(
				_autoFillDDMFormRuleAction.getOutputParametersMapper()));
	}

	protected String convertAutoFillInputParameters(
		Map<String, String> inputParametersMapper) {

		if (MapUtil.isEmpty(inputParametersMapper)) {
			return StringUtil.quote(StringPool.BLANK);
		}

		StringBundler sb = new StringBundler(
			inputParametersMapper.size() * 4 - 1);

		for (Map.Entry<String, String> inputParameterMapper :
				inputParametersMapper.entrySet()) {

			sb.append(inputParameterMapper.getKey());
			sb.append(CharPool.EQUAL);
			sb.append(inputParameterMapper.getValue());
			sb.append(CharPool.SEMICOLON);
		}

		sb.setIndex(sb.index() - 1);

		return StringUtil.quote(sb.toString());
	}

	protected String convertAutoFillOutputParameters(
		Map<String, String> outputParametersMapper) {

		if (MapUtil.isEmpty(outputParametersMapper)) {
			return StringUtil.quote(StringPool.BLANK);
		}

		StringBundler sb = new StringBundler(
			outputParametersMapper.size() * 4 - 1);

		for (Map.Entry<String, String> outputParameterMapper :
				outputParametersMapper.entrySet()) {

			sb.append(outputParameterMapper.getValue());
			sb.append(CharPool.EQUAL);
			sb.append(outputParameterMapper.getKey());
			sb.append(CharPool.SEMICOLON);
		}

		sb.setIndex(sb.index() - 1);

		return StringUtil.quote(sb.toString());
	}

	private static final String _FUNCTION_CALL_TERNARY_EXPRESSION_FORMAT =
		"%s(%s, %s, %s)";

	private final AutoFillDDMFormRuleAction _autoFillDDMFormRuleAction;

}