/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.map;

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
 * @author Jürgen Kappler
 */
public abstract class BaseJSPMapProvider implements MapProvider {

	public abstract String getConfigurationJspPath();

	public abstract String getJspPath();

	@Override
	public boolean include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException {

		return includeJSP(
			httpServletRequest, httpServletResponse, getJspPath());
	}

	@Override
	public boolean includeConfiguration(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException {

		return includeJSP(
			httpServletRequest, httpServletResponse, getConfigurationJspPath());
	}

	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	protected boolean includeJSP(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String jspPath)
		throws IOException {

		if (Validator.isNull(jspPath)) {
			return false;
		}

		RequestDispatcher requestDispatcher =
			_servletContext.getRequestDispatcher(jspPath);

		prepareRequest(httpServletRequest);

		try {
			requestDispatcher.include(httpServletRequest, httpServletResponse);
		}
		catch (ServletException servletException) {
			_log.error("Unable to include " + jspPath, servletException);

			return false;
		}

		return true;
	}

	protected abstract void prepareRequest(
		HttpServletRequest httpServletRequest);

	private static final Log _log = LogFactoryUtil.getLog(
		BaseJSPMapProvider.class);

	private ServletContext _servletContext;

}