/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.internal.upgrade.v2_0_0;

import com.liferay.bookmarks.internal.upgrade.v2_0_0.util.BookmarksEntryTable;
import com.liferay.bookmarks.model.BookmarksEntry;
import com.liferay.portal.upgrade.util.BaseUpgradeResourceBlock;

/**
 * @author Preston Crary
 */
public class UpgradeBookmarksEntryResourceBlock
	extends BaseUpgradeResourceBlock {

	@Override
	protected String getClassName() {
		return BookmarksEntry.class.getName();
	}

	@Override
	protected String getPrimaryKeyName() {
		return "entryId";
	}

	@Override
	protected Class<?> getTableClass() {
		return BookmarksEntryTable.class;
	}

	@Override
	protected boolean hasUserId() {
		return true;
	}

}