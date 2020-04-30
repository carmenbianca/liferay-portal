/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.screens.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for ScreensDDMStructureVersion. This utility wraps
 * <code>com.liferay.screens.service.impl.ScreensDDMStructureVersionServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author José Manuel Navarro
 * @see ScreensDDMStructureVersionService
 * @generated
 */
public class ScreensDDMStructureVersionServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.screens.service.impl.ScreensDDMStructureVersionServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONObject
			getDDMStructureVersion(long structureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getDDMStructureVersion(structureId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ScreensDDMStructureVersionService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ScreensDDMStructureVersionService, ScreensDDMStructureVersionService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ScreensDDMStructureVersionService.class);

		ServiceTracker
			<ScreensDDMStructureVersionService,
			 ScreensDDMStructureVersionService> serviceTracker =
				new ServiceTracker
					<ScreensDDMStructureVersionService,
					 ScreensDDMStructureVersionService>(
						 bundle.getBundleContext(),
						 ScreensDDMStructureVersionService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}