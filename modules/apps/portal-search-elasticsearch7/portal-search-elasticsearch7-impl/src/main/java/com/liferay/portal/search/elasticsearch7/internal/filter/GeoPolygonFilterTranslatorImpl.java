/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.filter;

import com.liferay.portal.kernel.search.filter.GeoPolygonFilter;
import com.liferay.portal.kernel.search.geolocation.GeoLocationPoint;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = GeoPolygonFilterTranslator.class)
public class GeoPolygonFilterTranslatorImpl
	implements GeoPolygonFilterTranslator {

	@Override
	public QueryBuilder translate(GeoPolygonFilter geoPolygonFilter) {
		List<GeoPoint> geoPoints = new ArrayList<>();

		for (GeoLocationPoint geoLocationPoint :
				geoPolygonFilter.getGeoLocationPoints()) {

			geoPoints.add(
				new GeoPoint(
					geoLocationPoint.getLatitude(),
					geoLocationPoint.getLongitude()));
		}

		return QueryBuilders.geoPolygonQuery(
			geoPolygonFilter.getField(), geoPoints);
	}

}