/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.storage;

import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.portal.kernel.util.LocaleUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Marcellus Tavares
 */
public class LocalizedValueTest {

	@Test
	public void testEqualsWithDifferentDefaultLocaleAndSameValuesMap() {
		Value value1 = new LocalizedValue(LocaleUtil.US);
		Value value2 = new LocalizedValue(LocaleUtil.BRAZIL);

		Assert.assertNotEquals(value1, value2);
	}

	@Test
	public void testEqualsWithSameDefaultLocaleAndDifferentValuesMap() {
		Value value1 = new LocalizedValue(LocaleUtil.US);

		value1.addString(LocaleUtil.US, "Test");
		value1.addString(LocaleUtil.BRAZIL, "Teste");

		Value value2 = new LocalizedValue(LocaleUtil.US);

		value2.addString(LocaleUtil.US, "Different Test");
		value2.addString(LocaleUtil.BRAZIL, "Teste");

		Assert.assertNotEquals(value1, value2);
	}

	@Test
	public void testEqualsWithSameDefaultLocaleAndSameValuesMap() {
		Value value1 = new LocalizedValue(LocaleUtil.US);

		value1.addString(LocaleUtil.US, "Test");
		value1.addString(LocaleUtil.BRAZIL, "Teste");

		Value value2 = new LocalizedValue(LocaleUtil.US);

		value2.addString(LocaleUtil.US, "Test");
		value2.addString(LocaleUtil.BRAZIL, "Teste");

		Assert.assertEquals(value1, value2);
	}

}