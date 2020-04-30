/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author     Miguel Pastor
 * @deprecated As of Judson (7.1.x), replaced by {@link
 *             com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission}
 */
@Deprecated
public interface BaseModelPermissionChecker {

	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException;

}