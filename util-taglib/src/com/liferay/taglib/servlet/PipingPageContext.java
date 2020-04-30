/*
 * SPDX-FileCopyrightText: © 2014 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.taglib.servlet;

import java.io.Writer;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

/**
 * @author Shuyang Zhou
 */
public class PipingPageContext extends PageContextWrapper {

	public PipingPageContext(PageContext pageContext, Writer writer) {
		super(pageContext);

		_jspWriter = new PipingJspWriter(writer);
	}

	@Override
	public JspWriter getOut() {
		return _jspWriter;
	}

	private final JspWriter _jspWriter;

}