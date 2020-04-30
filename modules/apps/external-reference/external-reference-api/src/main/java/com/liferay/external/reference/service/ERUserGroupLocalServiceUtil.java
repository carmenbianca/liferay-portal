/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.external.reference.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ERUserGroup. This utility wraps
 * <code>com.liferay.external.reference.service.impl.ERUserGroupLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ERUserGroupLocalService
 * @generated
 */
public class ERUserGroupLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.external.reference.service.impl.ERUserGroupLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.UserGroup
			addOrUpdateUserGroup(
				String externalReferenceCode, long userId, long companyId,
				String name, String description,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addOrUpdateUserGroup(
			externalReferenceCode, userId, companyId, name, description,
			serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ERUserGroupLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ERUserGroupLocalService, ERUserGroupLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ERUserGroupLocalService.class);

		ServiceTracker<ERUserGroupLocalService, ERUserGroupLocalService>
			serviceTracker =
				new ServiceTracker
					<ERUserGroupLocalService, ERUserGroupLocalService>(
						bundle.getBundleContext(),
						ERUserGroupLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}