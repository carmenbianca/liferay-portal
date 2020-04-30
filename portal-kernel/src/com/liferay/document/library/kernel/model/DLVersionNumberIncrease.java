/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.model;

/**
 * @author Adolfo Pérez
 */
public enum DLVersionNumberIncrease {

	AUTOMATIC, MAJOR, MINOR, NONE;

	public static DLVersionNumberIncrease fromMajorVersion(
		boolean majorVersion) {

		if (majorVersion) {
			return MAJOR;
		}

		return MINOR;
	}

	public static DLVersionNumberIncrease valueOf(
		String name, DLVersionNumberIncrease defaultValue) {

		if (name == null) {
			return defaultValue;
		}

		try {
			return valueOf(name);
		}
		catch (IllegalArgumentException illegalArgumentException) {
			return defaultValue;
		}
	}

}