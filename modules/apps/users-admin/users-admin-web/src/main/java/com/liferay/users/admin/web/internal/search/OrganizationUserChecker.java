/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.web.internal.search;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.exception.NoSuchOrganizationException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.OrganizationServiceUtil;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.service.permission.OrganizationPermissionUtil;
import com.liferay.portal.kernel.service.permission.UserPermissionUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Pei-Jung Lan
 */
public class OrganizationUserChecker extends EmptyOnClickRowChecker {

	public OrganizationUserChecker(RenderResponse renderResponse) {
		super(renderResponse);
	}

	@Override
	public boolean isDisabled(Object obj) {
		Organization organization = null;
		User user = null;

		if (obj instanceof Organization) {
			organization = (Organization)obj;
		}
		else {
			user = (User)obj;
		}

		try {
			PermissionChecker permissionChecker =
				PermissionThreadLocal.getPermissionChecker();

			if ((organization != null) &&
				!OrganizationPermissionUtil.contains(
					permissionChecker, organization, ActionKeys.DELETE)) {

				return true;
			}

			if ((user != null) &&
				!UserPermissionUtil.contains(
					permissionChecker, user.getUserId(), ActionKeys.DELETE)) {

				return true;
			}
		}
		catch (Exception exception) {
		}

		return super.isDisabled(obj);
	}

	@Override
	protected String getRowCheckBox(
		HttpServletRequest httpServletRequest, boolean checked,
		boolean disabled, String name, String value, String checkBoxRowIds,
		String checkBoxAllRowIds, String checkBoxPostOnClick) {

		try {
			long organizationId = GetterUtil.getLong(value);

			OrganizationServiceUtil.getOrganization(organizationId);

			name += Organization.class.getSimpleName();
		}
		catch (Exception exception1) {
			if (exception1 instanceof NoSuchOrganizationException) {
				try {
					long userId = GetterUtil.getLong(value);

					UserServiceUtil.getUserById(userId);

					name += User.class.getSimpleName();
				}
				catch (Exception exception2) {
					return StringPool.BLANK;
				}
			}
		}

		return super.getRowCheckBox(
			httpServletRequest, checked, disabled, name, value, checkBoxRowIds,
			checkBoxAllRowIds, checkBoxPostOnClick);
	}

}