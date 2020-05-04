/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.query.geolocation;

import com.liferay.portal.search.query.geolocation.GeoExecType;

/**
 * @author Michael C. Han
 */
public class GeoExecTypeTranslator {

	public org.elasticsearch.index.query.GeoExecType translate(
		GeoExecType geoExecType) {

		if (geoExecType == GeoExecType.INDEXED) {
			return org.elasticsearch.index.query.GeoExecType.INDEXED;
		}
		else if (geoExecType == GeoExecType.MEMORY) {
			return org.elasticsearch.index.query.GeoExecType.MEMORY;
		}

		throw new IllegalArgumentException(
			"Invalid GeoExecType: " + geoExecType);
	}

}