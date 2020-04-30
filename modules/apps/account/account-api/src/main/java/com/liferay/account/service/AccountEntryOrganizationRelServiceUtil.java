/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AccountEntryOrganizationRel. This utility wraps
 * <code>com.liferay.account.service.impl.AccountEntryOrganizationRelServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryOrganizationRelService
 * @generated
 */
public class AccountEntryOrganizationRelServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.account.service.impl.AccountEntryOrganizationRelServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AccountEntryOrganizationRelService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AccountEntryOrganizationRelService, AccountEntryOrganizationRelService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AccountEntryOrganizationRelService.class);

		ServiceTracker
			<AccountEntryOrganizationRelService,
			 AccountEntryOrganizationRelService> serviceTracker =
				new ServiceTracker
					<AccountEntryOrganizationRelService,
					 AccountEntryOrganizationRelService>(
						 bundle.getBundleContext(),
						 AccountEntryOrganizationRelService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}