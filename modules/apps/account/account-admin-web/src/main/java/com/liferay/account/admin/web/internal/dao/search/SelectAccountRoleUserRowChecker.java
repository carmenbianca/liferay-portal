/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.dao.search;

import com.liferay.account.admin.web.internal.display.AccountUserDisplay;
import com.liferay.account.model.AccountEntry;
import com.liferay.account.model.AccountRole;
import com.liferay.account.service.AccountEntryLocalServiceUtil;
import com.liferay.account.service.AccountRoleLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;

import javax.portlet.PortletResponse;

/**
 * @author Pei-Jung Lan
 */
public class SelectAccountRoleUserRowChecker extends EmptyOnClickRowChecker {

	public SelectAccountRoleUserRowChecker(
		PortletResponse portletResponse, long accountEntryId,
		long accountRoleId) {

		super(portletResponse);

		_accountEntryId = accountEntryId;
		_accountRoleId = accountRoleId;
	}

	@Override
	public boolean isChecked(Object obj) {
		AccountUserDisplay accountUserDisplay = (AccountUserDisplay)obj;

		AccountEntry accountEntry =
			AccountEntryLocalServiceUtil.fetchAccountEntry(_accountEntryId);

		AccountRole accountRole = AccountRoleLocalServiceUtil.fetchAccountRole(
			_accountRoleId);

		if (UserGroupRoleLocalServiceUtil.hasUserGroupRole(
				accountUserDisplay.getUserId(),
				accountEntry.getAccountEntryGroupId(),
				accountRole.getRoleId())) {

			return true;
		}

		return false;
	}

	@Override
	public boolean isDisabled(Object obj) {
		return isChecked(obj);
	}

	private final long _accountEntryId;
	private final long _accountRoleId;

}