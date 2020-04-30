/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet;

import javax.servlet.Servlet;

/**
 * @author Shuyang Zhou
 */
public class DirectServletRegistryUtil {

	public static void clearServlets() {
		getDirectServletRegistry().clearServlets();
	}

	public static DirectServletRegistry getDirectServletRegistry() {
		return _directServletRegistry;
	}

	public static Servlet getServlet(String path) {
		return getDirectServletRegistry().getServlet(path);
	}

	public static void putServlet(String path, Servlet servlet) {
		getDirectServletRegistry().putServlet(path, servlet);
	}

	public void setDirectServletRegistry(
		DirectServletRegistry directServletRegistry) {

		_directServletRegistry = directServletRegistry;
	}

	private static DirectServletRegistry _directServletRegistry;

}