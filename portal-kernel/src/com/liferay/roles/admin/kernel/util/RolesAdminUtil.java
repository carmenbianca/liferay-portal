/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.admin.kernel.util;

import com.liferay.portal.kernel.model.Role;

/**
 * @author Brian Wing Shun Chan
 */
public class RolesAdminUtil {

	public static String getIconCssClass(Role role) {
		return getRolesAdmin().getIconCssClass(role);
	}

	public static RolesAdmin getRolesAdmin() {
		return _rolesAdmin;
	}

	public void setRolesAdmin(RolesAdmin rolesAdmin) {
		_rolesAdmin = rolesAdmin;
	}

	private static RolesAdmin _rolesAdmin;

}