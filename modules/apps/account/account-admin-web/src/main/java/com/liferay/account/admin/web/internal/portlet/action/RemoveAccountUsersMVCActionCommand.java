/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.portlet.action;

import com.liferay.account.constants.AccountPortletKeys;
import com.liferay.account.exception.NoSuchEntryUserRelException;
import com.liferay.account.service.AccountEntryUserRelLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

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
		"mvc.command.name=/account_admin/remove_account_users"
	},
	service = MVCActionCommand.class
)
public class RemoveAccountUsersMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			long accountEntryId = ParamUtil.getLong(
				actionRequest, "accountEntryId");
			long[] accountUserIds = ParamUtil.getLongValues(
				actionRequest, "accountUserIds");

			_accountEntryUserRelLocalService.deleteAccountEntryUserRels(
				accountEntryId, accountUserIds);

			String redirect = ParamUtil.getString(actionRequest, "redirect");

			if (Validator.isNotNull(redirect)) {
				sendRedirect(actionRequest, actionResponse, redirect);
			}
		}
		catch (Exception exception) {
			if (exception instanceof NoSuchEntryUserRelException) {
				SessionErrors.add(actionRequest, exception.getClass());
			}
			else {
				throw exception;
			}

			actionResponse.setRenderParameter(
				"mvcPath", "/account_entries_admin/view.jsp");
		}
	}

	@Reference
	private AccountEntryUserRelLocalService _accountEntryUserRelLocalService;

}