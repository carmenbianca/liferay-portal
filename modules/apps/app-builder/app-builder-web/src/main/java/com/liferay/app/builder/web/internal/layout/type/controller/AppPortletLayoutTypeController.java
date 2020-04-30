/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.app.builder.web.internal.layout.type.controller;

import com.liferay.layout.type.controller.BaseLayoutTypeControllerImpl;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.io.unsync.UnsyncStringWriter;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.taglib.servlet.PipingServletResponse;

import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gabriel Albuquerque
 */
public class AppPortletLayoutTypeController
	extends BaseLayoutTypeControllerImpl {

	public AppPortletLayoutTypeController() {
	}

	public AppPortletLayoutTypeController(
		ServletContext servletContext, String appName, String portletName) {

		this.servletContext = servletContext;

		_url = StringBundler.concat(
			"${liferay:mainPath}/portal/layout?p_l_id=${liferay:plid}&",
			"p_p_state=pop_up&appName=", appName, "&portletName=", portletName);
	}

	@Override
	public String getType() {
		return LayoutConstants.TYPE_PORTLET;
	}

	@Override
	public String getURL() {
		return _url;
	}

	@Override
	public boolean isBrowsable() {
		return false;
	}

	@Override
	public boolean isFirstPageable() {
		return true;
	}

	@Override
	public boolean isFullPageDisplayable() {
		return false;
	}

	@Override
	public boolean isInstanceable() {
		return false;
	}

	@Override
	public boolean isParentable() {
		return false;
	}

	@Override
	public boolean isSitemapable() {
		return false;
	}

	@Override
	public boolean isURLFriendliable() {
		return true;
	}

	@Override
	protected ServletResponse createServletResponse(
		HttpServletResponse httpServletResponse,
		UnsyncStringWriter unsyncStringWriter) {

		return new PipingServletResponse(
			httpServletResponse, unsyncStringWriter);
	}

	@Override
	protected String getEditPage() {
		return _VIEW_PAGE;
	}

	@Override
	protected String getViewPage() {
		return _VIEW_PAGE;
	}

	private static final String _VIEW_PAGE = "/layout/view.jsp";

	private String _url;

}