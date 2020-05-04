/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.servlet;

import com.liferay.portal.kernel.security.access.control.AccessControlThreadLocal;
import com.liferay.portal.kernel.servlet.PluginContextListener;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class AxisServlet extends com.liferay.util.axis.AxisServlet {

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		ServletContext servletContext = servletConfig.getServletContext();

		_pluginClassLoader = (ClassLoader)servletContext.getAttribute(
			PluginContextListener.PLUGIN_CLASS_LOADER);

		if (_pluginClassLoader == null) {
			super.init(servletConfig);
		}
		else {
			Thread currentThread = Thread.currentThread();

			ClassLoader contextClassLoader =
				currentThread.getContextClassLoader();

			try {
				currentThread.setContextClassLoader(_pluginClassLoader);

				super.init(servletConfig);
			}
			finally {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public void service(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException, ServletException {

		boolean remoteAccess = AccessControlThreadLocal.isRemoteAccess();

		try {
			AccessControlThreadLocal.setRemoteAccess(true);

			if (_pluginClassLoader == null) {
				super.service(httpServletRequest, httpServletResponse);
			}
			else {
				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader =
					currentThread.getContextClassLoader();

				try {
					currentThread.setContextClassLoader(_pluginClassLoader);

					super.service(httpServletRequest, httpServletResponse);
				}
				finally {
					currentThread.setContextClassLoader(contextClassLoader);
				}
			}
		}
		catch (IOException ioException) {
			throw ioException;
		}
		catch (ServletException servletException) {
			throw servletException;
		}
		catch (Exception exception) {
			throw new ServletException(exception);
		}
		finally {
			AccessControlThreadLocal.setRemoteAccess(remoteAccess);
		}
	}

	private ClassLoader _pluginClassLoader;

}