/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.filter;

import com.liferay.portal.kernel.search.filter.GeoBoundingBoxFilter;
import com.liferay.portal.kernel.search.geolocation.GeoLocationPoint;

import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.index.query.GeoBoundingBoxQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = GeoBoundingBoxFilterTranslator.class)
public class GeoBoundingBoxFilterTranslatorImpl
	implements GeoBoundingBoxFilterTranslator {

	@Override
	public QueryBuilder translate(GeoBoundingBoxFilter geoBoundingBoxFilter) {
		GeoBoundingBoxQueryBuilder geoBoundingBoxQueryBuilder =
			QueryBuilders.geoBoundingBoxQuery(geoBoundingBoxFilter.getField());

		GeoLocationPoint bottomRightGeoLocationPoint =
			geoBoundingBoxFilter.getBottomRightGeoLocationPoint();

		GeoPoint bottomRightGeoPoint = new GeoPoint(
			bottomRightGeoLocationPoint.getLatitude(),
			bottomRightGeoLocationPoint.getLongitude());

		GeoLocationPoint topLeftGeoLocationPoint =
			geoBoundingBoxFilter.getTopLeftGeoLocationPoint();

		GeoPoint topLeftGeoPoint = new GeoPoint(
			topLeftGeoLocationPoint.getLatitude(),
			topLeftGeoLocationPoint.getLongitude());

		geoBoundingBoxQueryBuilder.setCorners(
			topLeftGeoPoint, bottomRightGeoPoint);

		return geoBoundingBoxQueryBuilder;
	}

}