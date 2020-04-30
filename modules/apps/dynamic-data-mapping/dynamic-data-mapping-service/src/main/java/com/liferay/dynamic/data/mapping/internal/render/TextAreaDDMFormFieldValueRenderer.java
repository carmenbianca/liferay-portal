/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.internal.render;

import com.liferay.dynamic.data.mapping.model.DDMFormFieldType;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.List;
import java.util.Locale;

/**
 * @author Marcellus Tavares
 */
public class TextAreaDDMFormFieldValueRenderer
	extends BaseTextDDMFormFieldValueRenderer {

	@Override
	public String getSupportedDDMFormFieldType() {
		return DDMFormFieldType.TEXT_AREA;
	}

	@Override
	public String render(
		List<DDMFormFieldValue> ddmFormFieldValues, Locale locale) {

		String valueRendered = super.render(ddmFormFieldValues, locale);

		return StringUtil.replace(valueRendered, CharPool.NEW_LINE, "<br>");
	}

}