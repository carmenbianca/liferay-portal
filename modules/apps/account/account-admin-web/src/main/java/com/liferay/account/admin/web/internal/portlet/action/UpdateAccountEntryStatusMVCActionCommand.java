/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.portlet.action;

import com.liferay.account.constants.AccountPortletKeys;
import com.liferay.account.service.AccountEntryLocalService;
import com.liferay.petra.lang.SafeClosable;
import com.liferay.portal.kernel.messaging.proxy.ProxyModeThreadLocal;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pei-Jung Lan
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AccountPortletKeys.ACCOUNT_ENTRIES_ADMIN,
		"mvc.command.name=/account_admin/update_account_entry_status"
	},
	service = MVCActionCommand.class
)
public class UpdateAccountEntryStatusMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		long[] accountEntryIds = ParamUtil.getLongValues(
			actionRequest, "accountEntryIds");

		if (cmd.equals(Constants.DEACTIVATE)) {
			try (SafeClosable safeClosable =
					ProxyModeThreadLocal.setWithSafeClosable(true)) {

				_accountEntryLocalService.deactivateAccountEntries(
					accountEntryIds);
			}
		}
		else if (cmd.equals(Constants.RESTORE)) {
			try (SafeClosable safeClosable =
					ProxyModeThreadLocal.setWithSafeClosable(true)) {

				_accountEntryLocalService.activateAccountEntries(
					accountEntryIds);
			}
		}
	}

	@Reference
	private AccountEntryLocalService _accountEntryLocalService;

}