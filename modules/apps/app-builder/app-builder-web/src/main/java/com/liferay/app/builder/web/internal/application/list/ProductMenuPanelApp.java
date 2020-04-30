/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.web.internal.application.list;

import com.liferay.app.builder.constants.AppBuilderAppConstants;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jeyvison Nascimento
 */
public class ProductMenuPanelApp extends BasePanelApp {

	public ProductMenuPanelApp(
		String panelCategoryKey, String portletId, long[] siteIds) {

		_panelCategoryKey = panelCategoryKey;
		_portletId = portletId;
		_siteIds = siteIds;
	}

	@Override
	public String getKey() {
		return _portletId;
	}

	@Override
	public String getPortletId() {
		return _portletId;
	}

	@Override
	public PortletURL getPortletURL(HttpServletRequest httpServletRequest) {
		PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
			httpServletRequest, getPortletId(), PortletRequest.RENDER_PHASE);

		Group group = groupProvider.getGroup(httpServletRequest);

		if (group == null) {
			return portletURL;
		}

		portletURL.setParameter(
			"p_v_l_s_g_id", String.valueOf(group.getGroupId()));

		return portletURL;
	}

	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group)
		throws PortalException {

		if (super.isShow(permissionChecker, group) &&
			(PanelCategoryKeys.CONTROL_PANEL.equals(_panelCategoryKey) ||
			 ArrayUtil.contains(_siteIds, AppBuilderAppConstants.SITE_ID_ALL) ||
			 ArrayUtil.contains(_siteIds, group.getGroupId()))) {

			return true;
		}

		return false;
	}

	private final String _panelCategoryKey;
	private final String _portletId;
	private final long[] _siteIds;

}