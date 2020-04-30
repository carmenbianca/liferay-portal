/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.web.internal.upgrade.v1_0_0;

import com.liferay.bookmarks.constants.BookmarksPortletKeys;
import com.liferay.portal.kernel.upgrade.BaseUpgradeAdminPortlets;

/**
 * @author Miguel Pastor
 */
public class UpgradeAdminPortlets extends BaseUpgradeAdminPortlets {

	@Override
	protected void doUpgrade() throws Exception {
		updateAccessInControlPanelPermission(
			BookmarksPortletKeys.BOOKMARKS,
			BookmarksPortletKeys.BOOKMARKS_ADMIN);
	}

}