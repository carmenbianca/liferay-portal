/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dispatch.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for DispatchLog. This utility wraps
 * <code>com.liferay.dispatch.service.impl.DispatchLogServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Alessio Antonio Rendina
 * @see DispatchLogService
 * @generated
 */
public class DispatchLogServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.dispatch.service.impl.DispatchLogServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DispatchLogService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<DispatchLogService, DispatchLogService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(DispatchLogService.class);

		ServiceTracker<DispatchLogService, DispatchLogService> serviceTracker =
			new ServiceTracker<DispatchLogService, DispatchLogService>(
				bundle.getBundleContext(), DispatchLogService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}