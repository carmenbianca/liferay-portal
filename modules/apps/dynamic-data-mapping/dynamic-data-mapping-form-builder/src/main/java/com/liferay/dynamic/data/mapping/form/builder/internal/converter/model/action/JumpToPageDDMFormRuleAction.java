/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.builder.internal.converter.model.action;

import com.liferay.dynamic.data.mapping.form.builder.internal.converter.serializer.JumpToPageDDMFormRuleActionSerializer;
import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleActionSerializer;
import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleSerializerContext;
import com.liferay.petra.lang.HashUtil;

import java.util.Objects;

/**
 * @author Leonardo Barros
 */
public class JumpToPageDDMFormRuleAction extends DefaultDDMFormRuleAction {

	public JumpToPageDDMFormRuleAction() {
	}

	public JumpToPageDDMFormRuleAction(String source, String target) {
		super("jump-to-page", target);

		_source = source;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JumpToPageDDMFormRuleAction)) {
			return false;
		}

		JumpToPageDDMFormRuleAction ddmFormRuleAction =
			(JumpToPageDDMFormRuleAction)obj;

		if (super.equals(obj) &&
			Objects.equals(_source, ddmFormRuleAction._source)) {

			return true;
		}

		return false;
	}

	public String getSource() {
		return _source;
	}

	@Override
	public int hashCode() {
		int hash = super.hashCode();

		return HashUtil.hash(hash, _source);
	}

	@Override
	public String serialize(
		SPIDDMFormRuleSerializerContext spiDDMFormRuleSerializerContext) {

		SPIDDMFormRuleActionSerializer spiDDMFormRuleActionSerializer =
			new JumpToPageDDMFormRuleActionSerializer(this);

		return spiDDMFormRuleActionSerializer.serialize(
			spiDDMFormRuleSerializerContext);
	}

	public void setSource(String source) {
		_source = source;
	}

	private String _source;

}