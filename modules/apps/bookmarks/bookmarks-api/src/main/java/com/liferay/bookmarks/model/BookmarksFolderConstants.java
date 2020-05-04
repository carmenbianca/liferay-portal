/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.model;

import com.liferay.petra.string.StringPool;

/**
 * @author Alexander Chow
 */
public class BookmarksFolderConstants {

	public static final long DEFAULT_PARENT_FOLDER_ID = 0;

	public static final String NAME_GENERAL_RESTRICTIONS = "blank";

	public static final String NAME_INVALID_CHARACTERS =
		StringPool.DOUBLE_SLASH + StringPool.SPACE +
			StringPool.DOUBLE_BACK_SLASH;

	/**
	 * @deprecated As of Mueller (7.2.x), with no direct replacement
	 */
	@Deprecated
	public static final String NAME_LABEL = "folder-name";

	public static final String NAME_RESERVED_WORDS = StringPool.NULL;

}