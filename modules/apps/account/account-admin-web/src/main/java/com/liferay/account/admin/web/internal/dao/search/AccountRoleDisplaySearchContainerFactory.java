/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.dao.search;

import com.liferay.account.admin.web.internal.display.AccountRoleDisplay;
import com.liferay.account.constants.AccountConstants;
import com.liferay.account.model.AccountRole;
import com.liferay.account.service.AccountRoleLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.comparator.RoleNameComparator;
import com.liferay.portal.vulcan.util.TransformUtil;

/**
 * @author Pei-Jung Lan
 */
public class AccountRoleDisplaySearchContainerFactory {

	public static SearchContainer create(
		long accountEntryId, LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		SearchContainer searchContainer = new SearchContainer(
			liferayPortletRequest, liferayPortletResponse.createRenderURL(),
			null, "there-are-no-roles");

		searchContainer.setId("accountRoles");
		searchContainer.setOrderByCol("name");

		String orderByType = ParamUtil.getString(
			liferayPortletRequest, "orderByType", "asc");

		searchContainer.setOrderByType(orderByType);

		searchContainer.setRowChecker(
			new AccountRoleRowChecker(liferayPortletResponse));

		String keywords = ParamUtil.getString(
			liferayPortletRequest, "keywords");

		BaseModelSearchResult<AccountRole> baseModelSearchResult =
			AccountRoleLocalServiceUtil.searchAccountRoles(
				new long[] {
					accountEntryId, AccountConstants.ACCOUNT_ENTRY_ID_DEFAULT
				},
				keywords, searchContainer.getStart(), searchContainer.getEnd(),
				new RoleNameComparator(orderByType.equals("asc")));

		searchContainer.setResults(
			TransformUtil.transform(
				baseModelSearchResult.getBaseModels(), AccountRoleDisplay::of));
		searchContainer.setTotal(baseModelSearchResult.getLength());

		return searchContainer;
	}

}