/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.data.provider.web.internal.security.permission.resource;

import com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Praxedes
 */
@Component(immediate = true, service = {})
public class DDMDataProviderInstancePermission {

	public static boolean contains(
			PermissionChecker permissionChecker,
			DDMDataProviderInstance ddmDataProviderInstance, String actionId)
		throws PortalException {

		return _ddmDataProviderInstanceModelResourcePermission.contains(
			permissionChecker, ddmDataProviderInstance, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long dataProviderInstanceId,
			String actionId)
		throws PortalException {

		return _ddmDataProviderInstanceModelResourcePermission.contains(
			permissionChecker, dataProviderInstanceId, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<DDMDataProviderInstance>
			modelResourcePermission) {

		_ddmDataProviderInstanceModelResourcePermission =
			modelResourcePermission;
	}

	private static ModelResourcePermission<DDMDataProviderInstance>
		_ddmDataProviderInstanceModelResourcePermission;

}