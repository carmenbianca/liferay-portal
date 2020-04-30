/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.builder.internal.converter.serializer;

import com.liferay.dynamic.data.mapping.form.builder.internal.converter.model.action.JumpToPageDDMFormRuleAction;
import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleSerializerContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author Leonardo Barros
 */
@RunWith(PowerMockRunner.class)
public class JumpToPageDDMFormRuleActionSerializerTest extends PowerMockito {

	@Test
	public void testSerialize() {
		when(
			_jumpToPageDDMFormRuleAction.getSource()
		).thenReturn(
			"1"
		);

		when(
			_jumpToPageDDMFormRuleAction.getTarget()
		).thenReturn(
			"3"
		);

		JumpToPageDDMFormRuleActionSerializer
			jumpToPageDDMFormRuleActionSerializer =
				new JumpToPageDDMFormRuleActionSerializer(
					_jumpToPageDDMFormRuleAction);

		String result = jumpToPageDDMFormRuleActionSerializer.serialize(
			_spiDDMFormRuleSerializerContext);

		Assert.assertEquals("jumpPage(1, 3)", result);
	}

	@Mock
	private JumpToPageDDMFormRuleAction _jumpToPageDDMFormRuleAction;

	@Mock
	private SPIDDMFormRuleSerializerContext _spiDDMFormRuleSerializerContext;

}