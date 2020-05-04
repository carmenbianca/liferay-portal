/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.license.manager.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.license.manager.web.internal.constants.LicenseManagerPortletKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Fellwock
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=500",
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_APPS
	},
	service = PanelApp.class
)
public class LicenseManagerPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return LicenseManagerPortletKeys.LICENSE_MANAGER;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + LicenseManagerPortletKeys.LICENSE_MANAGER + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}