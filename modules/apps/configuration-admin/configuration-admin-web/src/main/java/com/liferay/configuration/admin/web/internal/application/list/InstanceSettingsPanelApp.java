/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.configuration.admin.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.configuration.admin.constants.ConfigurationAdminPortletKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Drew Brokke
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=210",
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION
	},
	service = PanelApp.class
)
public class InstanceSettingsPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return ConfigurationAdminPortletKeys.INSTANCE_SETTINGS;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + ConfigurationAdminPortletKeys.INSTANCE_SETTINGS + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}