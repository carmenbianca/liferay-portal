/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for DDMFormInstanceVersion. This utility wraps
 * <code>com.liferay.dynamic.data.mapping.service.impl.DDMFormInstanceVersionServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DDMFormInstanceVersionService
 * @generated
 */
public class DDMFormInstanceVersionServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.dynamic.data.mapping.service.impl.DDMFormInstanceVersionServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.dynamic.data.mapping.model.DDMFormInstanceVersion
			getFormInstanceVersion(long ddmFormInstanceVersionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFormInstanceVersion(ddmFormInstanceVersionId);
	}

	public static java.util.List
		<com.liferay.dynamic.data.mapping.model.DDMFormInstanceVersion>
				getFormInstanceVersions(
					long ddmFormInstanceId, int start, int end,
					com.liferay.portal.kernel.util.OrderByComparator
						<com.liferay.dynamic.data.mapping.model.
							DDMFormInstanceVersion> orderByComparator)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFormInstanceVersions(
			ddmFormInstanceId, start, end, orderByComparator);
	}

	public static int getFormInstanceVersionsCount(long ddmFormInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getFormInstanceVersionsCount(ddmFormInstanceId);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMFormInstanceVersion
			getLatestFormInstanceVersion(long ddmFormInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLatestFormInstanceVersion(ddmFormInstanceId);
	}

	public static com.liferay.dynamic.data.mapping.model.DDMFormInstanceVersion
			getLatestFormInstanceVersion(long ddmFormInstanceId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLatestFormInstanceVersion(
			ddmFormInstanceId, status);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DDMFormInstanceVersionService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<DDMFormInstanceVersionService, DDMFormInstanceVersionService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			DDMFormInstanceVersionService.class);

		ServiceTracker
			<DDMFormInstanceVersionService, DDMFormInstanceVersionService>
				serviceTracker =
					new ServiceTracker
						<DDMFormInstanceVersionService,
						 DDMFormInstanceVersionService>(
							 bundle.getBundleContext(),
							 DDMFormInstanceVersionService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}