/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.geolocation;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author André de Oliveira
 */
@ProviderType
public interface GeometryCollectionShapeBuilder {

	public GeometryCollectionShapeBuilder addCoordinate(Coordinate coordinate);

	public GeometryCollectionShapeBuilder addShape(Shape shape);

	public GeometryCollectionShape build();

	public GeometryCollectionShapeBuilder coordinates(
		Coordinate... coordinates);

	public GeometryCollectionShapeBuilder coordinates(
		List<Coordinate> coordinates);

	public GeometryCollectionShapeBuilder shapes(Shape... shapes);

}