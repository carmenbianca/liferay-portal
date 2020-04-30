/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.field.type.internal.numeric;

import java.text.DecimalFormat;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Rafael Praxedes
 */
public class NumericDDMFormFieldUtil {

	public static DecimalFormat getNumberFormat(Locale locale) {
		DecimalFormat formatter = _decimalFormattersMap.get(locale);

		if (formatter == null) {
			formatter = (DecimalFormat)DecimalFormat.getInstance(locale);

			formatter.setGroupingUsed(false);
			formatter.setMaximumFractionDigits(Integer.MAX_VALUE);
			formatter.setParseBigDecimal(true);

			_decimalFormattersMap.put(locale, formatter);
		}

		return formatter;
	}

	private static final Map<Locale, DecimalFormat> _decimalFormattersMap =
		new ConcurrentHashMap<>();

}