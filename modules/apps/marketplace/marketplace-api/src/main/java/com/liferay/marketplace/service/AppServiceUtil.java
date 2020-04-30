/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.marketplace.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for App. This utility wraps
 * <code>com.liferay.marketplace.service.impl.AppServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Ryan Park
 * @see AppService
 * @generated
 */
public class AppServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.marketplace.service.impl.AppServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.marketplace.model.App deleteApp(long appId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteApp(appId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void installApp(long remoteAppId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().installApp(remoteAppId);
	}

	public static void uninstallApp(long remoteAppId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().uninstallApp(remoteAppId);
	}

	public static com.liferay.marketplace.model.App updateApp(java.io.File file)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateApp(file);
	}

	public static AppService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AppService, AppService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AppService.class);

		ServiceTracker<AppService, AppService> serviceTracker =
			new ServiceTracker<AppService, AppService>(
				bundle.getBundleContext(), AppService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}