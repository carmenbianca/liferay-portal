/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.filter;

import com.liferay.portal.kernel.search.filter.GeoPolygonFilter;

import org.apache.lucene.search.Query;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(immediate = true, service = GeoPolygonFilterTranslator.class)
public class GeoPolygonFilterTranslatorImpl
	implements GeoPolygonFilterTranslator {

	@Override
	public Query translate(GeoPolygonFilter geoPolygonFilter) {
		throw new UnsupportedOperationException();
	}

}