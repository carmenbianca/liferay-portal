/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.site.navigation.type;

import com.liferay.site.navigation.model.SiteNavigationMenuItem;

import java.util.List;

/**
 * @author Lance Ji
 */
public interface SiteNavigationMenuItemTypeRegistry {

	public SiteNavigationMenuItemType getSiteNavigationMenuItemType(
		SiteNavigationMenuItem siteNavigationMenuItem);

	public SiteNavigationMenuItemType getSiteNavigationMenuItemType(
		String type);

	public List<SiteNavigationMenuItemType> getSiteNavigationMenuItemTypes();

	public String[] getTypes();

}