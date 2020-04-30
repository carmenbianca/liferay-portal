/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.recurrence;

import java.util.Calendar;

/**
 * @author Marcellus Tavares
 */
public class PositionalWeekday {

	public PositionalWeekday(Calendar calendar) {
		this(
			Weekday.getWeekday(calendar),
			calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
	}

	public PositionalWeekday(Weekday weekday, int position) {
		if ((position < -53) || (position > 53)) {
			throw new IllegalArgumentException();
		}

		_weekday = weekday;
		_position = position;
	}

	public int getPosition() {
		return _position;
	}

	public Weekday getWeekday() {
		return _weekday;
	}

	private final int _position;
	private final Weekday _weekday;

}