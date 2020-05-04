/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.settings.web.internal.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.PortletPreferencesLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.settings.portlet.action.PortalSettingsFormContributor;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author Michael C. Han
 */
public class DeletePortalSettingsFormMVCActionCommand
	extends BasePortalSettingsFormMVCActionCommand {

	public DeletePortalSettingsFormMVCActionCommand(
		PortletPreferencesLocalService portletPreferencesLocalService,
		PortalSettingsFormContributor portalSettingsFormContributor) {

		super(portalSettingsFormContributor);

		_portletPreferencesLocalService = portletPreferencesLocalService;
	}

	protected void deleteSettings(ThemeDisplay themeDisplay)
		throws PortalException {

		_portletPreferencesLocalService.deletePortletPreferences(
			themeDisplay.getCompanyId(), PortletKeys.PREFS_OWNER_TYPE_COMPANY,
			0, getSettingsId());
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			ThemeDisplay themeDisplay =
				(ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			if (!hasPermissions(actionRequest, actionResponse, themeDisplay)) {
				return;
			}

			deleteSettings(themeDisplay);
		}
		catch (PortalException portalException) {
			SessionErrors.add(
				actionRequest, portalException.getClass(), portalException);

			String redirect = ParamUtil.getString(actionRequest, "redirect");

			if (Validator.isNotNull(redirect)) {
				actionResponse.sendRedirect(redirect);
			}
		}
	}

	@Override
	protected void doValidateForm(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
	}

	private final PortletPreferencesLocalService
		_portletPreferencesLocalService;

}