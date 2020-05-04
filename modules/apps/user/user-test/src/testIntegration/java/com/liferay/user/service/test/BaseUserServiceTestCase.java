/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.user.service.test;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactory;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.test.rule.Inject;

/**
 * @author Brian Wing Shun Chan
 * @author José Manuel Navarro
 * @author Drew Brokke
 */
public abstract class BaseUserServiceTestCase {

	protected void unsetGroupUsers(
			long groupId, User subjectUser, User objectUser)
		throws Exception {

		PermissionChecker permissionChecker = _permissionCheckerFactory.create(
			subjectUser);

		PermissionThreadLocal.setPermissionChecker(permissionChecker);

		ServiceContext serviceContext = new ServiceContext();

		_userService.unsetGroupUsers(
			groupId, new long[] {objectUser.getUserId()}, serviceContext);
	}

	protected void unsetOrganizationUsers(
			long organizationId, User subjectUser, User objectUser)
		throws Exception {

		PermissionChecker permissionChecker = _permissionCheckerFactory.create(
			subjectUser);

		PermissionThreadLocal.setPermissionChecker(permissionChecker);

		_userService.unsetOrganizationUsers(
			organizationId, new long[] {objectUser.getUserId()});
	}

	@Inject
	protected UserLocalService userLocalService;

	@Inject
	private PermissionCheckerFactory _permissionCheckerFactory;

	@Inject
	private UserService _userService;

}