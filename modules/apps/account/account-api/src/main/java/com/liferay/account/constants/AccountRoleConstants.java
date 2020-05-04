/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.constants;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.util.ArrayUtil;

/**
 * @author Drew Brokke
 */
public class AccountRoleConstants {

	public static final String REQUIRED_ROLE_NAME_ACCOUNT_ADMINISTRATOR =
		"Account Administrator";

	public static final String REQUIRED_ROLE_NAME_ACCOUNT_OWNER =
		"Account Owner";

	public static final String REQUIRED_ROLE_NAME_ACCOUNT_POWER_USER =
		"Account Power User";

	public static final String REQUIRED_ROLE_NAME_ACCOUNT_USER = "Account User";

	public static final String[] REQUIRED_ROLE_NAMES = {
		REQUIRED_ROLE_NAME_ACCOUNT_USER, REQUIRED_ROLE_NAME_ACCOUNT_POWER_USER,
		REQUIRED_ROLE_NAME_ACCOUNT_OWNER,
		REQUIRED_ROLE_NAME_ACCOUNT_ADMINISTRATOR
	};

	public static boolean isRequiredRole(Role role) {
		return ArrayUtil.contains(REQUIRED_ROLE_NAMES, role.getName());
	}

	public static boolean isSharedRole(Role role) {
		if (role.getType() == RoleConstants.TYPE_ACCOUNT) {
			return true;
		}

		return false;
	}

}