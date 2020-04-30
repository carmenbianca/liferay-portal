/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type;

import java.util.Locale;

/**
 * @author Rodrigo Paulino
 */
public interface DDMFormFieldValueLocalizer {

	public String localize(String value, Locale locale);

}