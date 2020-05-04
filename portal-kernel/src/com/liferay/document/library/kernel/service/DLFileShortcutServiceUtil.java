/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the remote service utility for DLFileShortcut. This utility wraps
 * <code>com.liferay.portlet.documentlibrary.service.impl.DLFileShortcutServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DLFileShortcutService
 * @generated
 */
public class DLFileShortcutServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portlet.documentlibrary.service.impl.DLFileShortcutServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.document.library.kernel.model.DLFileShortcut
			addFileShortcut(
				long groupId, long repositoryId, long folderId,
				long toFileEntryId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addFileShortcut(
			groupId, repositoryId, folderId, toFileEntryId, serviceContext);
	}

	public static void deleteFileShortcut(long fileShortcutId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteFileShortcut(fileShortcutId);
	}

	public static com.liferay.document.library.kernel.model.DLFileShortcut
			getFileShortcut(long fileShortcutId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFileShortcut(fileShortcutId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.document.library.kernel.model.DLFileShortcut
			updateFileShortcut(
				long fileShortcutId, long repositoryId, long folderId,
				long toFileEntryId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateFileShortcut(
			fileShortcutId, repositoryId, folderId, toFileEntryId,
			serviceContext);
	}

	public static void updateFileShortcuts(
			long oldToFileEntryId, long newToFileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateFileShortcuts(oldToFileEntryId, newToFileEntryId);
	}

	public static DLFileShortcutService getService() {
		if (_service == null) {
			_service = (DLFileShortcutService)PortalBeanLocatorUtil.locate(
				DLFileShortcutService.class.getName());
		}

		return _service;
	}

	private static DLFileShortcutService _service;

}