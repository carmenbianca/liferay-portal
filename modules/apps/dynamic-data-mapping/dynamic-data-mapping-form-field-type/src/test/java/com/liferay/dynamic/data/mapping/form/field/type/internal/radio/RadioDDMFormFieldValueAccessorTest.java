/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.radio;

import com.liferay.dynamic.data.mapping.model.UnlocalizedValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.test.util.DDMFormValuesTestUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Renato Rego
 */
public class RadioDDMFormFieldValueAccessorTest {

	@Test
	public void testGetRadioValue() {
		DDMFormFieldValue ddmFormFieldValue =
			DDMFormValuesTestUtil.createDDMFormFieldValue(
				"Radio", new UnlocalizedValue("value 1"));

		RadioDDMFormFieldValueAccessor radioDDMFormFieldValueAccessor =
			new RadioDDMFormFieldValueAccessor();

		Assert.assertEquals(
			"value 1",
			radioDDMFormFieldValueAccessor.getValue(
				ddmFormFieldValue, LocaleUtil.US));
	}

}