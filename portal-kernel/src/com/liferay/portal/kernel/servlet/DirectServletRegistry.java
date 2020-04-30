/*
 * SPDX-FileCopyrightText: © 2016 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.Servlet;

/**
 * @author Shuyang Zhou
 */
public interface DirectServletRegistry {

	public void clearServlets();

	public Servlet getServlet(String path);

	public void putServlet(String path, Servlet servlet);

}