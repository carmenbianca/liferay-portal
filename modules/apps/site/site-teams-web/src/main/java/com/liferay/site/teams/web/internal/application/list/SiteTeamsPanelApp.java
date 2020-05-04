/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.teams.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.site.teams.web.internal.constants.SiteTeamsPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=200",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_MEMBERS
	},
	service = PanelApp.class
)
public class SiteTeamsPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return SiteTeamsPortletKeys.SITE_TEAMS;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + SiteTeamsPortletKeys.SITE_TEAMS + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}