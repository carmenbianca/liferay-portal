/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.persistence;

/**
 * @author     Cristina González
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class CompanyProviderWrapper implements CompanyProvider {

	@Override
	public long getCompanyId() {
		return _companyProvider.getCompanyId();
	}

	@Override
	public String getCompanyIdName() {
		return _companyProvider.getCompanyIdName();
	}

	public CompanyProvider getCompanyProvider() {
		return _companyProvider;
	}

	public void setCompanyProvider(CompanyProvider companyProvider) {
		_companyProvider = companyProvider;
	}

	private CompanyProvider _companyProvider;

}