/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.servlet.taglib;

import com.liferay.portal.kernel.log.Log;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Philip Jones
 */
public abstract class BaseJSPDynamicInclude extends BaseDynamicInclude {

	@Override
	public void include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String key)
		throws IOException {

		RequestDispatcher requestDispatcher =
			_servletContext.getRequestDispatcher(getJspPath());

		try {
			requestDispatcher.include(httpServletRequest, httpServletResponse);
		}
		catch (ServletException servletException) {
			Log log = getLog();

			log.error(
				"Unable to include JSP " + getJspPath(), servletException);

			throw new IOException(
				"Unable to include JSP " + getJspPath(), servletException);
		}
	}

	@Override
	public void register(
		DynamicInclude.DynamicIncludeRegistry dynamicIncludeRegistry) {
	}

	protected abstract String getJspPath();

	protected abstract Log getLog();

	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private ServletContext _servletContext;

}