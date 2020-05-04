/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.util;

import com.liferay.petra.lang.CentralizedThreadLocal;

import java.util.TimeZone;

/**
 * @author Brian Wing Shun Chan
 */
public class TimeZoneThreadLocal {

	public static TimeZone getDefaultTimeZone() {
		return _defaultTimeZone.get();
	}

	public static TimeZone getThemeDisplayTimeZone() {
		return _themeDisplayTimeZone.get();
	}

	public static void setDefaultTimeZone(TimeZone timeZone) {
		_defaultTimeZone.set(timeZone);
	}

	public static void setThemeDisplayTimeZone(TimeZone timeZone) {
		_themeDisplayTimeZone.set(timeZone);
	}

	private static final ThreadLocal<TimeZone> _defaultTimeZone =
		new CentralizedThreadLocal<>(
			TimeZoneThreadLocal.class + "._defaultTimeZone");
	private static final ThreadLocal<TimeZone> _themeDisplayTimeZone =
		new CentralizedThreadLocal<>(
			TimeZoneThreadLocal.class + "._themeDisplayTimeZone");

}