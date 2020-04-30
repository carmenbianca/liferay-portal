/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.file.rank.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface DLFileRankFinder {

	public java.util.List<Object[]> findByStaleRanks(int count);

	public java.util.List
		<com.liferay.document.library.file.rank.model.DLFileRank>
			findByFolderId(long folderId);

}