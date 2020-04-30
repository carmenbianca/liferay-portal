/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.radio;

import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.DDMFormFieldOptions;
import com.liferay.dynamic.data.mapping.model.UnlocalizedValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.dynamic.data.mapping.test.util.DDMFormTestUtil;
import com.liferay.dynamic.data.mapping.test.util.DDMFormValuesTestUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Renato Rego
 */
public class RadioDDMFormFieldValueRendererTest {

	@Test
	public void testRender() throws Exception {
		DDMForm ddmForm = DDMFormTestUtil.createDDMForm();

		DDMFormField ddmFormField = DDMFormTestUtil.createDDMFormField(
			"Radio", "Radio", "radio", "string", false, false, false);

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
				"Radio", new UnlocalizedValue("value 1"));

		ddmFormValues.addDDMFormFieldValue(ddmFormFieldValue);

		RadioDDMFormFieldValueRenderer radioDDMFormFieldValueRenderer =
			createRadioDDMFormFieldValueRenderer();

		Assert.assertEquals(
			"option 1",
			radioDDMFormFieldValueRenderer.render(
				ddmFormFieldValue, LocaleUtil.US));
	}

	protected RadioDDMFormFieldValueRenderer
			createRadioDDMFormFieldValueRenderer()
		throws Exception {

		RadioDDMFormFieldValueRenderer radioDDMFormFieldValueRenderer =
			new RadioDDMFormFieldValueRenderer();

		radioDDMFormFieldValueRenderer.radioDDMFormFieldValueAccessor =
			new RadioDDMFormFieldValueAccessor();

		return radioDDMFormFieldValueRenderer;
	}

}