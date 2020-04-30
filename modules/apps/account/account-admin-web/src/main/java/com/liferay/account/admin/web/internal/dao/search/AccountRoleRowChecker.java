/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.dao.search;

import com.liferay.account.admin.web.internal.display.AccountRoleDisplay;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;

import javax.portlet.PortletResponse;

/**
 * @author Pei-Jung Lan
 */
public class AccountRoleRowChecker extends EmptyOnClickRowChecker {

	public AccountRoleRowChecker(PortletResponse portletResponse) {
		super(portletResponse);
	}

	@Override
	public boolean isDisabled(Object obj) {
		AccountRoleDisplay accountRoleDisplay = (AccountRoleDisplay)obj;

		Role role = accountRoleDisplay.getRole();

		if (role.getType() == RoleConstants.TYPE_ACCOUNT) {
			return true;
		}

		return false;
	}

}