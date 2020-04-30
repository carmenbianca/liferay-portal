/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.repository.capabilities;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.RepositoryEntry;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * @author Jürgen Kappler
 */
public interface FileEntryTypeCapability extends Capability {

	public List<RepositoryEntry> getFoldersAndFileEntriesAndFileShortcuts(
			long repositoryId, long folderId, String[] mimeTypes,
			long fileEntryTypeId, boolean includeMountFolders, int status,
			int start, int end, OrderByComparator<?> obc)
		throws PortalException;

	public int getFoldersAndFileEntriesAndFileShortcutsCount(
			long groupId, long folderId, String[] mimeTypes,
			long fileEntryTypeId, boolean includeMountFolders, int status)
		throws PortalException;

}