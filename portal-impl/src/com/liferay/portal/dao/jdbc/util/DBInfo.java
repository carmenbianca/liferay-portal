/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.dao.jdbc.util;

/**
 * @author Shuyang Zhou
 */
public class DBInfo {

	public DBInfo(
		String name, String driverName, int majorVersion, int minorVersion) {

		_name = name;
		_driverName = driverName;
		_majorVersion = majorVersion;
		_minorVersion = minorVersion;
	}

	public String getDriverName() {
		return _driverName;
	}

	public int getMajorVersion() {
		return _majorVersion;
	}

	public int getMinorVersion() {
		return _minorVersion;
	}

	public String getName() {
		return _name;
	}

	private final String _driverName;
	private final int _majorVersion;
	private final int _minorVersion;
	private final String _name;

}