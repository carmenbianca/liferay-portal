/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.web.internal.frontend.taglib.servlet.taglib;

import com.liferay.frontend.taglib.servlet.taglib.ScreenNavigationEntry;
import com.liferay.portal.kernel.model.User;
import com.liferay.users.admin.constants.UserScreenNavigationEntryConstants;

import org.osgi.service.component.annotations.Component;

/**
 * @author Pei-Jung Lan
 */
@Component(
	property = "screen.navigation.entry.order:Integer=30",
	service = ScreenNavigationEntry.class
)
public class UserMembershipsScreenNavigationEntry
	extends BaseUserScreenNavigationEntry {

	@Override
	public String getActionCommandName() {
		return "/users_admin/update_memberships";
	}

	@Override
	public String getCategoryKey() {
		return UserScreenNavigationEntryConstants.CATEGORY_KEY_GENERAL;
	}

	@Override
	public String getEntryKey() {
		return UserScreenNavigationEntryConstants.ENTRY_KEY_MEMBERSHIPS;
	}

	@Override
	public String getJspPath() {
		return "/user/memberships.jsp";
	}

	@Override
	public boolean isVisible(User user, User selUser) {
		if (selUser == null) {
			return false;
		}

		return true;
	}

}