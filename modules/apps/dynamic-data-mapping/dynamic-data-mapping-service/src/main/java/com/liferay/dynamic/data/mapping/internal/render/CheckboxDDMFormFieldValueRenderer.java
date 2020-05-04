/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.render;

import com.liferay.dynamic.data.mapping.model.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.render.BaseDDMFormFieldValueRenderer;
import com.liferay.dynamic.data.mapping.render.ValueAccessor;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.portal.kernel.language.LanguageUtil;

import java.util.Locale;

/**
 * @author Marcellus Tavares
 */
public class CheckboxDDMFormFieldValueRenderer
	extends BaseDDMFormFieldValueRenderer {

	@Override
	public String getSupportedDDMFormFieldType() {
		return DDMFormFieldType.CHECKBOX;
	}

	@Override
	protected ValueAccessor getValueAccessor(Locale locale) {
		return new ValueAccessor(locale) {

			@Override
			public String get(DDMFormFieldValue ddmFormFieldValue) {
				Value value = ddmFormFieldValue.getValue();

				boolean valueBoolean = Boolean.parseBoolean(
					value.getString(locale));

				if (valueBoolean) {
					return LanguageUtil.get(locale, "yes");
				}

				return LanguageUtil.get(locale, "no");
			}

		};
	}

}