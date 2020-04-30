/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type;

import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.petra.string.StringPool;

import java.util.Locale;
import java.util.function.IntFunction;

/**
 * @author Marcellus Tavares
 */
public class DefaultDDMFormFieldValueAccessor
	implements DDMFormFieldValueAccessor<String> {

	@Override
	public IntFunction<String[]> getArrayGeneratorIntFunction() {
		return String[]::new;
	}

	@Override
	public String getValue(DDMFormFieldValue ddmFormFieldValue, Locale locale) {
		Value value = ddmFormFieldValue.getValue();

		if (value == null) {
			return StringPool.BLANK;
		}

		return value.getString(locale);
	}

}