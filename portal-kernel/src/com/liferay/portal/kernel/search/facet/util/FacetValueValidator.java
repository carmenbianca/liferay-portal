/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search.facet.util;

import com.liferay.portal.kernel.search.SearchContext;

/**
 * @author Raymond Augé
 */
public interface FacetValueValidator {

	public boolean check(SearchContext searchContext, String primKey);

}