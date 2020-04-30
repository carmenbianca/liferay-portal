/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.facet.faceted.searcher;

import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author André de Oliveira
 */
public class FacetedSearcherManagerUtil {

	public static FacetedSearcher createFacetedSearcher() {
		return _facetedSearcherManager.createFacetedSearcher();
	}

	private static volatile FacetedSearcherManager _facetedSearcherManager =
		ServiceProxyFactory.newServiceTrackedInstance(
			FacetedSearcherManager.class, FacetedSearcherManagerUtil.class,
			"_facetedSearcherManager", false);

}