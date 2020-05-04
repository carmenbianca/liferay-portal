/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.retriever;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.search.BaseModelSearchResult;

/**
 * @author Pei-Jung Lan
 */
public interface AccountOrganizationRetriever {

	public BaseModelSearchResult<Organization> searchAccountOrganizations(
			long accountEntryId, String keywords, int cur, int delta,
			String sortField, boolean reverse)
		throws PortalException;

}