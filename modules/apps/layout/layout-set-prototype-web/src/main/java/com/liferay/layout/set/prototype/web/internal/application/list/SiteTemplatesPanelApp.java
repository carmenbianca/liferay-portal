/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.set.prototype.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.layout.set.prototype.constants.LayoutSetPrototypePortletKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=200",
		"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_SITES
	},
	service = PanelApp.class
)
public class SiteTemplatesPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return LayoutSetPrototypePortletKeys.LAYOUT_SET_PROTOTYPE;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + LayoutSetPrototypePortletKeys.LAYOUT_SET_PROTOTYPE + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}