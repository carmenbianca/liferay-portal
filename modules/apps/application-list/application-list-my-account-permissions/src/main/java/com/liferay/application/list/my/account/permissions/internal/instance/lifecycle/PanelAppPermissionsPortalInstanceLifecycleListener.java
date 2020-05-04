/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.application.list.my.account.permissions.internal.instance.lifecycle;

import com.liferay.application.list.PanelApp;
import com.liferay.application.list.PanelAppRegistry;
import com.liferay.application.list.PanelCategoryRegistry;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.application.list.display.context.logic.PanelCategoryHelper;
import com.liferay.application.list.my.account.permissions.internal.PanelAppMyAccountPermissions;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.service.PortletLocalService;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Drew Brokke
 */
@Component(immediate = true, service = PortalInstanceLifecycleListener.class)
public class PanelAppPermissionsPortalInstanceLifecycleListener
	extends BasePortalInstanceLifecycleListener {

	@Override
	public void portalInstanceRegistered(Company company) throws Exception {
		PanelCategoryHelper panelCategoryHelper = new PanelCategoryHelper(
			_panelAppRegistry, _panelCategoryRegistry);

		List<PanelApp> panelApps = panelCategoryHelper.getAllPanelApps(
			PanelCategoryKeys.USER_MY_ACCOUNT);

		List<Portlet> portlets = new ArrayList<>(panelApps.size());

		for (PanelApp panelApp : panelApps) {
			Portlet portlet = _portletLocalService.getPortletById(
				panelApp.getPortletId());

			portlets.add(portlet);
		}

		_panelAppMyAccountPermissions.initPermissions(
			company.getCompanyId(), portlets);
	}

	@Reference
	private PanelAppMyAccountPermissions _panelAppMyAccountPermissions;

	@Reference
	private PanelAppRegistry _panelAppRegistry;

	@Reference
	private PanelCategoryRegistry _panelCategoryRegistry;

	@Reference
	private PortletLocalService _portletLocalService;

}