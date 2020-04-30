/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.test.rule;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.test.util.TestPropsValues;

import org.junit.runner.Description;

/**
 * @author Cristina González
 */
public class CompanyProviderClassTestRule extends ClassTestRule<Long> {

	public static final CompanyProviderClassTestRule INSTANCE =
		new CompanyProviderClassTestRule();

	@Override
	protected void afterClass(Description description, Long previousCompanyId) {
		CompanyThreadLocal.setCompanyId(previousCompanyId);
	}

	@Override
	protected Long beforeClass(Description description) throws PortalException {
		Long companyId = CompanyThreadLocal.getCompanyId();

		CompanyThreadLocal.setCompanyId(TestPropsValues.getCompanyId());

		return companyId;
	}

	private CompanyProviderClassTestRule() {
	}

}