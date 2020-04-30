/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.internal.upgrade.v1_0_0;

import com.liferay.bookmarks.constants.BookmarksPortletKeys;
import com.liferay.portal.kernel.util.LoggingTimer;

/**
 * @author Máté Thurzó
 */
public class UpgradeLastPublishDate
	extends com.liferay.portal.upgrade.v7_0_0.UpgradeLastPublishDate {

	protected void addLastPublishDateColumns() throws Exception {
		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			addLastPublishDateColumn("BookmarksEntry");
			addLastPublishDateColumn("BookmarksFolder");
		}
	}

	@Override
	protected void doUpgrade() throws Exception {
		addLastPublishDateColumns();

		updateLastPublishDates(
			BookmarksPortletKeys.BOOKMARKS, "BookmarksEntry");
		updateLastPublishDates(
			BookmarksPortletKeys.BOOKMARKS, "BookmarksFolder");
	}

}