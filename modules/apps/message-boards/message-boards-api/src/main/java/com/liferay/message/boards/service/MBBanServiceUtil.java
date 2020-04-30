/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.message.boards.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for MBBan. This utility wraps
 * <code>com.liferay.message.boards.service.impl.MBBanServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MBBanService
 * @generated
 */
public class MBBanServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.message.boards.service.impl.MBBanServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.message.boards.model.MBBan addBan(
			long banUserId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addBan(banUserId, serviceContext);
	}

	public static void deleteBan(
			long banUserId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteBan(banUserId, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static MBBanService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MBBanService, MBBanService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MBBanService.class);

		ServiceTracker<MBBanService, MBBanService> serviceTracker =
			new ServiceTracker<MBBanService, MBBanService>(
				bundle.getBundleContext(), MBBanService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}