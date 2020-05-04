/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.control.menu.internal.categories;

import com.liferay.product.navigation.control.menu.ProductNavigationControlMenuCategory;
import com.liferay.product.navigation.control.menu.constants.ProductNavigationControlMenuCategoryKeys;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Julio Camarero
 */
@Component(
	immediate = true,
	property = {
		"product.navigation.control.menu.category.key=" + ProductNavigationControlMenuCategoryKeys.ROOT,
		"product.navigation.control.menu.category.order:Integer=100"
	},
	service = ProductNavigationControlMenuCategory.class
)
public class SitesProductNavigationControlMenuCategory
	implements ProductNavigationControlMenuCategory {

	@Override
	public String getKey() {
		return ProductNavigationControlMenuCategoryKeys.SITES;
	}

	@Override
	public boolean hasAccessPermission(HttpServletRequest httpServletRequest) {
		return true;
	}

}