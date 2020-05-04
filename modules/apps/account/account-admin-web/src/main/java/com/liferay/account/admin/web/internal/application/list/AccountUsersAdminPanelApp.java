/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.account.admin.web.internal.application.list;

import com.liferay.account.constants.AccountPanelCategoryKeys;
import com.liferay.account.constants.AccountPortletKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Albert Lee
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=200",
		"panel.category.key=" + AccountPanelCategoryKeys.CONTROL_PANEL_ACCOUNT_ENTRIES_ADMIN
	},
	service = PanelApp.class
)
public class AccountUsersAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return AccountPortletKeys.ACCOUNT_USERS_ADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + AccountPortletKeys.ACCOUNT_USERS_ADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}