/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface KBArticleFinder {

	public int countByUrlTitle(
		long groupId, String kbFolderUrlTitle, String kbArticleUrlTitle,
		int[] status);

	public java.util.List<com.liferay.knowledge.base.model.KBArticle>
		findByUrlTitle(
			long groupId, String kbFolderUrlTitle, String kbArticleUrlTitle,
			int[] status, int start, int end);

}