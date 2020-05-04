/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.taglib.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.GetterUtil;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Eudaldo Alonso
 */
public class SiteBrowserManagementToolbarDisplayContext
	extends SearchContainerManagementToolbarDisplayContext {

	public SiteBrowserManagementToolbarDisplayContext(
		HttpServletRequest httpServletRequest,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		SiteBrowserDisplayContext siteBrowserDisplayContext) {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			siteBrowserDisplayContext.getSearchContainer());

		_siteBrowserDisplayContext = siteBrowserDisplayContext;
	}

	@Override
	public String getClearResultsURL() {
		PortletURL clearResultsURL = getPortletURL();

		clearResultsURL.setParameter("keywords", StringPool.BLANK);

		return clearResultsURL.toString();
	}

	@Override
	public String getSearchActionURL() {
		PortletURL searchActionURL = getPortletURL();

		return searchActionURL.toString();
	}

	@Override
	public Boolean isSelectable() {
		return false;
	}

	@Override
	public Boolean isShowSearch() {
		return GetterUtil.getBoolean(
			request.getAttribute("liferay-site:site-browser:showSearch"));
	}

	@Override
	protected String getDisplayStyle() {
		return _siteBrowserDisplayContext.getDisplayStyle();
	}

	@Override
	protected String[] getDisplayViews() {
		return new String[] {"list", "descriptive", "icon"};
	}

	@Override
	protected String[] getNavigationKeys() {
		return new String[] {"all"};
	}

	@Override
	protected String[] getOrderByKeys() {
		return new String[] {"name", "type"};
	}

	private final SiteBrowserDisplayContext _siteBrowserDisplayContext;

}