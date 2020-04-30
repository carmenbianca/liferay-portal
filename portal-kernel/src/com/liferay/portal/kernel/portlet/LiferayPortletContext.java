/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.portlet;

import com.liferay.portal.kernel.model.Portlet;

import javax.portlet.PortletContext;

import javax.servlet.ServletContext;

/**
 * @author Raymond Augé
 */
public interface LiferayPortletContext extends PortletContext {

	public Portlet getPortlet();

	public ServletContext getServletContext();

}