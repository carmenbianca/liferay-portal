/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.document.library.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.document.library.constants.DLPortletKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eudaldo Alonso
 */
@Component(
	property = {
		"panel.app.order:Integer=400",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	},
	service = PanelApp.class
)
public class DocumentLibraryPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return DLPortletKeys.DOCUMENT_LIBRARY_ADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + DLPortletKeys.DOCUMENT_LIBRARY_ADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}