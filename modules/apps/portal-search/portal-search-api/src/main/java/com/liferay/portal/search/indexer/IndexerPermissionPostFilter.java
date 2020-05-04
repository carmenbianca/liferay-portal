/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.indexer;

import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface IndexerPermissionPostFilter {

	public boolean hasPermission(
		PermissionChecker permissionChecker, long entryClassPK);

	public boolean isPermissionAware();

	public boolean isVisible(long classPK, int status);

}