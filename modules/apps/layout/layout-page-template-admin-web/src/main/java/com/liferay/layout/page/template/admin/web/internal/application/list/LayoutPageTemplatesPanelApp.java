/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.layout.page.template.admin.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.layout.page.template.admin.constants.LayoutPageTemplateAdminPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.staging.StagingGroupHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kapler
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=110",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_BUILD
	},
	service = PanelApp.class
)
public class LayoutPageTemplatesPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return LayoutPageTemplateAdminPortletKeys.LAYOUT_PAGE_TEMPLATES;
	}

	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group)
		throws PortalException {

		if (_stagingGroupHelper.isLocalLiveGroup(group) ||
			_stagingGroupHelper.isRemoteLiveGroup(group)) {

			return false;
		}

		return super.isShow(permissionChecker, group);
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + LayoutPageTemplateAdminPortletKeys.LAYOUT_PAGE_TEMPLATES + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

	@Reference
	private StagingGroupHelper _stagingGroupHelper;

}