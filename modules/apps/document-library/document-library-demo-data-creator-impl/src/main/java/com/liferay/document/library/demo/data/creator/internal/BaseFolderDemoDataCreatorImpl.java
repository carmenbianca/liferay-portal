/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.demo.data.creator.internal;

import com.liferay.document.library.demo.data.creator.BaseFolderDemoDataCreator;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Hernández
 */
public abstract class BaseFolderDemoDataCreatorImpl
	implements BaseFolderDemoDataCreator {

	@Override
	public void delete() throws PortalException {
		for (long folderId : _folderIds) {
			try {
				dlAppLocalService.deleteFolder(folderId);
			}
			catch (NoSuchFolderException noSuchFolderException) {
				if (_log.isWarnEnabled()) {
					_log.warn(noSuchFolderException, noSuchFolderException);
				}
			}

			_folderIds.remove(folderId);
		}
	}

	protected Folder createFolder(
			long userId, long groupId, long folderId, String name)
		throws PortalException {

		Folder folder = null;

		try {
			folder = dlAppLocalService.getFolder(groupId, folderId, name);
		}
		catch (NoSuchFolderException noSuchFolderException) {
			if (_log.isWarnEnabled()) {
				_log.warn(noSuchFolderException, noSuchFolderException);
			}

			folder = dlAppLocalService.addFolder(
				userId, groupId, folderId, name, StringPool.BLANK,
				new ServiceContext());
		}

		_folderIds.add(folder.getFolderId());

		return folder;
	}

	@Reference
	protected DLAppLocalService dlAppLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		BaseFolderDemoDataCreatorImpl.class);

	private final List<Long> _folderIds = new CopyOnWriteArrayList<>();

}