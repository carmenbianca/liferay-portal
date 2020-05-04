/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface PasswordPolicyFinder {

	public int countByC_N(long companyId, String name);

	public int filterCountByC_N(long companyId, String name);

	public java.util.List<com.liferay.portal.kernel.model.PasswordPolicy>
		filterFindByC_N(
			long companyId, String name, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.portal.kernel.model.PasswordPolicy> obc);

	public java.util.List<com.liferay.portal.kernel.model.PasswordPolicy>
		findByC_N(
			long companyId, String name, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.portal.kernel.model.PasswordPolicy> obc);

}