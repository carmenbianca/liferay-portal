/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.search;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;

/**
 * @author Mika Koivisto
 */
public interface RepositorySearchQueryBuilder {

	public BooleanQuery getFullQuery(SearchContext searchContext)
		throws SearchException;

}