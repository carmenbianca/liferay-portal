/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type;

import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Locale;
import java.util.function.IntFunction;

/**
 * @author Marcellus Tavares
 */
public interface DDMFormFieldValueAccessor<T> {

	public default IntFunction<T[]> getArrayGeneratorIntFunction() {
		throw new UnsupportedOperationException(
			"Cannot create an array of a generic type");
	}

	public T getValue(DDMFormFieldValue ddmFormFieldValue, Locale locale);

	public default boolean isEmpty(
		DDMFormFieldValue ddmFormFieldValue, Locale locale) {

		Value value = ddmFormFieldValue.getValue();

		if (value == null) {
			return true;
		}

		String valueString = StringUtil.trim(value.getString(locale));

		return Validator.isNull(valueString);
	}

	public default Object map(Object value) {
		return value;
	}

}