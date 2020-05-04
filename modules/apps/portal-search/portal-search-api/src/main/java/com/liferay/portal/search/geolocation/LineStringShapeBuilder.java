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
public interface LineStringShapeBuilder {

	public LineStringShapeBuilder addCoordinate(Coordinate coordinate);

	public LineStringShape build();

	public LineStringShapeBuilder coordinates(Coordinate... coordinates);

	public LineStringShapeBuilder coordinates(List<Coordinate> coordinates);

}