/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.storage;

import com.liferay.dynamic.data.mapping.model.UnlocalizedValue;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.portal.kernel.util.StringUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Marcellus Tavares
 */
public class UnlocalizedValueTest {

	@Test
	public void testEqualsWithDifferentValueString() {
		Value value1 = new UnlocalizedValue(StringUtil.randomString());
		Value value2 = new UnlocalizedValue(StringUtil.randomString());

		Assert.assertNotEquals(value1, value2);
	}

	@Test
	public void testEqualsWithSameValueString() {
		String valueString = StringUtil.randomString();

		Value value1 = new UnlocalizedValue(valueString);
		Value value2 = new UnlocalizedValue(valueString);

		Assert.assertEquals(value1, value2);
	}

}