/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.wedeploy.auth.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for WeDeployAuthApp. This utility wraps
 * <code>com.liferay.portal.security.wedeploy.auth.service.impl.WeDeployAuthAppServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Supritha Sundaram
 * @see WeDeployAuthAppService
 * @generated
 */
public class WeDeployAuthAppServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.security.wedeploy.auth.service.impl.WeDeployAuthAppServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static
		com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp
				addWeDeployAuthApp(
					String name, String redirectURI,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addWeDeployAuthApp(
			name, redirectURI, serviceContext);
	}

	public static
		com.liferay.portal.security.wedeploy.auth.model.WeDeployAuthApp
				deleteWeDeployAuthApp(long weDeployAuthAppId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteWeDeployAuthApp(weDeployAuthAppId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static WeDeployAuthAppService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<WeDeployAuthAppService, WeDeployAuthAppService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(WeDeployAuthAppService.class);

		ServiceTracker<WeDeployAuthAppService, WeDeployAuthAppService>
			serviceTracker =
				new ServiceTracker
					<WeDeployAuthAppService, WeDeployAuthAppService>(
						bundle.getBundleContext(), WeDeployAuthAppService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}