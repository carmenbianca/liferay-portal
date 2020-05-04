/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.asset.categories.selector.web.internal.portlet;

import com.liferay.asset.categories.selector.web.internal.contants.AssetCategoriesSelectorPortletKeys;
import com.liferay.portal.kernel.portlet.BasePortletProvider;
import com.liferay.portal.kernel.portlet.BrowsePortletProvider;

import org.osgi.service.component.annotations.Component;

/**
 * @author Antonio Pol
 */
@Component(
	immediate = true,
	property = "model.class.name=com.liferay.asset.kernel.model.AssetCategory",
	service = BrowsePortletProvider.class
)
public class AssetCategoriesSelectorBrowserPortletProvider
	extends BasePortletProvider implements BrowsePortletProvider {

	@Override
	public String getPortletName() {
		return AssetCategoriesSelectorPortletKeys.ASSET_CATEGORIES_SELECTOR;
	}

}