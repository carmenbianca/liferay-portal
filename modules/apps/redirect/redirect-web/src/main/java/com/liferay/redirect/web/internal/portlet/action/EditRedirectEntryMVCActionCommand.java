/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.redirect.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.redirect.model.RedirectEntry;
import com.liferay.redirect.service.RedirectEntryService;
import com.liferay.redirect.web.internal.constants.RedirectPortletKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(
	property = {
		"javax.portlet.name=" + RedirectPortletKeys.REDIRECT,
		"mvc.command.name=/redirect/edit_redirect_entry"
	},
	service = MVCActionCommand.class
)
public class EditRedirectEntryMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long redirectEntryId = ParamUtil.getLong(
			actionRequest, "redirectEntryId");

		String destinationURL = ParamUtil.getString(
			actionRequest, "destinationURL");
		Date expirationDate = _getExpirationDate(actionRequest, themeDisplay);
		boolean permanent = ParamUtil.getBoolean(actionRequest, "permanent");
		String sourceURL = ParamUtil.getString(actionRequest, "sourceURL");

		try {
			if (redirectEntryId == 0) {
				_redirectEntryService.addRedirectEntry(
					themeDisplay.getScopeGroupId(), destinationURL,
					expirationDate, permanent, sourceURL,
					ServiceContextFactory.getInstance(
						RedirectEntry.class.getName(), actionRequest));
			}
			else {
				_redirectEntryService.updateRedirectEntry(
					redirectEntryId, destinationURL, expirationDate, permanent,
					sourceURL);
			}
		}
		catch (Exception exception) {
			SessionErrors.add(actionRequest, exception.getClass(), exception);

			actionResponse.setRenderParameter(
				"mvcRenderCommandName", "/redirect/edit_redirect_entry");

			hideDefaultSuccessMessage(actionRequest);
		}
	}

	private Date _getExpirationDate(
		ActionRequest actionRequest, ThemeDisplay themeDisplay) {

		String expirationDateString = ParamUtil.getString(
			actionRequest, "expirationDate");

		if (Validator.isNull(expirationDateString)) {
			return null;
		}

		return GetterUtil.getDate(
			expirationDateString,
			DateFormatFactoryUtil.getSimpleDateFormat(
				"yyyy-MM-dd", themeDisplay.getLocale()),
			null);
	}

	@Reference
	private RedirectEntryService _redirectEntryService;

}