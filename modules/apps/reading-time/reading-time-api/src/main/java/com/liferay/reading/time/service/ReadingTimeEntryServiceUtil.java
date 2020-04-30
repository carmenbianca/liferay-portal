/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.reading.time.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ReadingTimeEntry. This utility wraps
 * <code>com.liferay.reading.time.service.impl.ReadingTimeEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ReadingTimeEntryService
 * @generated
 */
public class ReadingTimeEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.reading.time.service.impl.ReadingTimeEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ReadingTimeEntryService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ReadingTimeEntryService, ReadingTimeEntryService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ReadingTimeEntryService.class);

		ServiceTracker<ReadingTimeEntryService, ReadingTimeEntryService>
			serviceTracker =
				new ServiceTracker
					<ReadingTimeEntryService, ReadingTimeEntryService>(
						bundle.getBundleContext(),
						ReadingTimeEntryService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}