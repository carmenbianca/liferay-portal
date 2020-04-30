/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.screens.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ScreensRatingsEntry. This utility wraps
 * <code>com.liferay.screens.service.impl.ScreensRatingsEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author José Manuel Navarro
 * @see ScreensRatingsEntryService
 * @generated
 */
public class ScreensRatingsEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.screens.service.impl.ScreensRatingsEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONObject deleteRatingsEntry(
			long classPK, String className, int ratingsLength)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRatingsEntry(
			classPK, className, ratingsLength);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONObject getRatingsEntries(
			long assetEntryId, int ratingsLength)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRatingsEntries(assetEntryId, ratingsLength);
	}

	public static com.liferay.portal.kernel.json.JSONObject getRatingsEntries(
			long classPK, String className, int ratingsLength)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRatingsEntries(
			classPK, className, ratingsLength);
	}

	public static com.liferay.portal.kernel.json.JSONObject updateRatingsEntry(
			long classPK, String className, double score, int ratingsLength)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateRatingsEntry(
			classPK, className, score, ratingsLength);
	}

	public static ScreensRatingsEntryService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ScreensRatingsEntryService, ScreensRatingsEntryService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ScreensRatingsEntryService.class);

		ServiceTracker<ScreensRatingsEntryService, ScreensRatingsEntryService>
			serviceTracker =
				new ServiceTracker
					<ScreensRatingsEntryService, ScreensRatingsEntryService>(
						bundle.getBundleContext(),
						ScreensRatingsEntryService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}