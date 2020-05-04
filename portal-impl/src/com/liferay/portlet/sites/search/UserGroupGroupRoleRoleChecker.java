/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.sites.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.UserGroupGroupRoleLocalServiceUtil;

import javax.portlet.RenderResponse;

/**
 * @author Brett Swaim
 */
public class UserGroupGroupRoleRoleChecker extends EmptyOnClickRowChecker {

	public UserGroupGroupRoleRoleChecker(
		RenderResponse renderResponse, UserGroup userGroup, Group group) {

		super(renderResponse);

		_userGroup = userGroup;
		_group = group;
	}

	@Override
	public boolean isChecked(Object obj) {
		Role role = (Role)obj;

		try {
			return UserGroupGroupRoleLocalServiceUtil.hasUserGroupGroupRole(
				_userGroup.getUserGroupId(), _group.getGroupId(),
				role.getRoleId());
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			return false;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserGroupGroupRoleRoleChecker.class);

	private final Group _group;
	private final UserGroup _userGroup;

}