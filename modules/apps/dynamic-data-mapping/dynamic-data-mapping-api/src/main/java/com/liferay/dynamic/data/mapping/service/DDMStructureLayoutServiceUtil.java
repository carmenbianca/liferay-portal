/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for DDMStructureLayout. This utility wraps
 * <code>com.liferay.dynamic.data.mapping.service.impl.DDMStructureLayoutServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DDMStructureLayoutService
 * @generated
 */
public class DDMStructureLayoutServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.dynamic.data.mapping.service.impl.DDMStructureLayoutServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMStructureLayout>
				getStructureLayouts(long groupId, int start, int end)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStructureLayouts(groupId, start, end);
	}

	public static int getStructureLayoutsCount(long groupId) {
		return getService().getStructureLayoutsCount(groupId);
	}

	public static java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMStructureLayout> search(
				long companyId, long[] groupIds, long classNameId,
				String keywords, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.dynamic.data.mapping.model.DDMStructureLayout>
						orderByComparator)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().search(
			companyId, groupIds, classNameId, keywords, start, end,
			orderByComparator);
	}

	public static DDMStructureLayoutService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DDMStructureLayoutService, DDMStructureLayoutService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DDMStructureLayoutService.class);

		ServiceTracker<DDMStructureLayoutService, DDMStructureLayoutService>
			serviceTracker =
				new ServiceTracker
					<DDMStructureLayoutService, DDMStructureLayoutService>(
						bundle.getBundleContext(),
						DDMStructureLayoutService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}