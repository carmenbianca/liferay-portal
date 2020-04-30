/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.polls.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for PollsChoice. This utility wraps
 * <code>com.liferay.polls.service.impl.PollsChoiceServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PollsChoiceService
 * @generated
 */
public class PollsChoiceServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.polls.service.impl.PollsChoiceServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static PollsChoiceService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PollsChoiceService, PollsChoiceService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PollsChoiceService.class);

		ServiceTracker<PollsChoiceService, PollsChoiceService> serviceTracker =
			new ServiceTracker<PollsChoiceService, PollsChoiceService>(
				bundle.getBundleContext(), PollsChoiceService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}