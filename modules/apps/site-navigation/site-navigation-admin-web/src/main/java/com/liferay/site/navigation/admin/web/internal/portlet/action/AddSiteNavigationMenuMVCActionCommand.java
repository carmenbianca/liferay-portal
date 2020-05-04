/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.admin.web.internal.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.site.navigation.admin.constants.SiteNavigationAdminPortletKeys;
import com.liferay.site.navigation.admin.web.internal.handler.SiteNavigationMenuExceptionRequestHandler;
import com.liferay.site.navigation.constants.SiteNavigationConstants;
import com.liferay.site.navigation.model.SiteNavigationMenu;
import com.liferay.site.navigation.service.SiteNavigationMenuService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SiteNavigationAdminPortletKeys.SITE_NAVIGATION_ADMIN,
		"mvc.command.name=/navigation_menu/add_site_navigation_menu"
	},
	service = MVCActionCommand.class
)
public class AddSiteNavigationMenuMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String name = ParamUtil.getString(actionRequest, "name");

		try {
			Group scopeGroup = themeDisplay.getScopeGroup();

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				actionRequest);

			SiteNavigationMenu siteNavigationMenu =
				_siteNavigationMenuService.addSiteNavigationMenu(
					serviceContext.getScopeGroupId(), name,
					SiteNavigationConstants.TYPE_DEFAULT,
					!scopeGroup.isCompany(), serviceContext);

			JSONObject jsonObject = JSONUtil.put(
				"redirectURL",
				_getRedirectURL(
					actionRequest,
					siteNavigationMenu.getSiteNavigationMenuId()));

			JSONPortletResponseUtil.writeJSON(
				actionRequest, actionResponse, jsonObject);
		}
		catch (PortalException portalException) {
			hideDefaultSuccessMessage(actionRequest);

			_siteNavigationMenuExceptionRequestHandler.handlePortalException(
				actionRequest, actionResponse, portalException);
		}
	}

	private String _getRedirectURL(
		ActionRequest actionRequest, long siteNavigationMenuId) {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		PortletURL redirectURL = PortletURLFactoryUtil.create(
			actionRequest, SiteNavigationAdminPortletKeys.SITE_NAVIGATION_ADMIN,
			themeDisplay.getPlid(), ActionRequest.RENDER_PHASE);

		redirectURL.setParameter("mvcPath", "/edit_site_navigation_menu.jsp");
		redirectURL.setParameter("redirect", redirect);
		redirectURL.setParameter(
			"siteNavigationMenuId", String.valueOf(siteNavigationMenuId));

		return redirectURL.toString();
	}

	@Reference
	private SiteNavigationMenuExceptionRequestHandler
		_siteNavigationMenuExceptionRequestHandler;

	@Reference
	private SiteNavigationMenuService _siteNavigationMenuService;

}