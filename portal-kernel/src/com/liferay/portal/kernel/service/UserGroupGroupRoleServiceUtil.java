/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for UserGroupGroupRole. This utility wraps
 * <code>com.liferay.portal.service.impl.UserGroupGroupRoleServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupGroupRoleService
 * @generated
 */
public class UserGroupGroupRoleServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.UserGroupGroupRoleServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addUserGroupGroupRoles(
			long userGroupId, long groupId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addUserGroupGroupRoles(userGroupId, groupId, roleIds);
	}

	public static void addUserGroupGroupRoles(
			long[] userGroupIds, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addUserGroupGroupRoles(userGroupIds, groupId, roleId);
	}

	public static void deleteUserGroupGroupRoles(
			long userGroupId, long groupId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteUserGroupGroupRoles(userGroupId, groupId, roleIds);
	}

	public static void deleteUserGroupGroupRoles(
			long[] userGroupIds, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteUserGroupGroupRoles(userGroupIds, groupId, roleId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static UserGroupGroupRoleService getService() {
		if (_service == null) {
			_service = (UserGroupGroupRoleService)PortalBeanLocatorUtil.locate(
				UserGroupGroupRoleService.class.getName());
		}

		return _service;
	}

	private static UserGroupGroupRoleService _service;

}