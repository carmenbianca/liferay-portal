/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for Permission. This utility wraps
 * <code>com.liferay.portal.service.impl.PermissionServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PermissionService
 * @generated
 */
public class PermissionServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.PermissionServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Checks to see if the group has permission to the service.
	 *
	 * @param groupId the primary key of the group
	 * @param name the service name
	 * @param primKey the primary key of the service
	 */
	public static void checkPermission(long groupId, String name, long primKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().checkPermission(groupId, name, primKey);
	}

	/**
	 * Checks to see if the group has permission to the service.
	 *
	 * @param groupId the primary key of the group
	 * @param name the service name
	 * @param primKey the primary key of the service
	 */
	public static void checkPermission(
			long groupId, String name, String primKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().checkPermission(groupId, name, primKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static PermissionService getService() {
		if (_service == null) {
			_service = (PermissionService)PortalBeanLocatorUtil.locate(
				PermissionService.class.getName());
		}

		return _service;
	}

	private static PermissionService _service;

}