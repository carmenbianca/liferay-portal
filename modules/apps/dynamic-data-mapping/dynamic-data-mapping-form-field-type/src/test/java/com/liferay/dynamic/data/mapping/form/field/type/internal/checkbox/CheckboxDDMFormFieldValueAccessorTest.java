/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.checkbox;

import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.model.UnlocalizedValue;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.test.util.DDMFormValuesTestUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Renato Rego
 */
public class CheckboxDDMFormFieldValueAccessorTest {

	@Test
	public void testGetWithLocalizedValue() {
		Value value = new LocalizedValue(LocaleUtil.US);

		value.addString(LocaleUtil.BRAZIL, "true");
		value.addString(LocaleUtil.US, "false");

		DDMFormFieldValue ddmFormFieldValue =
			DDMFormValuesTestUtil.createDDMFormFieldValue("Checkbox", value);

		CheckboxDDMFormFieldValueAccessor checkboxDDMFormFieldValueAccessor =
			new CheckboxDDMFormFieldValueAccessor();

		Assert.assertEquals(
			Boolean.TRUE,
			checkboxDDMFormFieldValueAccessor.getValue(
				ddmFormFieldValue, LocaleUtil.BRAZIL));
		Assert.assertEquals(
			Boolean.FALSE,
			checkboxDDMFormFieldValueAccessor.getValue(
				ddmFormFieldValue, LocaleUtil.US));
	}

	@Test
	public void testGetWithUnlocalizedValue() {
		DDMFormFieldValue ddmFormFieldValue =
			DDMFormValuesTestUtil.createDDMFormFieldValue(
				"Checkbox", new UnlocalizedValue("true"));

		CheckboxDDMFormFieldValueAccessor checkboxDDMFormFieldValueAccessor =
			new CheckboxDDMFormFieldValueAccessor();

		Assert.assertEquals(
			Boolean.TRUE,
			checkboxDDMFormFieldValueAccessor.getValue(
				ddmFormFieldValue, LocaleUtil.BRAZIL));
		Assert.assertEquals(
			Boolean.TRUE,
			checkboxDDMFormFieldValueAccessor.getValue(
				ddmFormFieldValue, LocaleUtil.US));
	}

}