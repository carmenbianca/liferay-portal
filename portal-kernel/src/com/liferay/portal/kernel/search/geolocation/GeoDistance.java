/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.geolocation;

/**
 * @author Michael C. Han
 */
public class GeoDistance {

	public GeoDistance(double distance) {
		this(distance, DistanceUnit.METERS);
	}

	public GeoDistance(double distance, DistanceUnit distanceUnit) {
		_distance = distance;
		_distanceUnit = distanceUnit;
	}

	public double getDistance() {
		return _distance;
	}

	public DistanceUnit getDistanceUnit() {
		return _distanceUnit;
	}

	@Override
	public String toString() {
		return _distance + _distanceUnit.toString();
	}

	private final double _distance;
	private final DistanceUnit _distanceUnit;

}