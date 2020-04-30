/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for UserGroupRole. This utility wraps
 * <code>com.liferay.portal.service.impl.UserGroupRoleServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupRoleService
 * @generated
 */
public class UserGroupRoleServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.UserGroupRoleServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addUserGroupRoles(
			long userId, long groupId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addUserGroupRoles(userId, groupId, roleIds);
	}

	public static void addUserGroupRoles(
			long[] userIds, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addUserGroupRoles(userIds, groupId, roleId);
	}

	public static void deleteUserGroupRoles(
			long userId, long groupId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteUserGroupRoles(userId, groupId, roleIds);
	}

	public static void deleteUserGroupRoles(
			long[] userIds, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteUserGroupRoles(userIds, groupId, roleId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void updateUserGroupRoles(
			long userId, long groupId, long[] addedRoleIds,
			long[] deletedRoleIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateUserGroupRoles(
			userId, groupId, addedRoleIds, deletedRoleIds);
	}

	public static UserGroupRoleService getService() {
		if (_service == null) {
			_service = (UserGroupRoleService)PortalBeanLocatorUtil.locate(
				UserGroupRoleService.class.getName());
		}

		return _service;
	}

	private static UserGroupRoleService _service;

}