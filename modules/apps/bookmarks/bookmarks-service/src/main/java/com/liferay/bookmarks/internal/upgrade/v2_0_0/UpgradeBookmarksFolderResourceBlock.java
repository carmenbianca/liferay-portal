/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.internal.upgrade.v2_0_0;

import com.liferay.bookmarks.internal.upgrade.v2_0_0.util.BookmarksFolderTable;
import com.liferay.bookmarks.model.BookmarksFolder;
import com.liferay.portal.upgrade.util.BaseUpgradeResourceBlock;

/**
 * @author Preston Crary
 */
public class UpgradeBookmarksFolderResourceBlock
	extends BaseUpgradeResourceBlock {

	@Override
	protected String getClassName() {
		return BookmarksFolder.class.getName();
	}

	@Override
	protected String getPrimaryKeyName() {
		return "folderId";
	}

	@Override
	protected Class<?> getTableClass() {
		return BookmarksFolderTable.class;
	}

	@Override
	protected boolean hasUserId() {
		return true;
	}

}