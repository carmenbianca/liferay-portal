/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.query;

import com.liferay.portal.search.geolocation.GeoLocationPoint;
import com.liferay.portal.search.query.GeoBoundingBoxQuery;
import com.liferay.portal.search.query.QueryVisitor;
import com.liferay.portal.search.query.geolocation.GeoExecType;
import com.liferay.portal.search.query.geolocation.GeoValidationMethod;

/**
 * @author Michael C. Han
 */
public class GeoBoundingBoxQueryImpl
	extends BaseQueryImpl implements GeoBoundingBoxQuery {

	public GeoBoundingBoxQueryImpl(
		String field, GeoLocationPoint topLeftGeoLocationPoint,
		GeoLocationPoint bottomRightGeoLocationPoint) {

		_field = field;
		_topLeftGeoLocationPoint = topLeftGeoLocationPoint;
		_bottomRightGeoLocationPoint = bottomRightGeoLocationPoint;
	}

	@Override
	public <T> T accept(QueryVisitor<T> queryVisitor) {
		return queryVisitor.visit(this);
	}

	public GeoLocationPoint getBottomRightGeoLocationPoint() {
		return _bottomRightGeoLocationPoint;
	}

	public String getField() {
		return _field;
	}

	public GeoExecType getGeoExecType() {
		return _geoExecType;
	}

	public GeoValidationMethod getGeoValidationMethod() {
		return _geoValidationMethod;
	}

	public Boolean getIgnoreUnmapped() {
		return _ignoreUnmapped;
	}

	public int getSortOrder() {
		return 120;
	}

	public GeoLocationPoint getTopLeftGeoLocationPoint() {
		return _topLeftGeoLocationPoint;
	}

	public void setGeoExecType(GeoExecType geoExecType) {
		_geoExecType = geoExecType;
	}

	public void setGeoValidationMethod(
		GeoValidationMethod geoValidationMethod) {

		_geoValidationMethod = geoValidationMethod;
	}

	public void setIgnoreUnmapped(Boolean ignoreUnmapped) {
		_ignoreUnmapped = ignoreUnmapped;
	}

	private static final long serialVersionUID = 1L;

	private final GeoLocationPoint _bottomRightGeoLocationPoint;
	private final String _field;
	private GeoExecType _geoExecType;
	private GeoValidationMethod _geoValidationMethod;
	private Boolean _ignoreUnmapped;
	private final GeoLocationPoint _topLeftGeoLocationPoint;

}