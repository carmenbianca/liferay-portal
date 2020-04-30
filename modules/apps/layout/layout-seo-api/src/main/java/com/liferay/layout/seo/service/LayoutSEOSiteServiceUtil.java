/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.seo.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for LayoutSEOSite. This utility wraps
 * <code>com.liferay.layout.seo.service.impl.LayoutSEOSiteServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSEOSiteService
 * @generated
 */
public class LayoutSEOSiteServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.layout.seo.service.impl.LayoutSEOSiteServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static LayoutSEOSiteService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LayoutSEOSiteService, LayoutSEOSiteService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LayoutSEOSiteService.class);

		ServiceTracker<LayoutSEOSiteService, LayoutSEOSiteService>
			serviceTracker =
				new ServiceTracker<LayoutSEOSiteService, LayoutSEOSiteService>(
					bundle.getBundleContext(), LayoutSEOSiteService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}