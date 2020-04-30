/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.change.tracking.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.change.tracking.constants.CTPortletKeys;
import com.liferay.change.tracking.model.CTPreferences;
import com.liferay.change.tracking.service.CTPreferencesLocalService;
import com.liferay.change.tracking.web.internal.constants.CTPanelCategoryKeys;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Máté Thurzó
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + CTPanelCategoryKeys.CONTROL_PANEL_CHANGE_LISTS
	},
	service = PanelApp.class
)
public class ChangeListsPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return CTPortletKeys.CHANGE_LISTS;
	}

	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group) {
		CTPreferences ctPreferences =
			_ctPreferencesLocalService.fetchCTPreferences(
				group.getCompanyId(), 0);

		if (ctPreferences == null) {
			return false;
		}

		return true;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + CTPortletKeys.CHANGE_LISTS + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

	@Reference
	private CTPreferencesLocalService _ctPreferencesLocalService;

}