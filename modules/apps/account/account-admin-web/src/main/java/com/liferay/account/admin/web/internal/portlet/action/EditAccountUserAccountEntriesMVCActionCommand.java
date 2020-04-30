/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.portlet.action;

import com.liferay.account.constants.AccountPortletKeys;
import com.liferay.account.service.AccountEntryUserRelLocalService;
import com.liferay.petra.lang.SafeClosable;
import com.liferay.portal.kernel.messaging.proxy.ProxyModeThreadLocal;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Albert Lee
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AccountPortletKeys.ACCOUNT_USERS_ADMIN,
		"mvc.command.name=/account_admin/edit_account_user_account_entries"
	},
	service = MVCActionCommand.class
)
public class EditAccountUserAccountEntriesMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] addAccountEntryIds = ParamUtil.getLongValues(
			actionRequest, "addAccountEntryIds");
		long[] deleteAccountEntryIds = ParamUtil.getLongValues(
			actionRequest, "deleteAccountEntryIds");
		long accountUserId = ParamUtil.getLong(actionRequest, "accountUserId");

		try (SafeClosable safeClosable =
				ProxyModeThreadLocal.setWithSafeClosable(true)) {

			_accountEntryUserRelLocalService.updateAccountEntryUserRels(
				addAccountEntryIds, deleteAccountEntryIds, accountUserId);
		}
	}

	@Reference
	private AccountEntryUserRelLocalService _accountEntryUserRelLocalService;

}