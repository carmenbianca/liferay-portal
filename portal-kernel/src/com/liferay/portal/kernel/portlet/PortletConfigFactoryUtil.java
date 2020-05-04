/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.model.Portlet;

import javax.portlet.PortletConfig;

import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 */
public class PortletConfigFactoryUtil {

	public static PortletConfig create(
		Portlet portlet, ServletContext servletContext) {

		return getPortletConfigFactory().create(portlet, servletContext);
	}

	public static void destroy(Portlet portlet) {
		getPortletConfigFactory().destroy(portlet);
	}

	public static PortletConfig get(Portlet portlet) {
		return getPortletConfigFactory().get(portlet);
	}

	public static PortletConfig get(String portletId) {
		return getPortletConfigFactory().get(portletId);
	}

	public static PortletConfigFactory getPortletConfigFactory() {
		return _portletConfigFactory;
	}

	public static PortletConfig update(Portlet portlet) {
		return getPortletConfigFactory().update(portlet);
	}

	public void setPortletConfigFactory(
		PortletConfigFactory portletConfigFactory) {

		_portletConfigFactory = portletConfigFactory;
	}

	private static PortletConfigFactory _portletConfigFactory;

}