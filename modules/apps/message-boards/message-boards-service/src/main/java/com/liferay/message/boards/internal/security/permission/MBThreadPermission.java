/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.internal.security.permission;

import com.liferay.message.boards.model.MBMessage;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.message.boards.model.MBThread",
	service = BaseModelPermissionChecker.class
)
public class MBThreadPermission implements BaseModelPermissionChecker {

	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long messageId,
			String actionId)
		throws PortalException {

		_messageModelResourcePermission.check(
			permissionChecker, messageId, actionId);
	}

	@Reference(
		target = "(model.class.name=com.liferay.message.boards.model.MBMessage)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<MBMessage> modelResourcePermission) {

		_messageModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<MBMessage>
		_messageModelResourcePermission;

}