/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.rolesadmin.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.membershippolicy.RoleMembershipPolicyUtil;

import javax.portlet.RenderResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Drew Brokke
 */
public class UnsetUserRoleChecker extends EmptyOnClickRowChecker {

	public UnsetUserRoleChecker(RenderResponse renderResponse, Role role) {
		super(renderResponse);

		_role = role;
	}

	@Override
	public boolean isDisabled(Object obj) {
		User user = (User)obj;

		try {
			if (RoleMembershipPolicyUtil.isRoleRequired(
					user.getUserId(), _role.getRoleId())) {

				return true;
			}
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}

		return super.isDisabled(obj);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UnsetUserRoleChecker.class);

	private final Role _role;

}