/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.geolocation;

import com.liferay.portal.search.geolocation.DistanceUnit;
import com.liferay.portal.search.geolocation.GeoDistance;

/**
 * @author Michael C. Han
 */
public class GeoDistanceImpl implements GeoDistance {

	@Override
	public double getDistance() {
		return _distance;
	}

	@Override
	public DistanceUnit getDistanceUnit() {
		return _distanceUnit;
	}

	@Override
	public String toString() {
		return _distance + _distanceUnit.getUnit();
	}

	protected GeoDistanceImpl(double distance) {
		this(distance, DistanceUnit.METERS);
	}

	protected GeoDistanceImpl(double distance, DistanceUnit distanceUnit) {
		_distance = distance;
		_distanceUnit = distanceUnit;
	}

	private final double _distance;
	private final DistanceUnit _distanceUnit;

}