/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.sites.search;

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.membershippolicy.OrganizationMembershipPolicyUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;

import javax.portlet.RenderResponse;

/**
 * @author Roberto Díaz
 */
public class OrganizationRoleUserChecker extends RowChecker {

	public OrganizationRoleUserChecker(
		RenderResponse renderResponse, Organization organization, Role role) {

		super(renderResponse);

		_organization = organization;
		_role = role;
	}

	@Override
	public boolean isChecked(Object obj) {
		User user = (User)obj;

		try {
			return UserGroupRoleLocalServiceUtil.hasUserGroupRole(
				user.getUserId(), _organization.getGroupId(),
				_role.getRoleId());
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			return false;
		}
	}

	@Override
	public boolean isDisabled(Object obj) {
		User user = (User)obj;

		try {
			if (isChecked(user)) {
				if (OrganizationMembershipPolicyUtil.isRoleProtected(
						PermissionThreadLocal.getPermissionChecker(),
						user.getUserId(), _organization.getOrganizationId(),
						_role.getRoleId()) ||
					OrganizationMembershipPolicyUtil.isRoleRequired(
						user.getUserId(), _organization.getOrganizationId(),
						_role.getRoleId())) {

					return true;
				}
			}
			else {
				if (!OrganizationMembershipPolicyUtil.isRoleAllowed(
						user.getUserId(), _organization.getOrganizationId(),
						_role.getRoleId())) {

					return true;
				}
			}
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}

		return super.isDisabled(obj);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		OrganizationRoleUserChecker.class);

	private final Organization _organization;
	private final Role _role;

}