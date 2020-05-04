/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.membershippolicy.OrganizationMembershipPolicyUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.permission.UserPermissionUtil;
import com.liferay.portal.util.PropsValues;

import javax.portlet.RenderResponse;

/**
 * @author Pei-Jung Lan
 */
public class AddUserOrganizationChecker extends EmptyOnClickRowChecker {

	public AddUserOrganizationChecker(
		RenderResponse renderResponse, Organization organization) {

		super(renderResponse);

		_organization = organization;
	}

	@Override
	public boolean isChecked(Object obj) {
		User user = (User)obj;

		try {
			return UserLocalServiceUtil.hasOrganizationUser(
				_organization.getOrganizationId(), user.getUserId());
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			return false;
		}
	}

	@Override
	public boolean isDisabled(Object obj) {
		if (isChecked(obj)) {
			return true;
		}

		if (!PropsValues.ORGANIZATIONS_ASSIGNMENT_STRICT) {
			return false;
		}

		User user = (User)obj;

		try {
			PermissionChecker permissionChecker =
				PermissionThreadLocal.getPermissionChecker();

			if (isChecked(user)) {
				if (OrganizationMembershipPolicyUtil.isMembershipProtected(
						permissionChecker, user.getUserId(),
						_organization.getOrganizationId()) ||
					OrganizationMembershipPolicyUtil.isMembershipRequired(
						user.getUserId(), _organization.getOrganizationId())) {

					return true;
				}
			}
			else {
				if (!OrganizationMembershipPolicyUtil.isMembershipAllowed(
						user.getUserId(), _organization.getOrganizationId())) {

					return true;
				}
			}

			return !UserPermissionUtil.contains(
				permissionChecker, user.getUserId(), ActionKeys.UPDATE);
		}
		catch (Exception exception) {
			_log.error(exception, exception);
		}

		return super.isDisabled(obj);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AddUserOrganizationChecker.class);

	private final Organization _organization;

}