/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.dynamic.section;

import com.liferay.petra.string.StringPool;
import com.liferay.taglib.servlet.PipingServletResponse;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 * @author Matthew Tambara
 */
public abstract class BaseJSPDynamicSectionReplace
	implements DynamicSectionReplace {

	@Override
	public String replace(PageContext pageContext)
		throws IOException, ServletException {

		ServletContext servletContext = getServletContext();

		RequestDispatcher requestDispatcher =
			servletContext.getRequestDispatcher(getJspPath());

		requestDispatcher.include(
			pageContext.getRequest(),
			new PipingServletResponse(
				(HttpServletResponse)pageContext.getResponse(),
				pageContext.getOut()));

		return StringPool.BLANK;
	}

	protected abstract String getJspPath();

	protected abstract ServletContext getServletContext();

}