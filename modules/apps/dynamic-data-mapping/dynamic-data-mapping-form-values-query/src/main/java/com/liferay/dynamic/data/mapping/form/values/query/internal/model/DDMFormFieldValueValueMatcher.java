/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.values.query.internal.model;

import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;

import java.util.Locale;

/**
 * @author Pablo Carvalho
 */
public class DDMFormFieldValueValueMatcher implements DDMFormFieldValueMatcher {

	@Override
	public boolean matches(DDMFormFieldValue ddmFormFieldValue) {
		if (_locale != null) {
			return performLocalizedMatch(ddmFormFieldValue.getValue());
		}

		return performUnlocalizedMatch(ddmFormFieldValue.getValue());
	}

	public void setLocale(Locale locale) {
		_locale = locale;
	}

	public void setValue(String value) {
		_value = value;
	}

	protected boolean performLocalizedMatch(Value value) {
		return _value.equals(value.getString(_locale));
	}

	protected boolean performUnlocalizedMatch(Value value) {
		for (Locale locale : value.getAvailableLocales()) {
			if (_value.equals(value.getString(locale))) {
				return true;
			}
		}

		return false;
	}

	private Locale _locale;
	private String _value;

}