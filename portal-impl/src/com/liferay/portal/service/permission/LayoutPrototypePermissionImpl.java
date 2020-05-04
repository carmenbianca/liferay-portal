/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.service.permission;

import com.liferay.portal.kernel.model.LayoutPrototype;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.LayoutPrototypePermission;
import com.liferay.registry.collections.ServiceTrackerCollections;
import com.liferay.registry.collections.ServiceTrackerList;

/**
 * @author Jorge Ferrer
 */
public class LayoutPrototypePermissionImpl
	implements LayoutPrototypePermission {

	@Override
	public void check(
			PermissionChecker permissionChecker, long layoutPrototypeId,
			String actionId)
		throws PrincipalException {

		if (!contains(permissionChecker, layoutPrototypeId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, LayoutPrototype.class.getName(),
				layoutPrototypeId, actionId);
		}
	}

	@Override
	public boolean contains(
		PermissionChecker permissionChecker, long layoutPrototypeId,
		String actionId) {

		if (permissionChecker.hasPermission(
				null, LayoutPrototype.class.getName(), layoutPrototypeId,
				actionId)) {

			return true;
		}

		for (LayoutPrototypePermission layoutPrototypePermission :
				_layoutPrototypePermissions) {

			if (layoutPrototypePermission.contains(
					permissionChecker, layoutPrototypeId, actionId)) {

				return true;
			}
		}

		return false;
	}

	private final ServiceTrackerList<LayoutPrototypePermission>
		_layoutPrototypePermissions = ServiceTrackerCollections.openList(
			LayoutPrototypePermission.class, "(extended=true)");

}