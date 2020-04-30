/*
 * SPDX-FileCopyrightText: © 2015 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.util;

import com.liferay.portal.kernel.search.SearchContext;

/**
 * @author Manuel de la Peña
 */
public class SearchContextTestUtil {

	public static SearchContext getSearchContext() throws Exception {
		return getSearchContext(TestPropsValues.getGroupId());
	}

	public static SearchContext getSearchContext(long groupId)
		throws Exception {

		SearchContext searchContext = new SearchContext();

		searchContext.setCompanyId(TestPropsValues.getCompanyId());
		searchContext.setGroupIds(new long[] {groupId});
		searchContext.setUserId(TestPropsValues.getUserId());

		return searchContext;
	}

}