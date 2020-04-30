/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.dao.search;

import com.liferay.account.service.AccountEntryOrganizationRelLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.model.Organization;

import javax.portlet.PortletResponse;

/**
 * @author Pei-Jung Lan
 */
public class SelectAccountOrganizationRowChecker
	extends EmptyOnClickRowChecker {

	public SelectAccountOrganizationRowChecker(
		PortletResponse portletResponse, long accountEntryId) {

		super(portletResponse);

		_accountEntryId = accountEntryId;
	}

	@Override
	public boolean isChecked(Object obj) {
		Organization organization = (Organization)obj;

		if (AccountEntryOrganizationRelLocalServiceUtil.
				hasAccountEntryOrganizationRel(
					_accountEntryId, organization.getOrganizationId())) {

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