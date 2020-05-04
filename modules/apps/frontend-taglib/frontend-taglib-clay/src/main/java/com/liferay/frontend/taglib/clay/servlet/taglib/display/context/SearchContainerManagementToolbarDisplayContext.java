/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.frontend.taglib.clay.servlet.taglib.display.context;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Drew Brokke
 */
public class SearchContainerManagementToolbarDisplayContext
	extends BaseManagementToolbarDisplayContext {

	public SearchContainerManagementToolbarDisplayContext(
		HttpServletRequest httpServletRequest,
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		SearchContainer searchContainer) {

		super(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse);

		this.searchContainer = searchContainer;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #SearchContainerManagementToolbarDisplayContext(
	 *             HttpServletRequest, LiferayPortletRequest,
	 *             LiferayPortletResponse, SearchContainer)}
	 */
	@Deprecated
	public SearchContainerManagementToolbarDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest httpServletRequest,
		SearchContainer searchContainer) {

		this(
			httpServletRequest, liferayPortletRequest, liferayPortletResponse,
			searchContainer);
	}

	@Override
	public int getItemsTotal() {
		return searchContainer.getTotal();
	}

	@Override
	public String getSearchContainerId() {
		return searchContainer.getId(request, getNamespace());
	}

	@Override
	public Boolean isDisabled() {
		if (getItemsTotal() == 0) {
			return true;
		}

		return false;
	}

	@Override
	protected String getOrderByCol() {
		return searchContainer.getOrderByCol();
	}

	@Override
	protected String getOrderByColParam() {
		return searchContainer.getOrderByColParam();
	}

	@Override
	protected String getOrderByType() {
		return searchContainer.getOrderByType();
	}

	@Override
	protected String getOrderByTypeParam() {
		return searchContainer.getOrderByTypeParam();
	}

	protected SearchContainer searchContainer;

}