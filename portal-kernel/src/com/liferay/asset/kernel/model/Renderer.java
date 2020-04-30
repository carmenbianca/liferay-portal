/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.kernel.model;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Julio Camarero
 */
public interface Renderer {

	public String getClassName();

	public long getClassPK();

	public String getIconCssClass() throws PortalException;

	public String getSummary(
		PortletRequest portletRequest, PortletResponse portletResponse);

	public String getTitle(Locale locale);

	public boolean include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String template)
		throws Exception;

}