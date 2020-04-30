/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.instance.lifecycle;

import com.liferay.portal.kernel.model.Company;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface PortalInstanceLifecycleManager {

	public void preunregisterCompany(Company company);

	public void registerCompany(Company company);

	public void unregisterCompany(Company company);

}