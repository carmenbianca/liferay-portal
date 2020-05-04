/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.announcements.web.internal.display.context.util;

import com.liferay.portal.kernel.display.context.util.BaseRequestHelper;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Adolfo Pérez
 */
public class AnnouncementsRequestHelper extends BaseRequestHelper {

	public AnnouncementsRequestHelper(HttpServletRequest httpServletRequest) {
		super(httpServletRequest);
	}

	public PortletPreferences getPortletPreferences() {
		if (_portletPreferences != null) {
			return _portletPreferences;
		}

		HttpServletRequest httpServletRequest = getRequest();

		PortletRequest portletRequest =
			(PortletRequest)httpServletRequest.getAttribute(
				JavaConstants.JAVAX_PORTLET_REQUEST);

		_portletPreferences = portletRequest.getPreferences();

		return _portletPreferences;
	}

	public Group getScopeGroup() {
		if (_scopeGroup != null) {
			return _scopeGroup;
		}

		ThemeDisplay themeDisplay = getThemeDisplay();

		_scopeGroup = themeDisplay.getScopeGroup();

		return _scopeGroup;
	}

	public String getTabs1() {
		if (_tabs1 != null) {
			return _tabs1;
		}

		_tabs1 = ParamUtil.getString(getRequest(), "tabs1", "entries");

		return _tabs1;
	}

	private PortletPreferences _portletPreferences;
	private Group _scopeGroup;
	private String _tabs1;

}