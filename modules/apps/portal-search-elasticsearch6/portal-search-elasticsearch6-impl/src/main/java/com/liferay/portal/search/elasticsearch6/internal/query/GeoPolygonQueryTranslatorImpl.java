/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.search.elasticsearch6.internal.geolocation.GeoLocationPointTranslator;
import com.liferay.portal.search.elasticsearch6.internal.query.geolocation.GeoValidationMethodTranslator;
import com.liferay.portal.search.geolocation.GeoLocationPoint;
import com.liferay.portal.search.query.GeoPolygonQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.index.query.GeoPolygonQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = GeoPolygonQueryTranslator.class)
public class GeoPolygonQueryTranslatorImpl
	implements GeoPolygonQueryTranslator {

	@Override
	public QueryBuilder translate(GeoPolygonQuery geoPolygonQuery) {
		Set<GeoLocationPoint> geoLocationPoints =
			geoPolygonQuery.getGeoLocationPoints();

		Stream<GeoLocationPoint> stream = geoLocationPoints.stream();

		List<GeoPoint> geoPoints = stream.map(
			GeoLocationPointTranslator::translate
		).collect(
			Collectors.toList()
		);

		GeoPolygonQueryBuilder geoPolygonQueryBuilder =
			QueryBuilders.geoPolygonQuery(
				geoPolygonQuery.getField(), geoPoints);

		if (geoPolygonQuery.getGeoValidationMethod() != null) {
			geoPolygonQueryBuilder.setValidationMethod(
				_geoValidationMethodTranslator.translate(
					geoPolygonQuery.getGeoValidationMethod()));
		}

		if (geoPolygonQuery.getIgnoreUnmapped() != null) {
			geoPolygonQueryBuilder.ignoreUnmapped(
				geoPolygonQuery.getIgnoreUnmapped());
		}

		return geoPolygonQueryBuilder;
	}

	private final GeoValidationMethodTranslator _geoValidationMethodTranslator =
		new GeoValidationMethodTranslator();

}