/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AccountEntry. This utility wraps
 * <code>com.liferay.account.service.impl.AccountEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryService
 * @generated
 */
public class AccountEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.account.service.impl.AccountEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.account.model.AccountEntry addAccountEntry(
			long userId, long parentAccountEntryId, String name,
			String description, String[] domains, byte[] logoBytes, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addAccountEntry(
			userId, parentAccountEntryId, name, description, domains, logoBytes,
			status);
	}

	public static java.util.List<com.liferay.account.model.AccountEntry>
			getAccountEntries(
				long companyId, int status, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.account.model.AccountEntry> obc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAccountEntries(
			companyId, status, start, end, obc);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AccountEntryService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AccountEntryService, AccountEntryService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AccountEntryService.class);

		ServiceTracker<AccountEntryService, AccountEntryService>
			serviceTracker =
				new ServiceTracker<AccountEntryService, AccountEntryService>(
					bundle.getBundleContext(), AccountEntryService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}