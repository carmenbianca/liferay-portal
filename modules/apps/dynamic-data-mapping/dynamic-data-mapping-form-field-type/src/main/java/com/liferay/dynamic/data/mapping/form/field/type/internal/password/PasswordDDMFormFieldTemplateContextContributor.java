/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.password;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.render.DDMFormFieldRenderingContext;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marcellus Tavares
 */
@Component(
	immediate = true, property = "ddm.form.field.type.name=password",
	service = {
		DDMFormFieldTemplateContextContributor.class,
		PasswordDDMFormFieldTemplateContextContributor.class
	}
)
public class PasswordDDMFormFieldTemplateContextContributor
	implements DDMFormFieldTemplateContextContributor {

	@Override
	public Map<String, Object> getParameters(
		DDMFormField ddmFormField,
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		return HashMapBuilder.<String, Object>put(
			"placeholder",
			getPlaceholder(ddmFormField, ddmFormFieldRenderingContext)
		).put(
			"tooltip", getTooltip(ddmFormField, ddmFormFieldRenderingContext)
		).build();
	}

	protected String getPlaceholder(
		DDMFormField ddmFormField,
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		LocalizedValue placeholder = (LocalizedValue)ddmFormField.getProperty(
			"placeholder");

		return getValueString(
			placeholder, ddmFormFieldRenderingContext.getLocale());
	}

	protected String getTooltip(
		DDMFormField ddmFormField,
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		LocalizedValue tooltip = (LocalizedValue)ddmFormField.getProperty(
			"tooltip");

		return getValueString(
			tooltip, ddmFormFieldRenderingContext.getLocale());
	}

	protected String getValueString(Value value, Locale locale) {
		if (value != null) {
			return value.getString(locale);
		}

		return StringPool.BLANK;
	}

}