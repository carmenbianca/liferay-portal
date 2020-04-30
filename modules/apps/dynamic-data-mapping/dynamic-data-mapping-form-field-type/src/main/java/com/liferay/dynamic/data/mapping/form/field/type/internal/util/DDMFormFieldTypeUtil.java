/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.util;

import com.liferay.dynamic.data.mapping.model.DDMFormField;
import com.liferay.dynamic.data.mapping.model.LocalizedValue;
import com.liferay.dynamic.data.mapping.render.DDMFormFieldRenderingContext;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Locale;

/**
 * @author Marcela Cunha
 */
public class DDMFormFieldTypeUtil {

	public static String getPropertyValue(
		DDMFormField ddmFormField, Locale locale, String propertyName) {

		LocalizedValue value = (LocalizedValue)ddmFormField.getProperty(
			propertyName);

		if (value == null) {
			return StringPool.BLANK;
		}

		return GetterUtil.getString(value.getString(locale));
	}

	public static String getPropertyValue(
		DDMFormFieldRenderingContext ddmFormFieldRenderingContext,
		String propertyName) {

		return GetterUtil.getString(
			ddmFormFieldRenderingContext.getProperty(propertyName));
	}

}