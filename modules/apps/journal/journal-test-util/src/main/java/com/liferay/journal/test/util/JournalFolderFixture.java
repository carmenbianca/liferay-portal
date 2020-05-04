/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.journal.test.util;

import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.model.JournalFolderConstants;
import com.liferay.journal.service.JournalFolderLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;

import java.util.Objects;

/**
 * @author André de Oliveira
 */
public class JournalFolderFixture {

	public JournalFolderFixture(
		JournalFolderLocalService journalFolderLocalService) {

		_journalFolderLocalService = Objects.requireNonNull(
			journalFolderLocalService);
	}

	public JournalFolder addFolder(
			long userId, long groupId, long parentFolderId, String name)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(groupId, userId);

		return addFolder(parentFolderId, name, serviceContext);
	}

	public JournalFolder addFolder(
			long groupId, long parentFolderId, String name)
		throws Exception {

		ServiceContext serviceContext =
			ServiceContextTestUtil.getServiceContext(
				groupId, TestPropsValues.getUserId());

		return addFolder(parentFolderId, name, serviceContext);
	}

	public JournalFolder addFolder(long groupId, String name) throws Exception {
		return addFolder(
			groupId, JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID, name);
	}

	public JournalFolder addFolder(
			long parentFolderId, String name, ServiceContext serviceContext)
		throws Exception {

		return addFolder(
			parentFolderId, name, "This is a test folder.", serviceContext);
	}

	public JournalFolder addFolder(
			long parentFolderId, String name, String description,
			ServiceContext serviceContext)
		throws Exception {

		JournalFolder folder = _journalFolderLocalService.fetchFolder(
			serviceContext.getScopeGroupId(), parentFolderId, name);

		if (folder != null) {
			return folder;
		}

		return _journalFolderLocalService.addFolder(
			serviceContext.getUserId(), serviceContext.getScopeGroupId(),
			parentFolderId, name, description, serviceContext);
	}

	private final JournalFolderLocalService _journalFolderLocalService;

}