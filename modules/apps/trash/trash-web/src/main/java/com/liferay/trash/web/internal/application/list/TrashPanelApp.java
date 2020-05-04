/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.trash.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.trash.constants.TrashPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides an implementation of <code>PanelApp</code> (in the
 * <code>com.liferay.application.list.api</code> module) to render a Recycle Bin
 * portlet entry in the Site Administration section.
 *
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_RECYCLE_BIN
	},
	service = PanelApp.class
)
public class TrashPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return TrashPortletKeys.TRASH;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + TrashPortletKeys.TRASH + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}