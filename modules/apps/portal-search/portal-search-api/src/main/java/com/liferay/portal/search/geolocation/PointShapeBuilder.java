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
public interface PointShapeBuilder {

	public PointShapeBuilder addCoordinate(Coordinate coordinate);

	public PointShape build();

	public PointShapeBuilder coordinates(Coordinate... coordinates);

	public PointShapeBuilder coordinates(List<Coordinate> coordinates);

}