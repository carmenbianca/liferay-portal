/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.facet.util.comparator;

import com.liferay.portal.search.web.facet.SearchFacet;

import java.util.Comparator;

/**
 * @author Shuyang Zhou
 */
public class SearchFacetComparator implements Comparator<SearchFacet> {

	public static final Comparator<SearchFacet> INSTANCE =
		new SearchFacetComparator();

	@Override
	public int compare(SearchFacet searchFacet1, SearchFacet searchFacet2) {
		return Double.compare(
			searchFacet2.getWeight(), searchFacet1.getWeight());
	}

	private SearchFacetComparator() {
	}

}