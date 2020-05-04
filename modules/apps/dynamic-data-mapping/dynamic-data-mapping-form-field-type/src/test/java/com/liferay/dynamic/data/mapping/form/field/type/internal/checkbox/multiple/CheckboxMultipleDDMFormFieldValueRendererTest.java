/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.checkbox.multiple;

import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.DDMFormFieldOptions;
import com.liferay.dynamic.data.mapping.model.UnlocalizedValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.test.util.DDMFormTestUtil;
import com.liferay.dynamic.data.mapping.test.util.DDMFormValuesTestUtil;
import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.util.LocaleUtil;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Rafael Praxedes
 */
public class CheckboxMultipleDDMFormFieldValueRendererTest {

	@Before
	public void setUp() {
		_checkboxMultipleDDMFormFieldValueRenderer =
			new CheckboxMultipleDDMFormFieldValueRenderer();

		CheckboxMultipleDDMFormFieldValueAccessor
			checkboxMultipleDDMFormFieldValueAccessor =
				new CheckboxMultipleDDMFormFieldValueAccessor();

		checkboxMultipleDDMFormFieldValueAccessor.jsonFactory =
			new JSONFactoryImpl();

		_checkboxMultipleDDMFormFieldValueRenderer.
			checkboxMultipleDDMFormFieldValueAccessor =
				checkboxMultipleDDMFormFieldValueAccessor;
	}

	@Test
	public void testRender() throws Exception {
		DDMForm ddmForm = DDMFormTestUtil.createDDMForm();

		DDMFormField ddmFormField = DDMFormTestUtil.createDDMFormField(
			"CheckboxMultiple", "Checkbox Multiple", "checkbox-multiple",
			"string", false, false, false);

		DDMFormFieldOptions ddmFormFieldOptions =
			ddmFormField.getDDMFormFieldOptions();

		ddmFormFieldOptions.addOptionLabel(
			"value 1", LocaleUtil.US, "option 1");
		ddmFormFieldOptions.addOptionLabel(
			"value 2", LocaleUtil.US, "option 2");

		ddmForm.addDDMFormField(ddmFormField);

		DDMFormValues ddmFormValues = DDMFormValuesTestUtil.createDDMFormValues(
			ddmForm);

		DDMFormFieldValue ddmFormFieldValue =
			DDMFormValuesTestUtil.createDDMFormFieldValue(
				"CheckboxMultiple", new UnlocalizedValue("[\"value 1\"]"));

		ddmFormValues.addDDMFormFieldValue(ddmFormFieldValue);

		Assert.assertEquals(
			"option 1",
			_checkboxMultipleDDMFormFieldValueRenderer.render(
				ddmFormFieldValue, LocaleUtil.US));
	}

	@Test
	public void testRender2() throws Exception {
		DDMForm ddmForm = DDMFormTestUtil.createDDMForm();

		DDMFormField ddmFormField = DDMFormTestUtil.createDDMFormField(
			"CheckboxMultiple", "Checkbox Multiple", "checkbox-multiple",
			"string", false, false, false);

		DDMFormFieldOptions ddmFormFieldOptions =
			ddmFormField.getDDMFormFieldOptions();

		ddmFormFieldOptions.addOptionLabel(
			"value 1", LocaleUtil.US, "option 1");
		ddmFormFieldOptions.addOptionLabel(
			"value 2", LocaleUtil.US, "option 2");

		ddmForm.addDDMFormField(ddmFormField);

		DDMFormValues ddmFormValues = DDMFormValuesTestUtil.createDDMFormValues(
			ddmForm);

		DDMFormFieldValue ddmFormFieldValue =
			DDMFormValuesTestUtil.createDDMFormFieldValue(
				"CheckboxMultiple",
				new UnlocalizedValue("[\"value 1\",\"value 2\"]"));

		ddmFormValues.addDDMFormFieldValue(ddmFormFieldValue);

		Assert.assertEquals(
			"option 1, option 2",
			_checkboxMultipleDDMFormFieldValueRenderer.render(
				ddmFormFieldValue, LocaleUtil.US));
	}

	private CheckboxMultipleDDMFormFieldValueRenderer
		_checkboxMultipleDDMFormFieldValueRenderer;

}