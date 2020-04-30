/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import java.text.DateFormat;

import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Brian Wing Shun Chan
 */
public interface DateFormatFactory {

	public DateFormat getDate(Locale locale);

	public DateFormat getDate(Locale locale, TimeZone timeZone);

	public DateFormat getDate(TimeZone timeZone);

	public DateFormat getDateTime(Locale locale);

	public DateFormat getDateTime(Locale locale, TimeZone timeZone);

	public DateFormat getDateTime(TimeZone timeZone);

	public DateFormat getSimpleDateFormat(String pattern);

	public DateFormat getSimpleDateFormat(String pattern, Locale locale);

	public DateFormat getSimpleDateFormat(
		String pattern, Locale locale, TimeZone timeZone);

	public DateFormat getSimpleDateFormat(String pattern, TimeZone timeZone);

	public DateFormat getTime(Locale locale);

	public DateFormat getTime(Locale locale, TimeZone timeZone);

	public DateFormat getTime(TimeZone timeZone);

}