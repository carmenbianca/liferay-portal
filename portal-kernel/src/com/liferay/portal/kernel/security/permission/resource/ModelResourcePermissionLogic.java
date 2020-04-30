/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Preston Crary
 */
@FunctionalInterface
public interface ModelResourcePermissionLogic<T extends GroupedModel> {

	public Boolean contains(
			PermissionChecker permissionChecker, String name, T model,
			String actionId)
		throws PortalException;

}