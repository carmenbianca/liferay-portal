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
public interface CircleShapeBuilder {

	public CircleShapeBuilder addCoordinate(Coordinate coordinate);

	public CircleShape build();

	public CircleShapeBuilder center(Coordinate coordinate);

	public CircleShapeBuilder coordinates(Coordinate... coordinates);

	public CircleShapeBuilder coordinates(List<Coordinate> coordinates);

	public CircleShapeBuilder radius(GeoDistance geoDistance);

}