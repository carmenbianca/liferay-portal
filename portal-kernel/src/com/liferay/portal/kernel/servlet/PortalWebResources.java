/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.ServletContext;

/**
 * @author Peter Fellwock
 */
public interface PortalWebResources {

	public String getContextPath();

	public long getLastModified();

	public String getResourceType();

	public ServletContext getServletContext();

}