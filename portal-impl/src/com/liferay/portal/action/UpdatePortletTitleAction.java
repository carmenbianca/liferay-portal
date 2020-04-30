/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.action;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.permission.PortletPermissionUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.struts.JSONAction;
import com.liferay.portlet.InvokerPortletUtil;

import javax.portlet.PortletPreferences;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Ming-Gih Lam
 */
public class UpdatePortletTitleAction extends JSONAction {

	@Override
	public String getJSON(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws Exception {

		HttpSession session = httpServletRequest.getSession();

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		PermissionChecker permissionChecker =
			themeDisplay.getPermissionChecker();

		String portletId = ParamUtil.getString(httpServletRequest, "portletId");

		if (!PortletPermissionUtil.contains(
				permissionChecker, layout, portletId,
				ActionKeys.CONFIGURATION)) {

			return null;
		}

		String languageId = LanguageUtil.getLanguageId(httpServletRequest);
		String title = ParamUtil.getString(httpServletRequest, "title");

		PortletPreferences portletSetup =
			themeDisplay.getStrictLayoutPortletSetup(layout, portletId);

		portletSetup.setValue("portletSetupTitle_" + languageId, title);
		portletSetup.setValue("portletSetupUseCustomTitle", "true");

		portletSetup.store();

		if (layout.isTypeContent()) {
			Layout draftLayout = LayoutLocalServiceUtil.fetchLayout(
				PortalUtil.getClassNameId(Layout.class), layout.getPlid());

			if (draftLayout != null) {
				PortletPreferences draftLayoutPortletSetup =
					themeDisplay.getStrictLayoutPortletSetup(
						draftLayout, portletId);

				draftLayoutPortletSetup.setValue(
					"portletSetupTitle_" + languageId, title);
				draftLayoutPortletSetup.setValue(
					"portletSetupUseCustomTitle", "true");

				draftLayoutPortletSetup.store();
			}
		}

		InvokerPortletUtil.clearResponse(
			session, layout.getPrimaryKey(), portletId,
			LanguageUtil.getLanguageId(httpServletRequest));

		return null;
	}

}