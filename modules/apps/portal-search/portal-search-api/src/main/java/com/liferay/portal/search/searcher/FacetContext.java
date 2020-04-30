/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.searcher;

import com.liferay.portal.kernel.search.facet.Facet;

/**
 * @author André de Oliveira
 */
public interface FacetContext {

	public void addFacet(Facet facet);

	public Facet getFacet(String aggregationName);

}