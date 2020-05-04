/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.admin.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.site.navigation.admin.constants.SiteNavigationAdminPortletKeys;
import com.liferay.site.navigation.service.SiteNavigationMenuService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SiteNavigationAdminPortletKeys.SITE_NAVIGATION_ADMIN,
		"mvc.command.name=/navigation_menu/delete_site_navigation_menu"
	},
	service = MVCActionCommand.class
)
public class DeleteSiteNavigationMenuMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long[] siteNavigationMenuIds = null;

		long siteNavigationMenuId = ParamUtil.getLong(
			actionRequest, "siteNavigationMenuId");

		if (siteNavigationMenuId > 0) {
			siteNavigationMenuIds = new long[] {siteNavigationMenuId};
		}
		else {
			siteNavigationMenuIds = ParamUtil.getLongValues(
				actionRequest, "rowIds");
		}

		for (long deleteSiteNavigationMenuId : siteNavigationMenuIds) {
			_siteNavigationMenuService.deleteSiteNavigationMenu(
				deleteSiteNavigationMenuId);
		}
	}

	@Reference
	private SiteNavigationMenuService _siteNavigationMenuService;

}