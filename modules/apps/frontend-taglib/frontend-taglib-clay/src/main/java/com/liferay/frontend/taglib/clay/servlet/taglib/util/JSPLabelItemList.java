/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * @author Carlos Lancha
 */
public class JSPLabelItemList extends LabelItemList {

	public JSPLabelItemList(PageContext pageContext) {
		renderResponse = (RenderResponse)pageContext.findAttribute(
			"renderResponse");
		request = (HttpServletRequest)pageContext.getRequest();
	}

	protected RenderResponse renderResponse;
	protected HttpServletRequest request;

}