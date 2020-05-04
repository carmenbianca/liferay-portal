/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.roles.item.selector.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Alessio Antonio Rendina
 */
public class RoleItemSelectorViewDisplayContext
	extends SearchContainerManagementToolbarDisplayContext {

	public RoleItemSelectorViewDisplayContext(
		HttpServletRequest httpServletRequest, String itemSelectedEventName,
		SearchContainer<Role> searchContainer,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			searchContainer);

		_itemSelectedEventName = itemSelectedEventName;
	}

	@Override
	public String getClearResultsURL() {
		PortletURL clearResultsURL = getPortletURL();

		clearResultsURL.setParameter("keywords", (String)null);

		return clearResultsURL.toString();
	}

	public String getItemSelectedEventName() {
		return _itemSelectedEventName;
	}

	@Override
	public String getSearchActionURL() {
		PortletURL portletURL = getPortletURL();

		return portletURL.toString();
	}

	public SearchContainer<Role> getSearchContainer() {
		return searchContainer;
	}

	@Override
	protected String[] getOrderByKeys() {
		return new String[] {"name", "description"};
	}

	private final String _itemSelectedEventName;

}