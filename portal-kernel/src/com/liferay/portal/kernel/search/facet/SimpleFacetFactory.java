/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.facet;

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.facet.util.FacetFactory;

/**
 * @author Raymond Augé
 */
public class SimpleFacetFactory implements FacetFactory {

	@Override
	public String getFacetClassName() {
		return SimpleFacet.class.getName();
	}

	@Override
	public Facet newInstance(SearchContext searchContext) {
		return new SimpleFacet(searchContext);
	}

}