/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.dao.search;

import com.liferay.account.admin.web.internal.display.AccountUserDisplay;
import com.liferay.account.service.AccountEntryUserRelLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;

import javax.portlet.PortletResponse;

/**
 * @author Pei-Jung Lan
 */
public class SelectAccountUserRowChecker extends EmptyOnClickRowChecker {

	public SelectAccountUserRowChecker(
		PortletResponse portletResponse, long accountEntryId) {

		super(portletResponse);

		_accountEntryId = accountEntryId;
	}

	@Override
	public boolean isChecked(Object obj) {
		AccountUserDisplay accountUserDisplay = (AccountUserDisplay)obj;

		if (AccountEntryUserRelLocalServiceUtil.hasAccountEntryUserRel(
				_accountEntryId, accountUserDisplay.getUserId())) {

			return true;
		}

		return false;
	}

	@Override
	public boolean isDisabled(Object obj) {
		return isChecked(obj);
	}

	private final long _accountEntryId;

}