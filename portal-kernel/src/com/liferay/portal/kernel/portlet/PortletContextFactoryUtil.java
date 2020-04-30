/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.model.Portlet;

import javax.portlet.PortletContext;

import javax.servlet.ServletContext;

/**
 * @author Michael C. Han
 */
public class PortletContextFactoryUtil {

	public static PortletContext create(
		Portlet portlet, ServletContext servletContext) {

		return getPortletContextFactory().create(portlet, servletContext);
	}

	public static PortletContext createUntrackedInstance(
		Portlet portlet, ServletContext servletContext) {

		return getPortletContextFactory().createUntrackedInstance(
			portlet, servletContext);
	}

	public static void destroy(Portlet portlet) {
		getPortletContextFactory().destroy(portlet);
	}

	public static PortletContextFactory getPortletContextFactory() {
		return _portletContextFactory;
	}

	public void setPortletContextFactory(
		PortletContextFactory portletContextFactory) {

		_portletContextFactory = portletContextFactory;
	}

	private static PortletContextFactory _portletContextFactory;

}