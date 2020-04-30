/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.util;

import java.text.NumberFormat;

/**
 * @author Brian Wing Shun Chan
 */
public class NumberFormatUtil {

	public static String format(
		NumberFormat numberFormat, double number, double defaultValue) {

		if (Double.isNaN(number) || Double.isInfinite(number)) {
			return numberFormat.format(defaultValue);
		}

		return numberFormat.format(number);
	}

	public static String format(
		NumberFormat numberFormat, float number, float defaultValue) {

		if (Float.isNaN(number) || Float.isInfinite(number)) {
			return numberFormat.format(defaultValue);
		}

		return numberFormat.format(number);
	}

}