/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.query;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.search.geolocation.GeoDistance;
import com.liferay.portal.search.query.GeoDistanceRangeQuery;
import com.liferay.portal.search.query.geolocation.ShapeRelation;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = GeoDistanceRangeQueryTranslator.class)
public class GeoDistanceRangeQueryTranslatorImpl
	implements GeoDistanceRangeQueryTranslator {

	@Override
	public QueryBuilder translate(GeoDistanceRangeQuery geoDistanceRangeQuery) {
		RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery(
			geoDistanceRangeQuery.getField());

		GeoDistance geoDistanceLowerBound =
			geoDistanceRangeQuery.getLowerBoundGeoDistance();

		rangeQueryBuilder.from(geoDistanceLowerBound.toString());

		rangeQueryBuilder.includeLower(geoDistanceRangeQuery.isIncludesLower());
		rangeQueryBuilder.includeUpper(geoDistanceRangeQuery.isIncludesUpper());

		GeoDistance geoDistanceUpperBound =
			geoDistanceRangeQuery.getUpperBoundGeoDistance();

		rangeQueryBuilder.to(geoDistanceUpperBound.toString());

		if (geoDistanceRangeQuery.getShapeRelation() != null) {
			ShapeRelation shapeRelation =
				geoDistanceRangeQuery.getShapeRelation();

			String shapeRelationName = shapeRelation.name();

			rangeQueryBuilder.relation(
				StringUtil.toLowerCase(shapeRelationName));
		}

		return rangeQueryBuilder;
	}

}