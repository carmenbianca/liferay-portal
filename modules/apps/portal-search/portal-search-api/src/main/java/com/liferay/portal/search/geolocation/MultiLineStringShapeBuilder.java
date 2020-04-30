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
public interface MultiLineStringShapeBuilder {

	public MultiLineStringShapeBuilder addCoordinate(Coordinate coordinate);

	public MultiLineStringShapeBuilder addLineStringShape(
		LineStringShape lineStringShape);

	public MultiLineStringShape build();

	public MultiLineStringShapeBuilder coordinates(Coordinate... coordinates);

	public MultiLineStringShapeBuilder coordinates(
		List<Coordinate> coordinates);

	public MultiLineStringShapeBuilder lineStringShapes(
		LineStringShape... lineStringShapes);

	public MultiLineStringShapeBuilder lineStringShapes(
		List<LineStringShape> lineStringShapes);

}