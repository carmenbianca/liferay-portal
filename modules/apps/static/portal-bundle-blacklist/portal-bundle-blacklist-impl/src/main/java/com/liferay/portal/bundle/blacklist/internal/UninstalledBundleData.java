/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.bundle.blacklist.internal;

import com.liferay.petra.string.StringBundler;

/**
 * @author Matthew Tambara
 */
public class UninstalledBundleData {

	public UninstalledBundleData(String location, int startLevel) {
		_location = location;
		_startLevel = startLevel;
	}

	public String getLocation() {
		return _location;
	}

	public int getStartLevel() {
		return _startLevel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{location=");
		sb.append(_location);
		sb.append(", startLevel=");
		sb.append(_startLevel);
		sb.append("}");

		return sb.toString();
	}

	private final String _location;
	private final int _startLevel;

}