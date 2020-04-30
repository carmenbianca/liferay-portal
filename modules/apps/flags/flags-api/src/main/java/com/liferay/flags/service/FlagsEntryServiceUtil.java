/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.flags.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for FlagsEntry. This utility wraps
 * <code>com.liferay.flags.service.impl.FlagsEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FlagsEntryService
 * @generated
 */
public class FlagsEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.flags.service.impl.FlagsEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addEntry(
			String className, long classPK, String reporterEmailAddress,
			long reportedUserId, String contentTitle, String contentURL,
			String reason,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addEntry(
			className, classPK, reporterEmailAddress, reportedUserId,
			contentTitle, contentURL, reason, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static FlagsEntryService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FlagsEntryService, FlagsEntryService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(FlagsEntryService.class);

		ServiceTracker<FlagsEntryService, FlagsEntryService> serviceTracker =
			new ServiceTracker<FlagsEntryService, FlagsEntryService>(
				bundle.getBundleContext(), FlagsEntryService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}