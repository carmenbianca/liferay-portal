/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.radio;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldValueAccessor;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;

import java.util.Locale;
import java.util.function.IntFunction;

import org.osgi.service.component.annotations.Component;

/**
 * @author Renato Rego
 */
@Component(
	immediate = true, property = "ddm.form.field.type.name=radio",
	service = {
		DDMFormFieldValueAccessor.class, RadioDDMFormFieldValueAccessor.class
	}
)
public class RadioDDMFormFieldValueAccessor
	implements DDMFormFieldValueAccessor<String> {

	@Override
	public IntFunction<String[]> getArrayGeneratorIntFunction() {
		return String[]::new;
	}

	@Override
	public String getValue(DDMFormFieldValue ddmFormFieldValue, Locale locale) {
		Value value = ddmFormFieldValue.getValue();

		return value.getString(locale);
	}

}