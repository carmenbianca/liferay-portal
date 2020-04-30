/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.search;

import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Eric Yan
 */
public interface SearchResultPermissionFilterFactory {

	public SearchResultPermissionFilter create(
		SearchResultPermissionFilterSearcher
			searchResultPermissionFilterSearcher,
		PermissionChecker permissionChecker);

}