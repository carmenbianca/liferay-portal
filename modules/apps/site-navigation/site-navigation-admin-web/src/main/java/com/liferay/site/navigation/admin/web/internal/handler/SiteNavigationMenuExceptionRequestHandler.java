/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.admin.web.internal.handler;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.site.navigation.exception.DuplicateSiteNavigationMenuException;
import com.liferay.site.navigation.exception.SiteNavigationMenuNameException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jürgen Kappler
 */
@Component(
	immediate = true, service = SiteNavigationMenuExceptionRequestHandler.class
)
public class SiteNavigationMenuExceptionRequestHandler {

	public void handlePortalException(
			ActionRequest actionRequest, ActionResponse actionResponse,
			PortalException portalException)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String errorMessage = "an-unexpected-error-occurred";

		if (portalException instanceof DuplicateSiteNavigationMenuException) {
			errorMessage = "please-enter-a-unique-name";
		}
		else if (portalException instanceof SiteNavigationMenuNameException) {
			errorMessage = "please-enter-a-valid-name";
		}

		JSONObject jsonObject = JSONUtil.put(
			"error", LanguageUtil.get(themeDisplay.getLocale(), errorMessage));

		JSONPortletResponseUtil.writeJSON(
			actionRequest, actionResponse, jsonObject);
	}

}