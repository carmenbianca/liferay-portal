/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.external.reference.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for EROrganization. This utility wraps
 * <code>com.liferay.external.reference.service.impl.EROrganizationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EROrganizationLocalService
 * @generated
 */
public class EROrganizationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.external.reference.service.impl.EROrganizationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.Organization
			addOrUpdateOrganization(
				String externalReferenceCode, long userId,
				long parentOrganizationId, String name, String type,
				long regionId, long countryId, long statusId, String comments,
				boolean site, boolean hasLogo, byte[] logoBytes,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addOrUpdateOrganization(
			externalReferenceCode, userId, parentOrganizationId, name, type,
			regionId, countryId, statusId, comments, site, hasLogo, logoBytes,
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

	public static EROrganizationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EROrganizationLocalService, EROrganizationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EROrganizationLocalService.class);

		ServiceTracker<EROrganizationLocalService, EROrganizationLocalService>
			serviceTracker =
				new ServiceTracker
					<EROrganizationLocalService, EROrganizationLocalService>(
						bundle.getBundleContext(),
						EROrganizationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}