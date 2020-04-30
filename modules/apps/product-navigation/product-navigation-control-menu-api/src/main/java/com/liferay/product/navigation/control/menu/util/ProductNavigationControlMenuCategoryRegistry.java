/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.control.menu.util;

import com.liferay.product.navigation.control.menu.ProductNavigationControlMenuCategory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lance Ji
 */
public interface ProductNavigationControlMenuCategoryRegistry {

	public List<ProductNavigationControlMenuCategory>
		getProductNavigationControlMenuCategories(
			String productNavigationControlMenuCategoryKey);

	public List<ProductNavigationControlMenuCategory>
		getProductNavigationControlMenuCategories(
			String productNavigationControlMenuCategoryKey,
			HttpServletRequest httpServletRequest);

}