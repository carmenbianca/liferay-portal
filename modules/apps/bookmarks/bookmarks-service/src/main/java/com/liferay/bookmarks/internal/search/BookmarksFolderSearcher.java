/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.internal.search;

import com.liferay.bookmarks.model.BookmarksFolder;
import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;

import org.osgi.service.component.annotations.Component;

/**
 * @author Luan Maoski
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.bookmarks.model.BookmarksFolder",
	service = BaseSearcher.class
)
public class BookmarksFolderSearcher extends BaseSearcher {

	public static final String CLASS_NAME = BookmarksFolder.class.getName();

	public BookmarksFolderSearcher() {
		setDefaultSelectedFieldNames(
			Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
			Field.TITLE, Field.UID);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}