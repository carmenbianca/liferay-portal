/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.exporter;

import java.util.Objects;

/**
 * @author Marcellus Tavares
 */
public enum CalendarDataFormat {

	ICAL("ics");

	public static CalendarDataFormat parse(String value) {
		if (Objects.equals(ICAL.getValue(), value)) {
			return ICAL;
		}

		throw new IllegalArgumentException("Invalid value " + value);
	}

	public String getValue() {
		return _value;
	}

	@Override
	public String toString() {
		return _value;
	}

	private CalendarDataFormat(String value) {
		_value = value;
	}

	private final String _value;

}