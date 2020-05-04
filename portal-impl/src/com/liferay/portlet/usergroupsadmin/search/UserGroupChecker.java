/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.usergroupsadmin.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.permission.UserGroupPermissionUtil;

import javax.portlet.RenderResponse;

/**
 * @author Drew Brokke
 */
public class UserGroupChecker extends EmptyOnClickRowChecker {

	public UserGroupChecker(RenderResponse renderResponse) {
		super(renderResponse);
	}

	@Override
	public boolean isDisabled(Object obj) {
		UserGroup userGroup = (UserGroup)obj;

		if (!UserGroupPermissionUtil.contains(
				PermissionThreadLocal.getPermissionChecker(),
				userGroup.getUserGroupId(), ActionKeys.DELETE)) {

			return true;
		}

		return super.isDisabled(obj);
	}

}