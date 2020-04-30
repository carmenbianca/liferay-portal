/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.util;

import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * @author Brian Wing Shun Chan
 */
public class JSPNavigationItemList extends NavigationItemList {

	public JSPNavigationItemList(PageContext pageContext) {
		currentURL = (String)pageContext.findAttribute("currentURL");
		renderResponse = (RenderResponse)pageContext.findAttribute(
			"renderResponse");
		request = (HttpServletRequest)pageContext.getRequest();
		themeDisplay = (ThemeDisplay)pageContext.findAttribute("themeDisplay");
	}

	protected String currentURL;
	protected RenderResponse renderResponse;
	protected HttpServletRequest request;
	protected ThemeDisplay themeDisplay;

}