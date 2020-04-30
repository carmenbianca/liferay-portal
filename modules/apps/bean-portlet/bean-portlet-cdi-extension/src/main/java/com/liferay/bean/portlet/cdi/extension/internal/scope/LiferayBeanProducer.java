/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.bean.portlet.cdi.extension.internal.scope;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.enterprise.inject.Produces;

import javax.inject.Inject;
import javax.inject.Named;

import javax.portlet.PortletRequest;
import javax.portlet.annotations.PortletRequestScoped;

/**
 * @author Neil Griffin
 */
public class LiferayBeanProducer {

	@Named("themeDisplay")
	@PortletRequestScoped
	@Produces
	public ThemeDisplay getThemeDisplay() {
		if (_portletRequest == null) {
			return null;
		}

		return (ThemeDisplay)_portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	@Inject
	private PortletRequest _portletRequest;

}