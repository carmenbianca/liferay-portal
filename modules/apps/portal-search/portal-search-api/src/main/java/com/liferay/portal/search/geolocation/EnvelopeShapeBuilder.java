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
public interface EnvelopeShapeBuilder {

	public EnvelopeShapeBuilder addCoordinate(Coordinate coordinate);

	public EnvelopeShapeBuilder bottomRight(Coordinate coordinate);

	public EnvelopeShape build();

	public EnvelopeShapeBuilder coordinates(Coordinate... coordinates);

	public EnvelopeShapeBuilder coordinates(List<Coordinate> coordinates);

	public EnvelopeShapeBuilder topLeft(Coordinate coordinate);

}