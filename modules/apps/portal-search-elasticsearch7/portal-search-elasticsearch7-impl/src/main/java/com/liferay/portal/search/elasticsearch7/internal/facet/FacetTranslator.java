/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.elasticsearch7.internal.facet;

import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.facet.Facet;

import java.util.Map;

import org.elasticsearch.search.builder.SearchSourceBuilder;

/**
 * @author Michael C. Han
 */
public interface FacetTranslator {

	public void translate(
		SearchSourceBuilder searchSourceBuilder, Query query,
		Map<String, Facet> facetsMap, boolean basicFacetSelection);

}