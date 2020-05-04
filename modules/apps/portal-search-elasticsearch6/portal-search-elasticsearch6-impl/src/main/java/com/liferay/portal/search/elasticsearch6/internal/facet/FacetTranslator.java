/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch6.internal.facet;

import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.facet.Facet;

import java.util.Map;

import org.elasticsearch.action.search.SearchRequestBuilder;

/**
 * @author Michael C. Han
 */
public interface FacetTranslator {

	public void translate(
		SearchRequestBuilder searchRequestBuilder, Query query,
		Map<String, Facet> facetsMap, boolean basicFacetSelection);

}