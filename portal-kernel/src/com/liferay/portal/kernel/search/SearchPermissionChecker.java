/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.search.filter.BooleanFilter;

/**
 * @author Allen Chiang
 * @author Bruno Farache
 * @author Raymond Augé
 */
public interface SearchPermissionChecker {

	public void addPermissionFields(long companyId, Document doc);

	public BooleanFilter getPermissionBooleanFilter(
		long companyId, long[] groupIds, long userId, String className,
		BooleanFilter booleanFilter, SearchContext searchContext);

	public void updatePermissionFields(String name, String primKey);

}