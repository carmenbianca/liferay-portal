/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.search.admin.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItemList;

/**
 * @author Adam Brandizzi
 */
public class SearchAdminDisplayContext {

	public NavigationItemList getNavigationItemList() {
		return _navigationItemList;
	}

	public String getSelectedTab() {
		return _selectedTab;
	}

	public void setNavigationItemList(NavigationItemList navigationItemList) {
		_navigationItemList = navigationItemList;
	}

	public void setSelectedTab(String selectedTab) {
		_selectedTab = selectedTab;
	}

	private NavigationItemList _navigationItemList;
	private String _selectedTab;

}