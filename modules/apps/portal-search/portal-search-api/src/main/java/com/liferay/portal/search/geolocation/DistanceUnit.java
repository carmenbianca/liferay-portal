/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.geolocation;

/**
 * @author Michael C. Han
 */
public enum DistanceUnit {

	CENTIMETERS("cm"), FEET("ft"), INCHES("in"), KILOMETERS("km"), METERS("m"),
	MILES("mi"), MILLIMETERS("mm"), YARDS("yd");

	public String getUnit() {
		return _unit;
	}

	@Override
	public String toString() {
		return _unit;
	}

	private DistanceUnit(String unit) {
		_unit = unit;
	}

	private final String _unit;

}