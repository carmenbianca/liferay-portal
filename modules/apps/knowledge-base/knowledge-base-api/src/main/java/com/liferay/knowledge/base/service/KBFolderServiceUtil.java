/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.knowledge.base.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for KBFolder. This utility wraps
 * <code>com.liferay.knowledge.base.service.impl.KBFolderServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see KBFolderService
 * @generated
 */
public class KBFolderServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.knowledge.base.service.impl.KBFolderServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.knowledge.base.model.KBFolder addKBFolder(
			long groupId, long parentResourceClassNameId,
			long parentResourcePrimKey, String name, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addKBFolder(
			groupId, parentResourceClassNameId, parentResourcePrimKey, name,
			description, serviceContext);
	}

	public static com.liferay.knowledge.base.model.KBFolder deleteKBFolder(
			long kbFolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteKBFolder(kbFolderId);
	}

	public static com.liferay.knowledge.base.model.KBFolder
			fetchFirstChildKBFolder(long groupId, long kbFolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchFirstChildKBFolder(groupId, kbFolderId);
	}

	public static com.liferay.knowledge.base.model.KBFolder
			fetchFirstChildKBFolder(
				long groupId, long kbFolderId,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.knowledge.base.model.KBFolder> obc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchFirstChildKBFolder(groupId, kbFolderId, obc);
	}

	public static com.liferay.knowledge.base.model.KBFolder fetchKBFolder(
			long kbFolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchKBFolder(kbFolderId);
	}

	public static com.liferay.knowledge.base.model.KBFolder
			fetchKBFolderByUrlTitle(
				long groupId, long parentKbFolderId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchKBFolderByUrlTitle(
			groupId, parentKbFolderId, urlTitle);
	}

	public static com.liferay.knowledge.base.model.KBFolder getKBFolder(
			long kbFolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getKBFolder(kbFolderId);
	}

	public static com.liferay.knowledge.base.model.KBFolder
			getKBFolderByUrlTitle(
				long groupId, long parentKbFolderId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getKBFolderByUrlTitle(
			groupId, parentKbFolderId, urlTitle);
	}

	public static java.util.List<com.liferay.knowledge.base.model.KBFolder>
			getKBFolders(
				long groupId, long parentKBFolderId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getKBFolders(groupId, parentKBFolderId, start, end);
	}

	public static java.util.List<Object> getKBFoldersAndKBArticles(
		long groupId, long parentResourcePrimKey, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<?> orderByComparator) {

		return getService().getKBFoldersAndKBArticles(
			groupId, parentResourcePrimKey, status, start, end,
			orderByComparator);
	}

	public static int getKBFoldersAndKBArticlesCount(
		long groupId, long parentResourcePrimKey, int status) {

		return getService().getKBFoldersAndKBArticlesCount(
			groupId, parentResourcePrimKey, status);
	}

	public static int getKBFoldersCount(long groupId, long parentKBFolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getKBFoldersCount(groupId, parentKBFolderId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void moveKBFolder(long kbFolderId, long parentKBFolderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().moveKBFolder(kbFolderId, parentKBFolderId);
	}

	public static com.liferay.knowledge.base.model.KBFolder updateKBFolder(
			long parentResourceClassNameId, long parentResourcePrimKey,
			long kbFolderId, String name, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateKBFolder(
			parentResourceClassNameId, parentResourcePrimKey, kbFolderId, name,
			description, serviceContext);
	}

	public static KBFolderService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<KBFolderService, KBFolderService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(KBFolderService.class);

		ServiceTracker<KBFolderService, KBFolderService> serviceTracker =
			new ServiceTracker<KBFolderService, KBFolderService>(
				bundle.getBundleContext(), KBFolderService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}