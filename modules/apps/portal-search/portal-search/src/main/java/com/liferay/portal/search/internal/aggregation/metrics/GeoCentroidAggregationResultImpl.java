/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.aggregation.metrics;

import com.liferay.portal.search.aggregation.metrics.GeoCentroidAggregationResult;
import com.liferay.portal.search.geolocation.GeoLocationPoint;
import com.liferay.portal.search.internal.aggregation.BaseAggregationResult;

/**
 * @author Michael C. Han
 */
public class GeoCentroidAggregationResultImpl
	extends BaseAggregationResult implements GeoCentroidAggregationResult {

	public GeoCentroidAggregationResultImpl(
		String name, GeoLocationPoint centroidGeoLocationPoint, long count) {

		super(name);

		_centroidGeoLocationPoint = centroidGeoLocationPoint;
		_count = count;
	}

	@Override
	public GeoLocationPoint getCentroid() {
		return _centroidGeoLocationPoint;
	}

	@Override
	public long getCount() {
		return _count;
	}

	private final GeoLocationPoint _centroidGeoLocationPoint;
	private final long _count;

}