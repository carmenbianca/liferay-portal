/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.model;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Juan Fernández
 */
public class JournalFolderConstants {

	public static final long DEFAULT_PARENT_FOLDER_ID = 0;

	public static final String NAME_GENERAL_RESTRICTIONS = "blank";

	/**
	 * @deprecated As of Mueller (7.2.x), with no direct replacement
	 */
	@Deprecated
	public static final String NAME_LABEL = "folder-name";

	public static final String NAME_RESERVED_WORDS = StringPool.NULL;

	public static final int RESTRICTION_TYPE_DDM_STRUCTURES_AND_WORKFLOW = 1;

	public static final int RESTRICTION_TYPE_INHERIT = 0;

	public static final int RESTRICTION_TYPE_WORKFLOW = 2;

	public static String getNameInvalidCharacters(String[] charBlacklist) {
		return StringUtil.merge(charBlacklist, StringPool.SPACE);
	}

}