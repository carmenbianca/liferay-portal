/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.form.web.internal.security.permission.resource;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Rafael Praxedes
 */
@Component(immediate = true, service = {})
public class DDMFormInstancePermission {

	public static boolean contains(
			PermissionChecker permissionChecker,
			DDMFormInstance ddmFormInstance, String actionId)
		throws PortalException {

		return _ddmFormInstanceModelResourcePermission.contains(
			permissionChecker, ddmFormInstance, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long formInstanceId,
			String actionId)
		throws PortalException {

		return _ddmFormInstanceModelResourcePermission.contains(
			permissionChecker, formInstanceId, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.dynamic.data.mapping.model.DDMFormInstance)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<DDMFormInstance> modelResourcePermission) {

		_ddmFormInstanceModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<DDMFormInstance>
		_ddmFormInstanceModelResourcePermission;

}