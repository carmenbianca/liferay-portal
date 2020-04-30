/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.control.menu.util;

import com.liferay.product.navigation.control.menu.ProductNavigationControlMenuCategory;
import com.liferay.product.navigation.control.menu.ProductNavigationControlMenuEntry;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lance Ji
 */
public interface ProductNavigationControlMenuEntryRegistry {

	public List<ProductNavigationControlMenuEntry>
		getProductNavigationControlMenuEntries(
			ProductNavigationControlMenuCategory
				productNavigationControlMenuCategory);

	public List<ProductNavigationControlMenuEntry>
		getProductNavigationControlMenuEntries(
			ProductNavigationControlMenuCategory
				productNavigationControlMenuCategory,
			HttpServletRequest httpServletRequest);

}