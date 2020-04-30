/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.kernel.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * Provides the local service utility for DLTrash. This utility wraps
 * <code>com.liferay.portlet.documentlibrary.service.impl.DLTrashLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see DLTrashLocalService
 * @generated
 */
public class DLTrashLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portlet.documentlibrary.service.impl.DLTrashLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry
			moveFileEntryFromTrash(
				long userId, long repositoryId, long fileEntryId,
				long newFolderId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().moveFileEntryFromTrash(
			userId, repositoryId, fileEntryId, newFolderId, serviceContext);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry
			moveFileEntryToTrash(
				long userId, long repositoryId, long fileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().moveFileEntryToTrash(
			userId, repositoryId, fileEntryId);
	}

	public static void restoreFileEntryFromTrash(
			long userId, long repositoryId, long fileEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().restoreFileEntryFromTrash(
			userId, repositoryId, fileEntryId);
	}

	public static DLTrashLocalService getService() {
		if (_service == null) {
			_service = (DLTrashLocalService)PortalBeanLocatorUtil.locate(
				DLTrashLocalService.class.getName());
		}

		return _service;
	}

	private static DLTrashLocalService _service;

}