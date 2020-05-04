/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.jsp.compiler.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Matthew Tambara
 */
public final class PrecompileTestServlet extends HttpServlet {

	@Override
	public void service(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException {

		httpServletResponse.setContentType("text/html");

		PrintWriter printWriter = httpServletResponse.getWriter();

		printWriter.println("<html>");
		printWriter.println("\t<head><title>JspPrecompileTest</title></head>");
		printWriter.println("\t<body>");
		printWriter.println("\t\t<h1>Precompiled</h1>");
		printWriter.println("\t</body>");
		printWriter.println("</html>");
	}

}