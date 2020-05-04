/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.retriever;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Drew Brokke
 */
@ProviderType
public interface AccountUserRetriever {

	public List<User> getAccountUsers(long accountEntryId);

	public long getAccountUsersCount(long accountEntryId);

	public BaseModelSearchResult<User> searchAccountRoleUsers(
			long accountEntryId, long accountRoleId, String keywords, int start,
			int end, OrderByComparator obc)
		throws PortalException;

	public BaseModelSearchResult<User> searchAccountUsers(
			long accountEntryId, String keywords, int status, int cur,
			int delta, String sortField, boolean reverse)
		throws PortalException;

	public BaseModelSearchResult<User> searchAccountUsers(
			long accountEntryId, String[] emailAddressDomains, String keywords,
			int status, int cur, int delta, String sortField, boolean reverse)
		throws PortalException;

	public BaseModelSearchResult<User> searchAccountUsers(
			long[] accountEntryIds, String keywords, int status, int cur,
			int delta, String sortField, boolean reverse)
		throws PortalException;

}