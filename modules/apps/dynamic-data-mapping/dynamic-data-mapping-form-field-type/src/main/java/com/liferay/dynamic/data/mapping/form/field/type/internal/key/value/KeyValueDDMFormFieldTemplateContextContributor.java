/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.key.value;

import com.liferay.dynamic.data.mapping.form.field.type.DDMFormFieldTemplateContextContributor;
import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.model.Value;
import com.liferay.dynamic.data.mapping.render.DDMFormFieldRenderingContext;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Marcellus Tavares
 */
@Component(
	immediate = true, property = "ddm.form.field.type.name=key_value",
	service = {
		DDMFormFieldTemplateContextContributor.class,
		KeyValueDDMFormFieldTemplateContextContributor.class
	}
)
public class KeyValueDDMFormFieldTemplateContextContributor
	implements DDMFormFieldTemplateContextContributor {

	@Override
	public Map<String, Object> getParameters(
		DDMFormField ddmFormField,
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext) {

		Locale locale = ddmFormFieldRenderingContext.getLocale();

		return HashMapBuilder.<String, Object>put(
			"autoFocus",
			GetterUtil.getBoolean(ddmFormField.getProperty("autoFocus"))
		).put(
			"placeholder",
			getValueString(
				(LocalizedValue)ddmFormField.getProperty("placeholder"), locale)
		).put(
			"strings",
			HashMapBuilder.put(
				"keyLabel",
				LanguageUtil.get(
					getDisplayLocale(
						ddmFormFieldRenderingContext.getHttpServletRequest()),
					"field-name")
			).build()
		).put(
			"tooltip",
			getValueString(
				(LocalizedValue)ddmFormField.getProperty("tooltip"), locale)
		).build();
	}

	protected Locale getDisplayLocale(HttpServletRequest httpServletRequest) {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		return themeDisplay.getLocale();
	}

	protected String getValueString(Value value, Locale locale) {
		if (value != null) {
			return value.getString(locale);
		}

		return StringPool.BLANK;
	}

}