/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.internal.data.engine.content.type;

import com.liferay.app.builder.constants.AppBuilderConstants;
import com.liferay.data.engine.content.type.DataDefinitionContentType;
import com.liferay.data.engine.nativeobject.DataEngineNativeObject;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Portal;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jeyvison Nascimento
 */
@Component(
	immediate = true, property = "content.type=native-object",
	service = DataDefinitionContentType.class
)
public class DataEngineNativeObjectDataDefinitionContentType
	implements DataDefinitionContentType {

	@Override
	public long getClassNameId() {
		return _portal.getClassNameId(DataEngineNativeObject.class);
	}

	@Override
	public String getContentType() {
		return "native-object";
	}

	@Override
	public String getPortletResourceName() {
		return AppBuilderConstants.RESOURCE_NAME;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long companyId, long groupId,
			String resourceName, long primKey, long userId, String actionId)
		throws PortalException {

		if (_portletResourcePermission.contains(
				PermissionThreadLocal.getPermissionChecker(), groupId,
				ActionKeys.MANAGE)) {

			return true;
		}

		if (permissionChecker.hasOwnerPermission(
				companyId, resourceName, primKey, userId, actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			groupId, resourceName, primKey, actionId);
	}

	@Override
	public boolean hasPortletPermission(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (_portletResourcePermission.contains(
				PermissionThreadLocal.getPermissionChecker(), groupId,
				ActionKeys.MANAGE)) {

			return true;
		}

		return _portletResourcePermission.contains(
			permissionChecker, groupId, actionId);
	}

	@Reference
	private Portal _portal;

	@Reference(
		target = "(resource.name=" + AppBuilderConstants.RESOURCE_NAME + ")"
	)
	private PortletResourcePermission _portletResourcePermission;

}