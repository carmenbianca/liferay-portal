/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.web.internal.display.context;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletRequest;

/**
 * @author André de Oliveira
 */
public class PortletRequestThemeDisplaySupplier
	implements ThemeDisplaySupplier {

	public PortletRequestThemeDisplaySupplier(PortletRequest portletRequest) {
		_portletRequest = portletRequest;
	}

	@Override
	public ThemeDisplay getThemeDisplay() {
		return (ThemeDisplay)_portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	private final PortletRequest _portletRequest;

}