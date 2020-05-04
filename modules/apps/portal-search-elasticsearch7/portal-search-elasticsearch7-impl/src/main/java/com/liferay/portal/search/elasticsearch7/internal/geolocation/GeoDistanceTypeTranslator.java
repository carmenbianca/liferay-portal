/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.geolocation;

import com.liferay.portal.search.geolocation.GeoDistanceType;

import org.elasticsearch.common.geo.GeoDistance;

/**
 * @author Michael C. Han
 */
public class GeoDistanceTypeTranslator {

	public GeoDistance translate(GeoDistanceType geoDistanceType) {
		if (geoDistanceType == GeoDistanceType.ARC) {
			return GeoDistance.ARC;
		}
		else if (geoDistanceType == GeoDistanceType.PLANE) {
			return GeoDistance.PLANE;
		}

		throw new IllegalArgumentException(
			"Invalid GeoDistanceType: " + geoDistanceType);
	}

}