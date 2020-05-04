/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bookmarks.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.bookmarks.constants.BookmarksPortletKeys;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Iván Zaera
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=300",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	},
	service = PanelApp.class
)
public class BookmarksPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return BookmarksPortletKeys.BOOKMARKS_ADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + BookmarksPortletKeys.BOOKMARKS_ADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}