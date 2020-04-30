/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type;

import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;

import java.util.Locale;

/**
 * @author Marcellus Tavares
 */
public interface DDMFormFieldValueRenderer {

	public String render(DDMFormFieldValue ddmFormFieldValue, Locale locale);

}