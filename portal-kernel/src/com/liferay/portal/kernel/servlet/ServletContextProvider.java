/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Michael Young
 */
public interface ServletContextProvider {

	public HttpServletRequest getHttpServletRequest(
		GenericPortlet portlet, PortletRequest portletRequest);

	public HttpServletResponse getHttpServletResponse(
		GenericPortlet portlet, PortletResponse portletResponse);

	public ServletContext getServletContext(GenericPortlet portlet);

	public ServletContext getServletContext(ServletContext servletContext);

}