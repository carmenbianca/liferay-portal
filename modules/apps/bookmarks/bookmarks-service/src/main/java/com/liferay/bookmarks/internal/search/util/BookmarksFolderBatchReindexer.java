/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.internal.search.util;

/**
 * @author Luan Maoski
 */
public interface BookmarksFolderBatchReindexer {

	public void reindex(long folderId, long companyId);

}