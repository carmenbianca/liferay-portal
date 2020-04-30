/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.persistence.impl;

import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;

/**
 * @author     Miguel Pastor
 * @author     Cristina González
 * @deprecated As of Mueller (7.2.x), with no direct replacement
 */
@Deprecated
public class ThreadLocalCompanyProvider implements CompanyProvider {

	@Override
	public long getCompanyId() {
		return CompanyThreadLocal.getCompanyId();
	}

	@Override
	public String getCompanyIdName() {
		return "companyId";
	}

}