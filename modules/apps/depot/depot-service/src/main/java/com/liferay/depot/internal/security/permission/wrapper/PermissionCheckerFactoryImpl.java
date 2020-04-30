/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.depot.internal.security.permission.wrapper;

import com.liferay.depot.configuration.DepotConfiguration;
import com.liferay.depot.model.DepotEntry;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.wrapper.PermissionCheckerWrapperFactory;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Cristina Gonzálaez
 */
@Component(
	property = "service.ranking:Integer=100",
	service = PermissionCheckerWrapperFactory.class
)
public class PermissionCheckerFactoryImpl
	implements PermissionCheckerWrapperFactory {

	@Override
	public PermissionChecker wrapPermissionChecker(
		PermissionChecker permissionChecker) {

		if (!_depotConfiguration.isEnabled()) {
			return permissionChecker;
		}

		return new DepotPermissionCheckerWrapper(
			permissionChecker, _depotEntryModelResourcePermission,
			_groupLocalService, _roleLocalService, _userGroupRoleLocalService);
	}

	@Reference
	private DepotConfiguration _depotConfiguration;

	@Reference(target = "(model.class.name=com.liferay.depot.model.DepotEntry)")
	private ModelResourcePermission<DepotEntry>
		_depotEntryModelResourcePermission;

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private RoleLocalService _roleLocalService;

	@Reference
	private UserGroupRoleLocalService _userGroupRoleLocalService;

}