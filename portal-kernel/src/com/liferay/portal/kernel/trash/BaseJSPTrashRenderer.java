/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.trash;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alexander Chow
 */
public abstract class BaseJSPTrashRenderer extends BaseTrashRenderer {

	public abstract String getJspPath(
		HttpServletRequest httpServletRequest, String template);

	@Override
	public boolean include(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, String template)
		throws Exception {

		ServletContext servletContext = getServletContext(httpServletRequest);

		String jspPath = getJspPath(httpServletRequest, template);

		if (Validator.isNull(jspPath)) {
			return false;
		}

		RequestDispatcher requestDispatcher =
			servletContext.getRequestDispatcher(jspPath);

		try {
			requestDispatcher.include(httpServletRequest, httpServletResponse);

			return true;
		}
		catch (ServletException servletException) {
			_log.error("Unable to include JSP " + jspPath, servletException);

			throw new IOException(
				"Unable to include " + jspPath, servletException);
		}
	}

	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	protected ServletContext getServletContext(
		HttpServletRequest httpServletRequest) {

		if (_servletContext != null) {
			return _servletContext;
		}

		return (ServletContext)httpServletRequest.getAttribute(WebKeys.CTX);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseJSPTrashRenderer.class);

	private ServletContext _servletContext;

}