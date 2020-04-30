/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.sync.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for SyncDevice. This utility wraps
 * <code>com.liferay.sync.service.impl.SyncDeviceServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SyncDeviceService
 * @generated
 */
public class SyncDeviceServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.sync.service.impl.SyncDeviceServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.sync.model.SyncDevice registerSyncDevice(
			String type, long buildNumber, int featureSet, String uuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().registerSyncDevice(
			type, buildNumber, featureSet, uuid);
	}

	public static void unregisterSyncDevice(String uuid)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().unregisterSyncDevice(uuid);
	}

	public static SyncDeviceService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SyncDeviceService, SyncDeviceService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SyncDeviceService.class);

		ServiceTracker<SyncDeviceService, SyncDeviceService> serviceTracker =
			new ServiceTracker<SyncDeviceService, SyncDeviceService>(
				bundle.getBundleContext(), SyncDeviceService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}