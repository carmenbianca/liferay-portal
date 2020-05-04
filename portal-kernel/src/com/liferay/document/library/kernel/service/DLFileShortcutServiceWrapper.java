/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DLFileShortcutService}.
 *
 * @author Brian Wing Shun Chan
 * @see DLFileShortcutService
 * @generated
 */
public class DLFileShortcutServiceWrapper
	implements DLFileShortcutService, ServiceWrapper<DLFileShortcutService> {

	public DLFileShortcutServiceWrapper(
		DLFileShortcutService dlFileShortcutService) {

		_dlFileShortcutService = dlFileShortcutService;
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFileShortcut
			addFileShortcut(
				long groupId, long repositoryId, long folderId,
				long toFileEntryId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlFileShortcutService.addFileShortcut(
			groupId, repositoryId, folderId, toFileEntryId, serviceContext);
	}

	@Override
	public void deleteFileShortcut(long fileShortcutId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dlFileShortcutService.deleteFileShortcut(fileShortcutId);
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFileShortcut
			getFileShortcut(long fileShortcutId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlFileShortcutService.getFileShortcut(fileShortcutId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dlFileShortcutService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.document.library.kernel.model.DLFileShortcut
			updateFileShortcut(
				long fileShortcutId, long repositoryId, long folderId,
				long toFileEntryId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _dlFileShortcutService.updateFileShortcut(
			fileShortcutId, repositoryId, folderId, toFileEntryId,
			serviceContext);
	}

	@Override
	public void updateFileShortcuts(
			long oldToFileEntryId, long newToFileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_dlFileShortcutService.updateFileShortcuts(
			oldToFileEntryId, newToFileEntryId);
	}

	@Override
	public DLFileShortcutService getWrappedService() {
		return _dlFileShortcutService;
	}

	@Override
	public void setWrappedService(DLFileShortcutService dlFileShortcutService) {
		_dlFileShortcutService = dlFileShortcutService;
	}

	private DLFileShortcutService _dlFileShortcutService;

}