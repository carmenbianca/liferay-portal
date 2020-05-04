/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.grid;

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
import org.junit.Test;

/**
 * @author Pedro Queiroz
 */
public class GridDDMFormFieldValueRendererTest {

	@Test
	public void testRender() throws Exception {
		DDMForm ddmForm = DDMFormTestUtil.createDDMForm();

		DDMFormField ddmFormField = DDMFormTestUtil.createDDMFormField(
			"Grid", "Grid", "grid", "string", false, false, false);

		DDMFormFieldOptions ddmFormFieldRows = new DDMFormFieldOptions();

		ddmFormFieldRows.addOptionLabel(
			"rowValue 1", LocaleUtil.US, "rowLabel 1");
		ddmFormFieldRows.addOptionLabel(
			"rowValue 2", LocaleUtil.US, "rowLabel 2");

		ddmFormField.setProperty("rows", ddmFormFieldRows);

		DDMFormFieldOptions ddmFormFieldColumns = new DDMFormFieldOptions();

		ddmFormFieldColumns.addOptionLabel(
			"columnValue 1", LocaleUtil.US, "columnLabel 1");
		ddmFormFieldColumns.addOptionLabel(
			"columnValue 2", LocaleUtil.US, "columnLabel 2");

		ddmFormField.setProperty("columns", ddmFormFieldColumns);

		ddmForm.addDDMFormField(ddmFormField);

		DDMFormValues ddmFormValues = DDMFormValuesTestUtil.createDDMFormValues(
			ddmForm);

		DDMFormFieldValue ddmFormFieldValue =
			DDMFormValuesTestUtil.createDDMFormFieldValue(
				"Grid",
				new UnlocalizedValue("{\"rowValue 1\":\"columnValue 1\"}"));

		ddmFormValues.addDDMFormFieldValue(ddmFormFieldValue);

		GridDDMFormFieldValueRenderer gridDDMFormFieldValueRenderer =
			createGridDDMFormFieldValueRenderer();

		Assert.assertEquals(
			"rowLabel 1: columnLabel 1",
			gridDDMFormFieldValueRenderer.render(
				ddmFormFieldValue, LocaleUtil.US));
	}

	@Test
	public void testRenderWithTwoRows() throws Exception {
		DDMForm ddmForm = DDMFormTestUtil.createDDMForm();

		DDMFormField ddmFormField = DDMFormTestUtil.createDDMFormField(
			"Grid", "Grid", "grid", "string", false, false, false);

		DDMFormFieldOptions ddmFormFieldRows = new DDMFormFieldOptions();

		ddmFormFieldRows.addOptionLabel(
			"rowValue 1", LocaleUtil.US, "rowLabel 1");
		ddmFormFieldRows.addOptionLabel(
			"rowValue 2", LocaleUtil.US, "rowLabel 2");

		ddmFormField.setProperty("rows", ddmFormFieldRows);

		DDMFormFieldOptions ddmFormFieldColumns = new DDMFormFieldOptions();

		ddmFormFieldColumns.addOptionLabel(
			"columnValue 1", LocaleUtil.US, "columnLabel 1");
		ddmFormFieldColumns.addOptionLabel(
			"columnValue 2", LocaleUtil.US, "columnLabel 2");

		ddmFormField.setProperty("columns", ddmFormFieldColumns);

		ddmForm.addDDMFormField(ddmFormField);

		DDMFormValues ddmFormValues = DDMFormValuesTestUtil.createDDMFormValues(
			ddmForm);

		String value =
			"{\"rowValue 2\":\"columnValue 2\", \"rowValue 1\":\"" +
				"columnValue 1\"}";

		DDMFormFieldValue ddmFormFieldValue =
			DDMFormValuesTestUtil.createDDMFormFieldValue(
				"Grid", new UnlocalizedValue(value));

		ddmFormValues.addDDMFormFieldValue(ddmFormFieldValue);

		GridDDMFormFieldValueRenderer gridDDMFormFieldValueRenderer =
			createGridDDMFormFieldValueRenderer();

		Assert.assertEquals(
			"rowLabel 1: columnLabel 1, rowLabel 2: columnLabel 2",
			gridDDMFormFieldValueRenderer.render(
				ddmFormFieldValue, LocaleUtil.US));
	}

	protected GridDDMFormFieldValueAccessor
		createGridDDMFormFieldValueAccessor() {

		GridDDMFormFieldValueAccessor gridDDMFormFieldValueAccessor =
			new GridDDMFormFieldValueAccessor();

		gridDDMFormFieldValueAccessor.jsonFactory = new JSONFactoryImpl();

		return gridDDMFormFieldValueAccessor;
	}

	protected GridDDMFormFieldValueRenderer
			createGridDDMFormFieldValueRenderer()
		throws Exception {

		GridDDMFormFieldValueRenderer gridDDMFormFieldValueRenderer =
			new GridDDMFormFieldValueRenderer();

		gridDDMFormFieldValueRenderer.gridDDMFormFieldValueAccessor =
			createGridDDMFormFieldValueAccessor();

		return gridDDMFormFieldValueRenderer;
	}

}