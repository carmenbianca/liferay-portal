/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.form.internal.dto.v1_0.util;

import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.model.UnlocalizedValue;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.headless.form.dto.v1_0.FormFieldValue;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 * @author Victor Oliveira
 */
public class DDMFormValuesUtil {

	public static DDMFormValues createDDMFormValues(
			DDMFormInstance ddmFormInstance, FormFieldValue[] formFieldValues,
			Locale locale)
		throws Exception {

		DDMStructure ddmStructure = ddmFormInstance.getStructure();

		DDMForm ddmForm = ddmStructure.getDDMForm();

		DDMFormValues ddmFormValues = new DDMFormValues(ddmForm);

		ddmFormValues.addAvailableLocale(locale);

		Map<String, DDMFormField> ddmFormFieldsMap =
			ddmForm.getDDMFormFieldsMap(true);

		ddmFormValues.setDDMFormFieldValues(
			TransformUtil.transformToList(
				formFieldValues,
				fieldValue -> _toDDMFormFieldValue(
					ddmFormFieldsMap, fieldValue, locale)));

		ddmFormValues.setDefaultLocale(locale);

		return ddmFormValues;
	}

	private static DDMFormFieldValue _toDDMFormFieldValue(
		Map<String, DDMFormField> ddmFormFieldsMap,
		FormFieldValue formFieldValue, Locale locale) {

		DDMFormFieldValue ddmFormFieldValue = new DDMFormFieldValue();

		ddmFormFieldValue.setName(formFieldValue.getName());

		Value value = _VALUE;

		DDMFormField ddmFormField = ddmFormFieldsMap.get(
			formFieldValue.getName());

		if (ddmFormField != null) {
			value = Optional.ofNullable(
				formFieldValue.getValue()
			).map(
				Object::toString
			).map(
				stringValue -> {
					if (ddmFormField.isLocalizable()) {
						return new LocalizedValue() {
							{
								addString(locale, stringValue);
							}
						};
					}

					return _VALUE;
				}
			).orElse(
				_VALUE
			);
		}

		ddmFormFieldValue.setValue(value);

		return ddmFormFieldValue;
	}

	private static final Value _VALUE = new UnlocalizedValue((String)null);

}