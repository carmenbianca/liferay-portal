/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.filter;

import com.liferay.portal.kernel.search.filter.GeoDistanceFilter;
import com.liferay.portal.kernel.search.geolocation.GeoLocationPoint;

import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = GeoDistanceFilterTranslator.class)
public class GeoDistanceFilterTranslatorImpl
	implements GeoDistanceFilterTranslator {

	@Override
	public QueryBuilder translate(GeoDistanceFilter geoDistanceFilter) {
		GeoDistanceQueryBuilder geoDistanceQueryBuilder =
			QueryBuilders.geoDistanceQuery(geoDistanceFilter.getField());

		geoDistanceQueryBuilder.distance(
			String.valueOf(geoDistanceFilter.getGeoDistance()));

		GeoLocationPoint pinGeoLocationPoint =
			geoDistanceFilter.getPinGeoLocationPoint();

		geoDistanceQueryBuilder.point(
			pinGeoLocationPoint.getLatitude(),
			pinGeoLocationPoint.getLongitude());

		return geoDistanceQueryBuilder;
	}

}