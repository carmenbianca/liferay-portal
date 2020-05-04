/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.application.list;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Provides a skeletal implementation of the {@link PanelApp} with JSP support
 * to minimize the effort required to implement this interface.
 *
 * <p>
 * To implement a JSP application, this class should be extended and {@link
 * #getJspPath()} should be implemented, which returns a path for the main JSP
 * application view in the current servlet context. The servlet context should
 * also be set using {@link #setServletContext(ServletContext)}, which uses the
 * appropriate servlet context for JSP pages. If the servlet context is not set,
 * {@link #include(HttpServletRequest, HttpServletResponse)} will throw a
 * <code>NullPointerException</code>.
 * </p>
 *
 * <p>
 * JSP applications are included within JSP application categories defined by
 * {@link BaseJSPPanelCategory} implementations.
 * </p>
 *
 * @author Julio Camarero
 * @see    BasePanelApp
 * @see    PanelApp
 */
public abstract class BaseJSPPanelApp extends BasePanelApp {

	public abstract String getJspPath();

	@Override
	public boolean include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException {

		String jspPath = getJspPath();

		if (Validator.isNull(jspPath)) {
			return false;
		}

		RequestDispatcher requestDispatcher =
			_servletContext.getRequestDispatcher(jspPath);

		try {
			requestDispatcher.include(httpServletRequest, httpServletResponse);
		}
		catch (ServletException servletException) {
			_log.error("Unable to include " + jspPath, servletException);

			return false;
		}

		return true;
	}

	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseJSPPanelApp.class);

	private ServletContext _servletContext;

}