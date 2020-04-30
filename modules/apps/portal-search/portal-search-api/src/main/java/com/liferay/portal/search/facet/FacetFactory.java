/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.facet;

import com.liferay.portal.kernel.search.SearchContext;

/**
 * @author André de Oliveira
 */
public interface FacetFactory
	extends com.liferay.portal.kernel.search.facet.util.FacetFactory {

	@Override
	public Facet newInstance(SearchContext searchContext);

}