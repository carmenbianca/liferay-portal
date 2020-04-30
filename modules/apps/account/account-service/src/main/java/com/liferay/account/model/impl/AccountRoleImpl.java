/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class AccountRoleImpl extends AccountRoleBaseImpl {

	public AccountRoleImpl() {
	}

	@Override
	public Role getRole() throws PortalException {
		return RoleLocalServiceUtil.getRole(getRoleId());
	}

	@Override
	public String getRoleName() throws PortalException {
		Role role = getRole();

		return role.getName();
	}

}