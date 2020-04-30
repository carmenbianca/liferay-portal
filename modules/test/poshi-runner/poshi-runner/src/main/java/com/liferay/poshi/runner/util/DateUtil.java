/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.poshi.runner.util;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class DateUtil {

	public static String getCurrentDate() {
		return getFormattedCurrentDate("d");
	}

	public static String getCurrentDayOfWeek() {
		return getFormattedCurrentDate("EEEE");
	}

	public static String getCurrentHour() {
		return getFormattedCurrentDate("K");
	}

	public static String getCurrentMonth() {
		return getFormattedCurrentDate("M");
	}

	public static String getCurrentMonthName() {
		return getFormattedCurrentDate("MMMM");
	}

	public static String getCurrentYear() {
		return getFormattedCurrentDate("yyyy");
	}

	public static String getDate(String offsetDays) {
		return getFormattedDate(offsetDays, "d");
	}

	public static String getDayOfWeek(String offsetDays) {
		return getFormattedDate(offsetDays, "EEEE");
	}

	public static String getFormattedCurrentDate(String pattern) {
		return _format(new Date(), pattern);
	}

	public static String getFormattedDate(String offsetDays, String pattern) {
		return _format(_getOffsetDate(Integer.valueOf(offsetDays)), pattern);
	}

	public static String getMonth(String offsetDays) {
		return getFormattedDate(offsetDays, "M");
	}

	public static String getMonthName(String offsetDays) {
		return getFormattedDate(offsetDays, "MMMM");
	}

	public static String getNanoseconds() {
		return String.valueOf(System.nanoTime());
	}

	public static String getTimeInMilliseconds() {
		return String.valueOf(System.currentTimeMillis());
	}

	public static String getYear(String offsetDays) {
		return getFormattedDate(offsetDays, "yyyy");
	}

	private static String _format(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		return simpleDateFormat.format(date);
	}

	private static Date _getOffsetDate(int offsetDays) {
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DATE, offsetDays);

		return calendar.getTime();
	}

}