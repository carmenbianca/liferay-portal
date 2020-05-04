/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portlet.rolesadmin.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;

import javax.portlet.RenderResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class OrganizationRoleChecker extends EmptyOnClickRowChecker {

	public OrganizationRoleChecker(RenderResponse renderResponse, Role role) {
		super(renderResponse);

		_role = role;
	}

	@Override
	public boolean isChecked(Object obj) {
		Organization organization = (Organization)obj;

		try {
			Group group = organization.getGroup();

			return GroupLocalServiceUtil.hasRoleGroup(
				_role.getRoleId(), group.getGroupId());
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			return false;
		}
	}

	@Override
	public boolean isDisabled(Object obj) {
		Organization organization = (Organization)obj;

		return isChecked(organization);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		OrganizationRoleChecker.class);

	private final Role _role;

}