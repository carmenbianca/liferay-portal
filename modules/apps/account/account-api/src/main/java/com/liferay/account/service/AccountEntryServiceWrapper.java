/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AccountEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryService
 * @generated
 */
public class AccountEntryServiceWrapper
	implements AccountEntryService, ServiceWrapper<AccountEntryService> {

	public AccountEntryServiceWrapper(AccountEntryService accountEntryService) {
		_accountEntryService = accountEntryService;
	}

	@Override
	public com.liferay.account.model.AccountEntry addAccountEntry(
			long userId, long parentAccountEntryId, String name,
			String description, String[] domains, byte[] logoBytes, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryService.addAccountEntry(
			userId, parentAccountEntryId, name, description, domains, logoBytes,
			status);
	}

	@Override
	public java.util.List<com.liferay.account.model.AccountEntry>
			getAccountEntries(
				long companyId, int status, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.account.model.AccountEntry> obc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryService.getAccountEntries(
			companyId, status, start, end, obc);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public AccountEntryService getWrappedService() {
		return _accountEntryService;
	}

	@Override
	public void setWrappedService(AccountEntryService accountEntryService) {
		_accountEntryService = accountEntryService;
	}

	private AccountEntryService _accountEntryService;

}