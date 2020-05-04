/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.solr7.internal.filter;

import com.liferay.portal.kernel.search.filter.GeoBoundingBoxFilter;

import org.apache.lucene.search.Query;

/**
 * @author Michael C. Han
 */
public interface GeoBoundingBoxFilterTranslator {

	public Query translate(GeoBoundingBoxFilter geoBoundingBoxFilter);

}