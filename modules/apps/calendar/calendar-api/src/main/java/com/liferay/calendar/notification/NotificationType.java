/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.calendar.notification;

import java.util.Objects;

/**
 * @author Eduardo Lundgren
 */
public enum NotificationType {

	EMAIL("email");

	public static NotificationType parse(String value) {
		if (Objects.equals(EMAIL.getValue(), value)) {
			return EMAIL;
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

	private NotificationType(String value) {
		_value = value;
	}

	private final String _value;

}