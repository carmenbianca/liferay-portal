/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.dynamic.section;

import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.util.StringBundler;
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
public abstract class BaseJSPDynamicSection implements DynamicSection {

	@Override
	public StringBundler modify(StringBundler sb, PageContext pageContext)
		throws IOException, ServletException {

		ServletContext servletContext = getServletContext();

		RequestDispatcher requestDispatcher =
			servletContext.getRequestDispatcher(getJspPath());

		try (UnsyncStringWriter unsyncStringWriter = new UnsyncStringWriter()) {
			HttpServletResponse httpServletResponse = new PipingServletResponse(
				(HttpServletResponse)pageContext.getResponse(),
				unsyncStringWriter);

			requestDispatcher.include(
				pageContext.getRequest(), httpServletResponse);

			return unsyncStringWriter.getStringBundler();
		}
	}

	protected abstract String getJspPath();

	protected abstract ServletContext getServletContext();

}