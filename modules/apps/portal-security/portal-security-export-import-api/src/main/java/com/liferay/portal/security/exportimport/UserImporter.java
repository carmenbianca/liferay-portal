/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.security.exportimport;

import com.liferay.portal.kernel.model.User;

/**
 * @author Michael C. Han
 */
public interface UserImporter {

	public long getLastImportTime() throws Exception;

	public User importUser(
			long ldapServerId, long companyId, String emailAddress,
			String screenName)
		throws Exception;

	public User importUser(
			long companyId, String emailAddress, String screenName)
		throws Exception;

	public User importUserByScreenName(long companyId, String screenName)
		throws Exception;

	public void importUsers() throws Exception;

	public void importUsers(long companyId) throws Exception;

	public void importUsers(long ldapServerId, long companyId) throws Exception;

}