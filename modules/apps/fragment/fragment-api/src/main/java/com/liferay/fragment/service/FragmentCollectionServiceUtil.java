/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.fragment.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for FragmentCollection. This utility wraps
 * <code>com.liferay.fragment.service.impl.FragmentCollectionServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FragmentCollectionService
 * @generated
 */
public class FragmentCollectionServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.fragment.service.impl.FragmentCollectionServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.fragment.model.FragmentCollection
			addFragmentCollection(
				long groupId, String name, String description,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addFragmentCollection(
			groupId, name, description, serviceContext);
	}

	public static com.liferay.fragment.model.FragmentCollection
			addFragmentCollection(
				long groupId, String fragmentCollectionKey, String name,
				String description,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addFragmentCollection(
			groupId, fragmentCollectionKey, name, description, serviceContext);
	}

	public static com.liferay.fragment.model.FragmentCollection
			deleteFragmentCollection(long fragmentCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteFragmentCollection(fragmentCollectionId);
	}

	public static void deleteFragmentCollections(long[] fragmentCollectionIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteFragmentCollections(fragmentCollectionIds);
	}

	public static com.liferay.fragment.model.FragmentCollection
			fetchFragmentCollection(long fragmentCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().fetchFragmentCollection(fragmentCollectionId);
	}

	public static java.util.List<com.liferay.fragment.model.FragmentCollection>
		getFragmentCollections(long groupId) {

		return getService().getFragmentCollections(groupId);
	}

	public static java.util.List<com.liferay.fragment.model.FragmentCollection>
		getFragmentCollections(long groupId, boolean includeSystem) {

		return getService().getFragmentCollections(groupId, includeSystem);
	}

	public static java.util.List<com.liferay.fragment.model.FragmentCollection>
		getFragmentCollections(
			long groupId, boolean includeSystem, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentCollection>
					orderByComparator) {

		return getService().getFragmentCollections(
			groupId, includeSystem, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.fragment.model.FragmentCollection>
		getFragmentCollections(long groupId, int start, int end) {

		return getService().getFragmentCollections(groupId, start, end);
	}

	public static java.util.List<com.liferay.fragment.model.FragmentCollection>
		getFragmentCollections(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentCollection>
					orderByComparator) {

		return getService().getFragmentCollections(
			groupId, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.fragment.model.FragmentCollection>
		getFragmentCollections(
			long groupId, String name, boolean includeSystem, int start,
			int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentCollection>
					orderByComparator) {

		return getService().getFragmentCollections(
			groupId, name, includeSystem, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.fragment.model.FragmentCollection>
		getFragmentCollections(
			long groupId, String name, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentCollection>
					orderByComparator) {

		return getService().getFragmentCollections(
			groupId, name, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.fragment.model.FragmentCollection>
		getFragmentCollections(long[] groupIds) {

		return getService().getFragmentCollections(groupIds);
	}

	public static java.util.List<com.liferay.fragment.model.FragmentCollection>
		getFragmentCollections(
			long[] groupIds, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentCollection>
					orderByComparator) {

		return getService().getFragmentCollections(
			groupIds, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.fragment.model.FragmentCollection>
		getFragmentCollections(
			long[] groupIds, String name, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.fragment.model.FragmentCollection>
					orderByComparator) {

		return getService().getFragmentCollections(
			groupIds, name, start, end, orderByComparator);
	}

	public static int getFragmentCollectionsCount(long groupId) {
		return getService().getFragmentCollectionsCount(groupId);
	}

	public static int getFragmentCollectionsCount(
		long groupId, boolean includeSystem) {

		return getService().getFragmentCollectionsCount(groupId, includeSystem);
	}

	public static int getFragmentCollectionsCount(long groupId, String name) {
		return getService().getFragmentCollectionsCount(groupId, name);
	}

	public static int getFragmentCollectionsCount(
		long groupId, String name, boolean includeSystem) {

		return getService().getFragmentCollectionsCount(
			groupId, name, includeSystem);
	}

	public static int getFragmentCollectionsCount(long[] groupIds) {
		return getService().getFragmentCollectionsCount(groupIds);
	}

	public static int getFragmentCollectionsCount(
		long[] groupIds, String name) {

		return getService().getFragmentCollectionsCount(groupIds, name);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static String[] getTempFileNames(long groupId, String folderName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTempFileNames(groupId, folderName);
	}

	public static com.liferay.fragment.model.FragmentCollection
			updateFragmentCollection(
				long fragmentCollectionId, String name, String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateFragmentCollection(
			fragmentCollectionId, name, description);
	}

	public static FragmentCollectionService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<FragmentCollectionService, FragmentCollectionService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			FragmentCollectionService.class);

		ServiceTracker<FragmentCollectionService, FragmentCollectionService>
			serviceTracker =
				new ServiceTracker
					<FragmentCollectionService, FragmentCollectionService>(
						bundle.getBundleContext(),
						FragmentCollectionService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}