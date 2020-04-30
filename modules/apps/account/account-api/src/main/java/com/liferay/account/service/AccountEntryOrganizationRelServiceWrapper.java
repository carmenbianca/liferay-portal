/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AccountEntryOrganizationRelService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntryOrganizationRelService
 * @generated
 */
public class AccountEntryOrganizationRelServiceWrapper
	implements AccountEntryOrganizationRelService,
			   ServiceWrapper<AccountEntryOrganizationRelService> {

	public AccountEntryOrganizationRelServiceWrapper(
		AccountEntryOrganizationRelService accountEntryOrganizationRelService) {

		_accountEntryOrganizationRelService =
			accountEntryOrganizationRelService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountEntryOrganizationRelService.getOSGiServiceIdentifier();
	}

	@Override
	public AccountEntryOrganizationRelService getWrappedService() {
		return _accountEntryOrganizationRelService;
	}

	@Override
	public void setWrappedService(
		AccountEntryOrganizationRelService accountEntryOrganizationRelService) {

		_accountEntryOrganizationRelService =
			accountEntryOrganizationRelService;
	}

	private AccountEntryOrganizationRelService
		_accountEntryOrganizationRelService;

}