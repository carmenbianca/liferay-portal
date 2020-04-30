/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.instance.lifecycle;

import com.liferay.portal.kernel.model.Company;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Michael C. Han
 */
@ProviderType
public interface PortalInstanceLifecycleListener {

	public default void portalInstancePreunregistered(Company company)
		throws Exception {
	}

	public void portalInstanceRegistered(Company company) throws Exception;

	public void portalInstanceUnregistered(Company company) throws Exception;

}