/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.web.internal.application.list;

import com.liferay.app.builder.constants.AppBuilderPortletKeys;
import com.liferay.app.builder.web.internal.constants.AppBuilderPanelCategoryKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Bruno Farache
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + AppBuilderPanelCategoryKeys.CONTROL_PANEL_APP_BUILDER
	},
	service = PanelApp.class
)
public class AppBuilderPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return AppBuilderPortletKeys.CUSTOM_OBJECTS;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + AppBuilderPortletKeys.CUSTOM_OBJECTS + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}