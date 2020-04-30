/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.radio;

import com.liferay.dynamic.data.mapping.model.DDMFormFieldOptions;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.render.DDMFormFieldRenderingContext;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Marcellus Tavares
 */
public class RadioDDMFormFieldContextHelper {

	public RadioDDMFormFieldContextHelper(
		DDMFormFieldOptions ddmFormFieldOptions, Locale locale) {

		_ddmFormFieldOptions = ddmFormFieldOptions;
		_locale = locale;
	}

	public List<Object> getOptions(
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		List<Object> options = new ArrayList<>();

		for (String optionValue : _ddmFormFieldOptions.getOptionsValues()) {
			Map<String, String> optionMap = HashMapBuilder.put(
				"label",
				() -> {
					LocalizedValue optionLabel =
						_ddmFormFieldOptions.getOptionLabels(optionValue);

					return optionLabel.getString(_locale);
				}
			).put(
				"value", optionValue
			).build();

			options.add(optionMap);
		}

		return options;
	}

	private final DDMFormFieldOptions _ddmFormFieldOptions;
	private final Locale _locale;

}