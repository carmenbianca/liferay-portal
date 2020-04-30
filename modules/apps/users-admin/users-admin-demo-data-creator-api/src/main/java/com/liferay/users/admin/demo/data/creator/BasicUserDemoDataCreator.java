/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.demo.data.creator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Sergio González
 */
@ProviderType
public interface BasicUserDemoDataCreator extends UserDemoDataCreator {

	public User create(long companyId) throws PortalException;

	public User create(long companyId, String emailAddress)
		throws PortalException;

	public User create(
			long companyId, String screenName, String emailAddress,
			String firstName, String lastName)
		throws PortalException;

}