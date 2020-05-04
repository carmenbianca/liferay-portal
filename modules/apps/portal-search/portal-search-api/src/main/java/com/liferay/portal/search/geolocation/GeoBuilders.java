/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.geolocation;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Wade Cao
 * @author André de Oliveira
 */
@ProviderType
public interface GeoBuilders {

	public CircleShape circleShape(
		Coordinate centerCoordinate, GeoDistance radiusGeoDistance);

	public CircleShapeBuilder circleShapeBuilder();

	public Coordinate coordinate(double x, double y);

	public Coordinate coordinate(double x, double y, double z);

	public EnvelopeShape envelopeShape(
		Coordinate topLeftCoordinate, Coordinate bottomRightCoordinate);

	public EnvelopeShapeBuilder envelopeShapeBuilder();

	public GeoDistance geoDistance(double distance);

	public GeoDistance geoDistance(double distance, DistanceUnit distanceUnit);

	public GeoLocationPoint geoLocationPoint(double latitude, double longitude);

	public GeoLocationPoint geoLocationPoint(long geoHash);

	public GeoLocationPoint geoLocationPoint(String geoHash);

	public GeometryCollectionShapeBuilder geometryCollectionShapeBuilder();

	public LineStringShape lineStringShape(List<Coordinate> coordinates);

	public LineStringShapeBuilder lineStringShapeBuilder();

	public MultiLineStringShapeBuilder multiLineStringShapeBuilder();

	public MultiPointShape multiPointShape(List<Coordinate> coordinates);

	public MultiPointShapeBuilder multiPointShapeBuilder();

	public MultiPolygonShape multiPolygonShape(Orientation orientation);

	public MultiPolygonShapeBuilder multiPolygonShapeBuilder();

	public PointShape pointShape(Coordinate coordinate);

	public PointShapeBuilder pointShapeBuilder();

	public PolygonShape polygonShape(
		LineStringShape shellLineStringShape, Orientation orientation);

	public PolygonShapeBuilder polygonShapeBuilder();

}