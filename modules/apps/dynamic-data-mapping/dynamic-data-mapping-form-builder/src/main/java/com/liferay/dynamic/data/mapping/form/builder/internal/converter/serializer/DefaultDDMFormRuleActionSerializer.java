/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.builder.internal.converter.serializer;

import com.liferay.dynamic.data.mapping.form.builder.internal.converter.model.action.DefaultDDMFormRuleAction;
import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleActionSerializer;
import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleSerializerContext;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.Map;

/**
 * @author Leonardo Barros
 */
public class DefaultDDMFormRuleActionSerializer
	implements SPIDDMFormRuleActionSerializer {

	public DefaultDDMFormRuleActionSerializer(
		DefaultDDMFormRuleAction defaultDDMFormRuleAction) {

		_defaultDDMFormRuleAction = defaultDDMFormRuleAction;
	}

	@Override
	public String serialize(
		SPIDDMFormRuleSerializerContext spiDDMFormRuleSerializerContext) {

		String functionName = _actionBooleanFunctionNameMap.get(
			_defaultDDMFormRuleAction.getAction());

		return String.format(
			_SET_BOOLEAN_PROPERTY_FORMAT, functionName,
			_defaultDDMFormRuleAction.getTarget());
	}

	private static final String _SET_BOOLEAN_PROPERTY_FORMAT = "%s('%s', true)";

	private static final Map<String, String> _actionBooleanFunctionNameMap =
		HashMapBuilder.put(
			"enable", "setEnabled"
		).put(
			"invalidate", "setInvalid"
		).put(
			"require", "setRequired"
		).put(
			"show", "setVisible"
		).build();

	private final DefaultDDMFormRuleAction _defaultDDMFormRuleAction;

}