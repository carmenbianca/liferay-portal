/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.taglib.servlet.taglib;

import com.liferay.asset.taglib.internal.servlet.ServletContextUtil;
import com.liferay.taglib.util.IncludeTag;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * @author Julio Camarero
 */
public class CategorizationFilterTag extends IncludeTag {

	public String getAssetType() {
		return _assetType;
	}

	public PortletURL getPortletURL() {
		return _portletURL;
	}

	public void setAssetType(String assetType) {
		_assetType = assetType;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		super.setPageContext(pageContext);

		servletContext = ServletContextUtil.getServletContext();
	}

	public void setPortletURL(PortletURL portletURL) {
		_portletURL = portletURL;
	}

	@Override
	protected void cleanUp() {
		super.cleanUp();

		_assetType = null;
		_portletURL = null;
	}

	@Override
	protected String getPage() {
		return _PAGE;
	}

	@Override
	protected void setAttributes(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute(
			"liferay-asset:categorization-filter:assetType", _assetType);
		httpServletRequest.setAttribute(
			"liferay-asset:categorization-filter:portletURL", _portletURL);
	}

	private static final String _PAGE = "/categorization_filter/page.jsp";

	private String _assetType;
	private PortletURL _portletURL;

}