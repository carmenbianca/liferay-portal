/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.builder.internal.converter.serializer;

import com.liferay.dynamic.data.mapping.form.builder.internal.converter.model.action.DefaultDDMFormRuleAction;
import com.liferay.dynamic.data.mapping.spi.converter.serializer.SPIDDMFormRuleSerializerContext;

import org.junit.Assert;
import org.junit.Test;

import org.mockito.Mock;

/**
 * @author Leonardo Barros
 */
public class DefaultDDMFormRuleActionSerializerTest {

	@Test
	public void testSerializeSetEnabled() {
		DefaultDDMFormRuleAction defaultDDMFormRuleAction =
			new DefaultDDMFormRuleAction("enable", "field0");

		DefaultDDMFormRuleActionSerializer defaultDDMFormRuleActionSerializer =
			new DefaultDDMFormRuleActionSerializer(defaultDDMFormRuleAction);

		String result = defaultDDMFormRuleActionSerializer.serialize(
			_spiDDMFormRuleSerializerContext);

		Assert.assertEquals("setEnabled('field0', true)", result);
	}

	@Test
	public void testSerializeSetInvalid() {
		DefaultDDMFormRuleAction defaultDDMFormRuleAction =
			new DefaultDDMFormRuleAction("invalidate", "field0");

		DefaultDDMFormRuleActionSerializer defaultDDMFormRuleActionSerializer =
			new DefaultDDMFormRuleActionSerializer(defaultDDMFormRuleAction);

		String result = defaultDDMFormRuleActionSerializer.serialize(
			_spiDDMFormRuleSerializerContext);

		Assert.assertEquals("setInvalid('field0', true)", result);
	}

	@Test
	public void testSerializeSetRequired() {
		DefaultDDMFormRuleAction defaultDDMFormRuleAction =
			new DefaultDDMFormRuleAction("require", "field0");

		DefaultDDMFormRuleActionSerializer defaultDDMFormRuleActionSerializer =
			new DefaultDDMFormRuleActionSerializer(defaultDDMFormRuleAction);

		String result = defaultDDMFormRuleActionSerializer.serialize(
			_spiDDMFormRuleSerializerContext);

		Assert.assertEquals("setRequired('field0', true)", result);
	}

	@Test
	public void testSerializeSetVisible() {
		DefaultDDMFormRuleAction defaultDDMFormRuleAction =
			new DefaultDDMFormRuleAction("show", "field0");

		DefaultDDMFormRuleActionSerializer defaultDDMFormRuleActionSerializer =
			new DefaultDDMFormRuleActionSerializer(defaultDDMFormRuleAction);

		String result = defaultDDMFormRuleActionSerializer.serialize(
			_spiDDMFormRuleSerializerContext);

		Assert.assertEquals("setVisible('field0', true)", result);
	}

	@Mock
	private SPIDDMFormRuleSerializerContext _spiDDMFormRuleSerializerContext;

}