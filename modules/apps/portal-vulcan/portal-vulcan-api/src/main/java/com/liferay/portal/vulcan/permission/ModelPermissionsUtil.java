/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceAction;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.ResourceActionLocalService;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.service.permission.ModelPermissionsFactory;

import java.util.List;

/**
 * @author Javier Gamarra
 */
public class ModelPermissionsUtil {

	public static ModelPermissions toModelPermissions(
			long companyId, Permission[] permissions, long primKey,
			String resourceName,
			ResourceActionLocalService resourceActionLocalService,
			ResourcePermissionLocalService resourcePermissionLocalService,
			RoleLocalService roleLocalService)
		throws PortalException {

		ModelPermissions modelPermissions = ModelPermissionsFactory.create(
			new String[0], new String[0], resourceName);

		for (Permission permission : permissions) {
			String[] actionIds = permission.getActionIds();

			if (actionIds.length > 0) {
				modelPermissions.addRolePermissions(
					permission.getRoleName(), permission.getActionIds());

				continue;
			}

			List<ResourceAction> resourceActions =
				resourceActionLocalService.getResourceActions(resourceName);

			Role role = roleLocalService.getRole(
				companyId, permission.getRoleName());

			for (ResourceAction resourceAction : resourceActions) {
				resourcePermissionLocalService.removeResourcePermission(
					companyId, resourceName, ResourceConstants.SCOPE_INDIVIDUAL,
					String.valueOf(primKey), role.getRoleId(),
					resourceAction.getActionId());
			}
		}

		return modelPermissions;
	}

}