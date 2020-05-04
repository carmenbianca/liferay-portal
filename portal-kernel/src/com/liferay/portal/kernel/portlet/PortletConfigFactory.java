/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.model.Portlet;

import javax.portlet.PortletConfig;

import javax.servlet.ServletContext;

/**
 * @author Brian Wing Shun Chan
 */
public interface PortletConfigFactory {

	public PortletConfig create(Portlet portlet, ServletContext servletContext);

	public void destroy(Portlet portlet);

	public PortletConfig get(Portlet portlet);

	public PortletConfig get(String portletId);

	public PortletConfig update(Portlet portlet);

}