/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.internal.geolocation;

import com.liferay.portal.search.geolocation.Coordinate;
import com.liferay.portal.search.geolocation.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Michael C. Han
 */
public abstract class ShapeImpl implements Shape {

	@Override
	public List<Coordinate> getCoordinates() {
		return Collections.unmodifiableList(_coordinates);
	}

	protected void addCoordinate(Coordinate coordinate) {
		_coordinates.add(coordinate);
	}

	protected void setCoordinates(Coordinate... coordinates) {
		_coordinates.clear();

		Collections.addAll(_coordinates, coordinates);
	}

	protected void setCoordinates(List<Coordinate> coordinates) {
		_coordinates.clear();

		_coordinates.addAll(coordinates);
	}

	private final List<Coordinate> _coordinates = new ArrayList<>();

}