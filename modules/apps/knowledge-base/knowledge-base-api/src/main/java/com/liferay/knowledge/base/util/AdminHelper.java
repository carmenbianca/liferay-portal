/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.util;

import com.liferay.portal.kernel.diff.DiffVersionsInfo;

/**
 * @author Lance Ji
 */
public interface AdminHelper {

	public String[] escapeSections(String[] sections);

	public DiffVersionsInfo getDiffVersionsInfo(
		long groupId, long kbArticleResourcePrimKey, int sourceVersion,
		int targetVersion);

	public String getKBArticleDiff(
			long resourcePrimKey, int sourceVersion, int targetVersion,
			String param)
		throws Exception;

	public String[] unescapeSections(String sections);

}