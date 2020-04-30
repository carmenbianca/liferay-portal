/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.product.navigation.product.menu.web.internal.portlet;

import com.liferay.admin.kernel.util.PortalProductMenuApplicationType;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.ViewPortletProvider;
import com.liferay.product.navigation.product.menu.constants.ProductNavigationProductMenuPortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = "model.class.name=" + PortalProductMenuApplicationType.ProductMenu.CLASS_NAME,
	service = ViewPortletProvider.class
)
public class ProductNavigationProductMenuViewPortletProvider
	extends BasePortletProvider implements ViewPortletProvider {

	@Override
	public String getPortletName() {
		return ProductNavigationProductMenuPortletKeys.
			PRODUCT_NAVIGATION_PRODUCT_MENU;
	}

}